package pro.labster.typedpreferences

import android.content.Context

interface IntPreference : BasePreference<Int>

open class IntPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Int>(context, name), IntPreference {

    override fun get(): Int? {
        return if (sharedPreferences.contains(key)) {
            sharedPreferences.getInt(key, DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Int) {
        sharedPreferences
            .edit()
            .putInt(key, value)
            .apply()
    }

    private companion object {
        private const val DEFAULT_VALUE = 0
    }
}
