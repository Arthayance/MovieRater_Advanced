package com.nyp.sit.dit.it2107.movierater_advanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_movie_review.*

class MovieReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.review,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.optionSubmit) {
            var reviewText: String = reviewTextInput.text.toString()
            var ratingScore: Float = ratingInput.rating
            val returnIntent = Intent()
            returnIntent.putExtra("ReturnRating", ratingScore)
            returnIntent.putExtra("ReturnReviewText", reviewText)
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
