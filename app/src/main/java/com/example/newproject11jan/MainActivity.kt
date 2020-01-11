package com.example.newproject11jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val movies = arrayOf("Iron Man", "Thor", "Captain America", "Doctor Strange", "Captain Marvel", "black Panther")
    val year = arrayOf("2008", " 2010", "2011", "2016", "2019", "2018")
    val actors = arrayOf("RDJ", "Chris", "Chris Evans", "Benedict", "Brie", "Chadwick")
    val images = arrayOf(R.drawable.iron_man_new,
        R.drawable.thor,
        R.drawable.doc_strange,
        R.drawable.cap_marvel,
        R.drawable.cap_america
    )

    val list = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0..100){
            val random = Random().nextInt(5)
            val movie = Movie(
                movies[random],
                year[random],
                actors[random],
                images[random]
            )
        }
        textview1.text = movies[0] + "(" + year[0] + ")"
        textview2.text = actors[0]
    }
}

data class Movie(
    val name: String,
    val year: String,
    val actor: String,
    val image: Int
)

class MovieAdapter(val movies: ArrayList<Movie>): BaseAdapter(){

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2!!.context).inflate(R.layout.item_list, p2, false)
        return view
    }

    override fun getItem(p0: Int): Any {
    return movies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount() = movies.size

}
