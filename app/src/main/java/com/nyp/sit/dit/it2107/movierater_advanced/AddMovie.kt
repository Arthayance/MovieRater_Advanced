package com.nyp.sit.dit.it2107.movierater_advanced

import android.app.Application
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_add_movie.*
import com.nyp.sit.dit.it2107.movierater_advanced.MainActivity.Companion.movies

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movieadd, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menuSave) {
            var i: Int = getIntent().getIntExtra("movieID", 0)
            if (movie_name.text.toString() == "") {
                movie_name.setError("Name is required")
            }
            if (description.text.toString() == "") {
                description.setError("Description is required!")
            }
            if (release_date.text.toString() == "") {
                release_date.setError("Release date is required!")
            }
            if ((movie_name.text.toString() != "") && (description.text.toString() != "") && (release_date.text.toString() != "")) {
                var id: Int = rg1.checkedRadioButtonId
                var mName: String = movie_name.text.toString()
                var mDesc: String = description.text.toString()
                var releaseDate: String = release_date.text.toString()
                val language: RadioButton = findViewById(id)
                var mLanguage: String = language.text.toString()
                var audience: Boolean = language.isChecked()
                var audienceLang: Boolean = checkbox_language.isChecked()
                var audienceViolence: Boolean = checkbox_violence.isChecked()
                var defaultRating: Float = 0.00F
                var defaultReviewText: String = ""
                val newMovieClass = MovieItems(mName, mDesc, releaseDate, defaultRating, defaultReviewText,
                    mLanguage, audience, audienceLang, audienceViolence)
                Log.d("TestClass1", "Eh?")
                Log.d("TestClass", mName)
                movies.add(newMovieClass)

                val intent = Intent(this, MovieDetails::class.java)
                intent.putExtra("movieID", i)
                startActivity(intent)
            }
        }
        if (item?.itemId == R.id.reset) {
            movie_name.text.clear()
            description.text.clear()
            release_date.text.clear()
            var id: Int = rg1.checkedRadioButtonId
            val language: RadioButton = findViewById(id)
            language.isChecked = false




        }
        return super.onOptionsItemSelected(item)
    }
}
