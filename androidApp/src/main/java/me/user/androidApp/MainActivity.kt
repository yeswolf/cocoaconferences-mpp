package me.user.androidApp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.user.shared.*


fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.main_title)

        val lv: ListView = findViewById(R.id.conferenceListView)
        val getConferences = GetConferencesUseCase(ConferencesRepository(ConferencesSource()))

        GlobalScope.launch(Dispatchers.Main) {
            lv.adapter = ConferenceListAdapter(lv.context, getConferences())
        }
    }
}
