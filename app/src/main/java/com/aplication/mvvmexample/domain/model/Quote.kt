package com.aplication.mvvmexample.domain.model

import com.aplication.mvvmexample.data.database.entities.QuoteEntity
import com.aplication.mvvmexample.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)