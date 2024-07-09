package com.xco3.androidinicio.settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xco3.androidinicio.R
import com.xco3.androidinicio.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

//para crear funciones de extension
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val BLUETOOTH = "bluetooth"
        const val VIBRATION = "vibration"
        const val DARKMODE = "darkmode"
    }

    private lateinit var binding: ActivitySettingsBinding
    private var firstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { setting ->
                if (setting != null) {
                    runOnUiThread {
                        binding.swichtVibration.isChecked = setting.vibration
                        binding.swichtBluetooh.isChecked = setting.bluetooh
                        binding.swichtDarkMode.isChecked = setting.darkmode
                        binding.rsVolume.setValues(setting.volume.toFloat())
                        firstTime = !firstTime
                    }
                }
            }
        }

        initUI()
    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }
        binding.swichtBluetooh.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveCheck(BLUETOOTH, value)
            }
        }
        binding.swichtVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveCheck(VIBRATION, value)
            }
        }
        binding.swichtDarkMode.setOnCheckedChangeListener { _, value ->

            if (value) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveCheck(DARKMODE, value)
            }
        }
    }

    private suspend fun saveVolume(value: Int) {
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveCheck(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettings(): Flow<SettingsMode> {
        return dataStore.data.map { preferences ->
            SettingsMode(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 69,
                bluetooh = preferences[booleanPreferencesKey(BLUETOOTH)] ?: true,
                vibration = preferences[booleanPreferencesKey(VIBRATION)] ?: false,
                darkmode = preferences[booleanPreferencesKey(DARKMODE)] ?: true,
            )
        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}