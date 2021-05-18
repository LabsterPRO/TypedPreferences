package pro.labster.typedpreferences

import android.content.Context

interface StringSetPreference : BasePreference<Set<String>>

open class StringSetPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Set<String>>(context, name), StringSetPreference {

    override fun get(): Set<String>? {
        return if (sharedPreferences.contains(name)) {
            sharedPreferences.getStringSet(getKey(), DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Set<String>) {
        sharedPreferences
            .edit()
            .putStringSet(getKey(), value)
            .apply()
    }

    private companion object {
        private val DEFAULT_VALUE = emptySet<String>()
    }
}
