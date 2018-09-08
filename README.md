
Fuckin Simple TextView Scale Font Injection use Annotation
=================

Demo
-------
This is the sample app in action:
https://github.com/binhbt/FaFontAutoScaleDemo


[![https://img.youtube.com/vi/w9SiuWLal-4/0.jpg](http://img.youtube.com/vi/w9SiuWLal-4/0.jpg)](https://www.youtube.com/watch?v=w9SiuWLal-4 "Fucking Awesome Recyclerview")
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
        implementation 'com.github.binhbt:FaFontAutoScale:1.0.0'
    }


Register TextView for Scale:

```
        @FontAutoScale
        public TextView movieName;
```
 - `FontManager.bind(object);`: Class contain TextView

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



