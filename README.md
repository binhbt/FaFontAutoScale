
Fuckin Awesome Bus - Fuckin Simple Bus
=================

Fucking Simple Bus implement Observer Pattern
![Demo](https://github.com/binhbt/FaBus/raw/master/observer.png)

Demo
-------
This is the sample app in action:
https://github.com/binhbt/FaBusDemo


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
Add a dependency to your `build.gradle`:

    dependencies {
        implementation 'com.github.binhbt:FaBus:$1.0.2'
    }


Register Event for Subcribers:

```
FaBus.getDefault().registerEvent(new OnEventReceived() {
            @Override
            public void onEventReceived(Object event) {
            }
        }, TAG);
```
 - `FaBus.getDefault().unRegisterEvent(TAG);`: Remove subcribe
 - `FaBus.getDefault().postEvent("Message");`: Send an event
 

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



