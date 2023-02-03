package com.aplication.mvvmexample.data

import com.aplication.mvvmexample.data.database.dao.QuoteDao
import com.aplication.mvvmexample.data.database.entities.QuoteEntity
import com.aplication.mvvmexample.data.model.QuoteModel
import com.aplication.mvvmexample.data.network.QuoteService
import com.aplication.mvvmexample.domain.model.Quote
import com.aplication.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}