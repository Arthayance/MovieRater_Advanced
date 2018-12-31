package com.nyp.sit.dit.it2107.movierater_advanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_edit_movie.*
import com.nyp.sit.dit.it2107.movierater_advanced.MainActivity.Companion.movies
import com.nyp.sit.dit.it2107.movierater_advanced.MainActivity.Companion.movieID
import kotlinx.android.synthetic.main.activity_add_movie.*

class EditMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)

        var i = movieID
        edit_movie_name.setText(movies[i].m_title)
        edit_description.setText(movies[i].m_overview)
        edit_release_date.setText(movies[i].m_release_date)
        edit_checkbox_audience.isChecked = movies[i].ageLimit
        edit_checkbox_language.isChecked = movies[i].reasonLanguage
        edit_checkbox_violence.isChecked = movies[i].reasonViolence
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movieadd, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var i = movieID
        if (edit_movie_name.text.toString() == "") {
            movie_name.setError("Name is required")
        }
        if (edit_description.text.toString() == "") {
            description.setError("Description is required!")
        }
        if (edit_release_date.text.toString() == "") {
            release_date.setError("Release date is required!")
        }
        if ((edit_movie_name.text.toString() != "") && (edit_description.text.toString() != "") && (edit_release_date.text.toString() != "")) {
            movies[i].m_title = edit_movie_name.text.toString()
            movies[i].m_overview = edit_description.text.toString()
            movies[i].m_release_date = edit_release_date.text.toString()
            movies[i].ageLimit = edit_checkbox_audience.isChecked()
            movies[i].reasonLanguage = edit_checkbox_language.isChecked()
            movies[i].reasonViolence = edit_checkbox_violence.isChecked()
            val MovieDesc = Intent(this, MovieDetails::class.java)
            startActivity(MovieDesc)
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
