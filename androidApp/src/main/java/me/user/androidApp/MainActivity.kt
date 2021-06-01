package me.user.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.user.shared.ConferencesRepository
import me.user.shared.ConferencesSource
import me.user.shared.GetConferencesUseCase
import me.user.shared.Greeting
fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        val getConferences = GetConferencesUseCase(ConferencesRepository(ConferencesSource()))

        GlobalScope.launch(Dispatchers.Main) {
            tv.text = getConferences().toString()
        }
    }
}
