
Fuckin Simple Android TextView Scale Font Injection use Annotation
=================

Demo
-------
This is the sample app in action:
https://github.com/binhbt/FaFontAutoScaleDemo


[![https://img.youtube.com/vi/w9SiuWLal-4/0.jpg](http://img.youtube.com/vi/w9SiuWLal-4/0.jpg)](https://www.youtube.com/watch?v=w9SiuWLal-4 "Fucking Awesome Auto Scale Font")
Usage
-------
Add a dependency to your all project `build.gradle`:

    allprojects {
    repositories {
        google()
        maven { url "https://jitpack.io" }
    }
    }

-------
Add a dependency to your 
`build.gradle`:

    dependencies {
		compile 'com.github.binhbt.FaFontAutoScale:binder:1.1.1'
		annotationProcessor 'com.github.binhbt.FaFontAutoScale:compiler:1.1.1'
    }


Register TextView for Scale:

```
        @AutoScale
        TextView movieName;
```
 - `    FontBinding.bind(this)`: Class contain TextView
 - `    @AutoScale
public class ActivityScaleActivity  extends AppCompatActivity `
 - `	@AutoScale
public class FragmentDemo extends Fragment`
 -  Support binding for TextView, ViewGroup, WebView , Activity, Fragment, Dialog
 -  `  FontManager.getDefault().setScale(1.5f);` Set Scale rate
 - For Proguard
 ```
 -keep class com.leo.font.lib.annotations.Keep**
-keep @com.leo.font.lib.annotations.Keep public class *
-keepclassmembers @com.leo.font.lib.annotations.Keep class ** { *;}
```
Done!
 

Original License
-------

    Copyright 2018 leobui

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



