package com.chelios.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chelios.newsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>   //suspend fun doesn't work with livedata

    @Delete
    suspend fun deleteArticle(article: Article)

}