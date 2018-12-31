package com.nyp.sit.dit.it2107.movierater_advanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import com.nyp.sit.dit.it2107.movierater_advanced.MainActivity.Companion.movies
import kotlinx.android.synthetic.main.activity_movie_details.*
import com.nyp.sit.dit.it2107.movierater_advanced.MainActivity.Companion.movieID

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        Log.d("TestMovies", "Eh?")
        var i: Int = movieID
        var audience = ""
        var lText = ""
        var vText = ""
        if (movies[i].ageLimit == false) {
            audience = "Yes"
        }
        else {
            audience = "No"
            if (movies[i].reasonLanguage == true) {
                lText = "Language"
            }
            if (movies[i].reasonViolence == true) {
                vText = "Violence"
            }
        }
        movie_title.text = movies[i].m_title + "\n"
        movie_description.text = movies[i].m_overview + "\n"
        language.text = movies[i].language + "\n"
        r_date.text = movies[i].m_release_date + "\n"
        audienceDisplay.text = audience + "(" + lText + " " + vText + ")" + "\n"

        registerForContextMenu(movie_reviews)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                movie_reviews.setVisibility(View.GONE)
                ratingDisplay.setVisibility(View.VISIBLE)
                reviewTextView.setVisibility(View.VISIBLE)
                reviewTextView.text = data?.getStringExtra("ReturnReviewText")
                val ratingValue: Float = data!!.getFloatExtra("ReturnRating", 0.00F)
                ratingDisplay.rating = ratingValue
            }
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.movie_reviews) {
            menu?.add(2, 1002, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1002) {
            val intent = Intent(this, MovieReview::class.java)
            startActivityForResult(intent, 1)
        }
        return super.onContextItemSelected(item)
    }
}

