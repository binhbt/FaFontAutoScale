package com.leo.font.lib.compiler;

import java.util.HashSet;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class ProcessingUtils {

    private ProcessingUtils() {
        // not to be instantiated in public
    }

/*    public static Set<TypeElement> getTypeElementsToProcess(Set<? extends Element> elements,
                                                            Set<? extends Element> supportedAnnotations) {
        Set<TypeElement> typeElements = new HashSet<>();
        for (Element element : elements) {
            if (element instanceof TypeElement) {
                boolean found = false;
                for (Element subElement : element.getEnclosedElements()) {
                    for (AnnotationMirror mirror : subElement.getAnnotationMirrors()) {
                        for (Element annotation : supportedAnnotations) {
                            if (mirror.getAnnotationType().asElement().equals(annotation)) {
                                typeElements.add((TypeElement) element);
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                    if (found) break;
                }
            }
        }
        return typeElements;
    }*/

    public static Set<TypeElement> getTypeElementsToProcess(Set<? extends Element> elements,
                                                            Set<? extends Element> supportedAnnotations) {
        Set<TypeElement> typeElements = new HashSet<>();
        for (Element element : elements) {
            if (element instanceof TypeElement) {
                getTypeElementsToProcess(typeElements, element, supportedAnnotations);
            }
        }
        return typeElements;
    }
    private static Set<TypeElement> getTypeElementsToProcess(Set<TypeElement> typeElements, Element element,
                                                             Set<? extends Element> supportedAnnotations){
        boolean found = false;
        for (Element subElement : element.getEnclosedElements()) {
            for (AnnotationMirror mirror : subElement.getAnnotationMirrors()) {
                for (Element annotation : supportedAnnotations) {
                    if (mirror.getAnnotationType().asElement().equals(annotation)) {
                        typeElements.add((TypeElement) element);
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) break;
        }
        if (element.getEnclosedElements() != null && element.getEnclosedElements().size() >0)
            for (Element subElement : element.getEnclosedElements()) {
                if (subElement instanceof TypeElement)
                    getTypeElementsToProcess(typeElements, subElement, supportedAnnotations);
            }
        return typeElements;
    }
}
