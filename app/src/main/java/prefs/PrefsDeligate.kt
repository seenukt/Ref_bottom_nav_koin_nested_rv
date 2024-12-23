package prefs

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class PrefsDeligate() {

    companion object{
        var context: Context? = null
        fun initPreference(context: Context) {
             Companion.context = context
        }
    }

    private val prefs: SharedPreferences by lazy {
        if (context != null)
            context!!.getSharedPreferences(javaClass.simpleName, Context.MODE_PRIVATE)
        else
            throw IllegalStateException("Context was not initialized. Call Preferences.init(context) before using it")
    }

    inner class StringDeligate(private val keyName: String, private val defaultValue: String? = null  ):ReadWriteProperty<Any?,String?>{
        override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
           return prefs.getString(keyName,defaultValue)?: defaultValue
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
             prefs.edit().putString(keyName,value).apply()
        }

    }


}