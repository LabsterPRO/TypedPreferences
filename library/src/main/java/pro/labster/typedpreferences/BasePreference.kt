package pro.labster.typedpreferences

import android.content.Context
import android.content.SharedPreferences

interface BasePreference<T> {
    fun get(): T?
    fun put(value: T)
    fun delete()
}

abstract class BasePreferenceImpl<T>(
    context: Context,
    protected val name: String
) : BasePreference<T> {

    protected val sharedPreferences: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    protected val key: String = KEY

    override fun delete() {
        sharedPreferences
            .edit()
            .remove(key)
            .apply()
    }

    private companion object {
        private const val KEY = "key"
    }
}