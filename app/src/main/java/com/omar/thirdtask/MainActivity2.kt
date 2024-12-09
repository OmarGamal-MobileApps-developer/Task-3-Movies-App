package com.omar.thirdtask

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var username: String
    private lateinit var moviesList: MutableList<Movie>
    private lateinit var adapter: MoviesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // استرجاع الاسم من الـ Intent
        username = intent.getStringExtra("username") ?: "Guest"

        // تعيين النص في الـ TextView
        val welcomeTextView: TextView = findViewById(R.id.textView)
        welcomeTextView.text = "Welcome, $username"

        // إعداد قائمة الأفلام
        moviesList = mutableListOf(
            Movie("The Shawshank Redemption", "Two imprisoned men bond over several years.", "9.3", R.drawable.shawshank_image),
            Movie("The Dark Knight", "Batman faces the Joker in Gotham City.", "9.0", R.drawable.dark_knight_image),
            Movie("Inception", "A thief who enters dreams to steal secrets.", "8.8", R.drawable.inception_image)
        )

        // إعداد الـ RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MoviesAdapter(moviesList)
        recyclerView.adapter = adapter

        // زر "More" لإضافة المزيد من الأفلام
        val moreButton: Button = findViewById(R.id.more_button)
        moreButton.setOnClickListener {
            val additionalMovies = listOf(
                Movie("Forrest Gump", "The life story of a slow-witted but kind-hearted man.", "8.8", R.drawable.forrest_gump_image),
                Movie("Fight Club", "An insomniac office worker and a soap maker form an underground club.", "8.8", R.drawable.fight_club_image)
            )
            moviesList.addAll(additionalMovies)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()  // لإغلاق التطبيق تمامًا
    }
}
