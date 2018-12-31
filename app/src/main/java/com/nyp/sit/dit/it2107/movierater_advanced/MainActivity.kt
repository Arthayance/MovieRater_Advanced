package com.nyp.sit.dit.it2107.movierater_advanced

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Application
import android.content.Intent
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        var movieID: Int = 0
        var movies = arrayListOf<MovieItems>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iterator = movies
        for ((i, value) in iterator.withIndex()) {
            val newLayout = LinearLayout(this)
            val mainLayout = findViewById<LinearLayout>(R.id.linearlayout1)
            newLayout.orientation = LinearLayout.HORIZONTAL

            val imageIcon = ImageView(this)
            imageIcon.setImageResource(R.drawable.img1)
            newLayout.addView(imageIcon)
            val movieTextView = TextView(this)
            movieTextView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            movieTextView.id = i
            movieTextView.gravity = Gravity.CENTER
            Log.d("TestTitle", "Eh?")
            Log.d("TestTitle", movies[i].m_title)
            movieTextView.text = movies[i].m_title
            movieTextView.textSize = 15f
            movieTextView.isClickable = true
            movieTextView.visibility = View.VISIBLE
            newLayout.addView(movieTextView)
            mainLayout.addView(newLayout)
            movieTextView.setOnClickListener() {
                movieID = i
                Log.d("id???", movieID.toString())
                Log.d("id???", i.toString())
                var addMovie = Intent(this, MovieDetails::class.java)
                addMovie.putExtra("movieID", movieID)
                startActivity(addMovie)
            }
            registerForContextMenu(movieTextView)



        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menuBtnAdd) {
            val addMovie = Intent(this, AddMovie::class.java)
            startActivity(addMovie)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        for ((item, value) in movies.withIndex()) {
            if (v?.id == item) {
                menu?.add(1, 1001+item, 1, "Edit Movie")
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        var index = 0
        for (i in movies) {
            if (item?.itemId == 1001+index) {
                movieID = index
                val editMovie = Intent(this, EditMovie::class.java)
                startActivity(editMovie)
            }
            index += 1


        }
        return super.onContextItemSelected(item)
    }

}
