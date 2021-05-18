# Typed Preferences

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pro.labster/typedpreferences/badge.svg)](https://maven-badges.herokuapp.com/maven-central/pro.labster/typedpreferences)

A small library that helps you to store typed preferences in `SharedPreferences`.

## Requirements

- Min Version >= 21

## Installation

Add dependency to your module's (usually `app/build.gradle`) `build.gradle` and sync:

```groovy
implementation 'pro.labster.typedpreferences:(insert latest version)'
```

## Usage

### Boolean

```kotlin
val booleanPreference: BooleanPreference = BooleanPreferenceImpl(context, "boolean_name")
booleanPreference.put(true)
val value = booleanPreference.get() ?: false
```

### Float

```kotlin
val floatPreference: FloatPreference = FloatPreferenceImpl(context, "float_name")
floatPreference.put(1.337f)
val value = floatPreference.get() ?: 0f
```

### Int

```kotlin
val intPreference: IntPreference = IntPreferenceImpl(context, "int_name")
intPreference.put(1337)
val value = intPreference.get() ?: 0
```

### Long

```kotlin
val longPreference: LongPreference = LongPreferenceImpl(context, "long_name")
longPreference.put(1337L)
val value = longPreference.get() ?: 0L
```

### String

```kotlin
val stringPreference: StringPreference = StringPreferenceImpl(context, "string_name")
stringPreference.put("test")
val value = stringPreference.get() ?: "default"
```

### StringSet

```kotlin
val stringSetPreference: StringSetPreference = StringSetPreferenceImpl(context, "string_set_name")
stringSetPreference.put(setOf("test", "test2"))
val value = stringSetPreference.get() ?: emptySet()
```

### OR

You can also extend the classes like this:

```kotlin
interface CustomBooleanPreference : BooleanPreference

class CustomBooleanPreferenceImpl(
    context: Context
) : BooleanPreferenceImpl(context, NAME) {

    private companion object {
        private const val NAME = "custom_name"
    }
}
```

## TODO

- Add tests
- Add generic objects support

## Credits

Author: [Artem Smirnov](https://smirnov.page) at [Labster.PRO](https://labster.pro)

## License

```
Copyright (C) 2021 Artem Smirnov @ Labster.PRO

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```