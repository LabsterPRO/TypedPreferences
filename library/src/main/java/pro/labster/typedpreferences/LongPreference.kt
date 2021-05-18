package pro.labster.typedpreferences

import android.content.Context

interface LongPreference : BasePreference<Long>

open class LongPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Long>(context, name), LongPreference {

    override fun get(): Long? {
        return if (sharedPreferences.contains(name)) {
            sharedPreferences.getLong(getKey(), DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Long) {
        sharedPreferences
            .edit()
            .putLong(getKey(), value)
            .apply()
    }

    private companion object {
        private const val DEFAULT_VALUE = 0L
    }
}
