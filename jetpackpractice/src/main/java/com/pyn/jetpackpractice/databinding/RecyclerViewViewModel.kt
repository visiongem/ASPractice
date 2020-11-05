package com.pyn.jetpackpractice.databinding

class RecyclerViewViewModel {

    fun getBooks(): List<Book> {

        var books = mutableListOf<Book>()
        for (index in 1..100) {
            val book = Book(
                "Android",
                "AAA",
                index,
                "https://static01.imgkr.com/temp/a5f0ff2e7ab741ffa49504c097b56fac.jpg"
            )
            books.add(book)
        }
        return books
    }

}