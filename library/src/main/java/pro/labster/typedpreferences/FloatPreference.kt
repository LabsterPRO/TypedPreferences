package pro.labster.typedpreferences

import android.content.Context

interface FloatPreference : BasePreference<Float>

open class FloatPreferenceImpl(
    context: Context,
    name: String
) : BasePreferenceImpl<Float>(context, name), FloatPreference {

    override fun get(): Float? {
        return if (sharedPreferences.contains(name)) {
            sharedPreferences.getFloat(getKey(), DEFAULT_VALUE)
        } else {
            null
        }
    }

    override fun put(value: Float) {
        sharedPreferences
            .edit()
            .putFloat(getKey(), value)
            .apply()
    }

    private companion object {
        private const val DEFAULT_VALUE = 0f
    }
}
