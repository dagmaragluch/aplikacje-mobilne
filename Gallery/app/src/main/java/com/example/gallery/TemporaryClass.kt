package com.example.gallery


class TemporaryClass {

    var pictures: MutableList<Picture> = mutableListOf()

    fun addPictures() {
        pictures.add(Picture("kot", "bardzo ładny kot", 4, R.drawable.kot))
        pictures.add(Picture("pies", "niefajne", 2, R.drawable.pies))
        pictures.add(Picture("alpy", "super jest to", 1, R.drawable.alpy))
        pictures.add(Picture("droga", "fajne", 0, R.drawable.droga))
        pictures.add(Picture("zaba", "super", 5, R.drawable.zaba))
    }


    fun selector(p: Picture): Int = p.rating


    fun sortPictures() {
        pictures.sortByDescending { selector(it) }
       // pictures.forEach { println(it) }
    }

}