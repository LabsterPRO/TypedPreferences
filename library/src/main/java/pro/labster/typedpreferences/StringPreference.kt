package pro.labster.typedpreferences

import android.content.Context

interface StringPreference : BasePreference<String>

open class StringPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<String>(context, name), StringPreference {

    override fun get(): String? {
        return if (sharedPreferences.contains(name)) {
            sharedPreferences.getString(getKey(), DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: String) {
        sharedPreferences
            .edit()
            .putString(getKey(), value)
            .apply()
    }

    private companion object {
        private val DEFAULT_VALUE = null
    }
}
