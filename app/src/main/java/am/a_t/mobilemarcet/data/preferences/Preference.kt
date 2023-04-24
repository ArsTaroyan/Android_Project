package am.a_t.mobilemarcet.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.core.remove
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first

class Preference(context: Context) {
    private val dataStore = context.createDataStore("DataStoreAuthLogin")

    suspend fun setUser(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { login ->
            login[dataStoreKey] = value
        }
    }

    suspend fun getUser(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preference = dataStore.data.first()
        return preference[dataStoreKey]
    }

    suspend fun removeUser(key: String) {
        dataStore.edit {
            it.remove(preferencesKey<String>(key))
        }
    }

    companion object {
        const val USER_LOGIN = "user_login"
    }
}