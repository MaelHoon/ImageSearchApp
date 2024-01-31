package mael.hoon.imageserach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import mael.hoon.imageserach.data.Repository
import mael.hoon.imageserach.databinding.ActivityMainBinding
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fetchRandomPhotos()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun fetchRandomPhotos(query: String? = null) = scope.launch {
        Repository.getRandomPhotos(query)?.let{photos->
            photos
        }
    }
}