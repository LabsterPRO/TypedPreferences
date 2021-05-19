package pro.labster.typedpreferences

import android.content.Context

interface BooleanPreference : BasePreference<Boolean>

open class BooleanPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Boolean>(context, name), BooleanPreference {

    override fun get(): Boolean? {
        return if (sharedPreferences.contains(key)) {
            sharedPreferences.getBoolean(key, DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(key, value)
            .apply()
    }

    private companion object {
        private const val DEFAULT_VALUE = false
    }
}
