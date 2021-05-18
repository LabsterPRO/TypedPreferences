package pro.labster.typedpreferences.app

import android.app.Activity
import android.content.Context
import pro.labster.typedpreferences.BooleanPreference
import pro.labster.typedpreferences.BooleanPreferenceImpl
import pro.labster.typedpreferences.FloatPreference
import pro.labster.typedpreferences.FloatPreferenceImpl
import pro.labster.typedpreferences.IntPreference
import pro.labster.typedpreferences.IntPreferenceImpl
import pro.labster.typedpreferences.LongPreference
import pro.labster.typedpreferences.LongPreferenceImpl
import pro.labster.typedpreferences.StringPreference
import pro.labster.typedpreferences.StringPreferenceImpl
import pro.labster.typedpreferences.StringSetPreference
import pro.labster.typedpreferences.StringSetPreferenceImpl

class ExampleActivity : Activity() {

    fun booleanPreferenceExample() {
        val booleanPreference: BooleanPreference = BooleanPreferenceImpl(this, "boolean_name")
        booleanPreference.put(true)
        val value = booleanPreference.get() ?: false
    }

    fun floatPreferenceExample() {
        val floatPreference: FloatPreference = FloatPreferenceImpl(this, "float_name")
        floatPreference.put(1.337f)
        val value = floatPreference.get() ?: 0f
    }

    fun intPreferenceExample() {
        val intPreference: IntPreference = IntPreferenceImpl(this, "int_name")
        intPreference.put(1337)
        val value = intPreference.get() ?: 0
    }

    fun longPreferenceExample() {
        val longPreference: LongPreference = LongPreferenceImpl(this, "long_name")
        longPreference.put(1337L)
        val value = longPreference.get() ?: 0L
    }

    fun stringPreferenceExample() {
        val stringPreference: StringPreference = StringPreferenceImpl(this, "string_name")
        stringPreference.put("test")
        val value = stringPreference.get() ?: "default"
    }

    fun stringSetPreferenceExample() {
        val stringSetPreference: StringSetPreference = StringSetPreferenceImpl(this, "string_set_name")
        stringSetPreference.put(setOf("test", "test2"))
        val value = stringSetPreference.get() ?: emptySet()
    }

    /**
     * Custom class
     */

    interface CustomBooleanPreference: BooleanPreference

    class CustomBooleanPreferenceImpl(
        context: Context
    ): BooleanPreferenceImpl(context, NAME) {

        private companion object {
            private const val NAME = "custom_name"
        }
    }
}