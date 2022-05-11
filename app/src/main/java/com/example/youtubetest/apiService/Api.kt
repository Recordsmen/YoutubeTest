package com.example.youtubetest.apiService

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException


object getHtml {

    fun getVideos(searchQuery:String): Flow<String> {
        val newList = mutableListOf<String>()
        try {
            val doc: Document = Jsoup.connect("https://www.youtube.com/results?search_query=$searchQuery").get()

            val videos:Elements = doc.select("a[href]")
            Log.i("Videos","Size" + videos.size)
            for (link in videos) {
                val g = link.absUrl("href")
                Log.i("Videos",g)
                newList.add(g)
            }
        } catch (e: IOException) {
        }
        return newList.asFlow()

    }
}
