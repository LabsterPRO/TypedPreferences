package pro.labster.typedpreferences

import android.content.Context

interface FloatPreference : BasePreference<Float>

open class FloatPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Float>(context, name), FloatPreference {

    override fun get(): Float? {
        return if (sharedPreferences.contains(key)) {
            sharedPreferences.getFloat(key, DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Float) {
        sharedPreferences
            .edit()
            .putFloat(key, value)
            .apply()
    }

    private companion object {
        private const val DEFAULT_VALUE = 0f
    }
}
