package com.leo.compiler.lib;

import com.leo.lib.annotations.AutoScale;
import com.leo.lib.annotations.IgnoreScale;
import com.leo.lib.annotations.Keep;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import sun.rmi.runtime.Log;


public class Processor extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
        elementUtils = processingEnv.getElementUtils();
    }

    /*
     * annotations: list of unique annotations that are getting processed
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {

            // find all the classes that uses the supported annotations
            Set<TypeElement> typeElements = ProcessingUtils.getTypeElementsToProcess(
                    roundEnv.getRootElements(),
                    annotations);

            // for each such class create a wrapper class for binding
            for (TypeElement typeElement : typeElements) {
                String packageName = elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
                String typeName = typeElement.getSimpleName().toString();
                ClassName className = ClassName.get(packageName, typeName);
                System.out.printf("Test", className.toString());
                ClassName generatedClassName = ClassName
                        .get(packageName, NameStore.getGeneratedClassName(typeName));

                // define the wrapper class
                TypeSpec.Builder classBuilder = TypeSpec.classBuilder(generatedClassName)
                        .addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Keep.class);

                // add constructor
                classBuilder.addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(className, NameStore.Variable.CONTAINER)
                        .addStatement("$N($N)",
                                NameStore.Method.BIND_FONTS,
                                NameStore.Variable.CONTAINER)
                        .build());
                ClassName fontManagerClassName = ClassName.get(
                        NameStore.Package.FONT_MANAGER,
                        NameStore.Class.FONT_MANAGER);
                // add method that maps the views with id
                MethodSpec.Builder bindViewsMethodBuilder = MethodSpec
                        .methodBuilder(NameStore.Method.BIND_FONTS)
                        .addModifiers(Modifier.PRIVATE)
                        .returns(void.class)
                        .addParameter(className, NameStore.Variable.CONTAINER);

                for (VariableElement variableElement : ElementFilter.fieldsIn(typeElement.getEnclosedElements())) {
                    AutoScale fontAutoScale = variableElement.getAnnotation(AutoScale.class);
                    if (fontAutoScale != null) {
                        if(fontAutoScale.isScale())
                        bindViewsMethodBuilder.addStatement("$T.applyScaleFont($N.$N)",
                                fontManagerClassName,
                                NameStore.Variable.CONTAINER,
                                variableElement.getSimpleName());
                    }
                    IgnoreScale fontIgnoreScale = variableElement.getAnnotation(IgnoreScale.class);
                    if (fontIgnoreScale != null) {
                        if(fontIgnoreScale.isIgnoreScale())
                            bindViewsMethodBuilder.addStatement("$T.applyScaleDownFont($N.$N)",
                                    fontManagerClassName,
                                    NameStore.Variable.CONTAINER,
                                    variableElement.getSimpleName());
                    }
                }
                classBuilder.addMethod(bindViewsMethodBuilder.build());

                // write the defines class to a java file
                try {
                    JavaFile.builder(packageName,
                            classBuilder.build())
                            .build()
                            .writeTo(filer);
                } catch (IOException e) {
                    messager.printMessage(Diagnostic.Kind.ERROR, e.toString(), typeElement);
                }
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new TreeSet<>(Arrays.asList(
                AutoScale.class.getCanonicalName(),
                IgnoreScale.class.getCanonicalName(),
                Keep.class.getCanonicalName()));
    }
}
