package com.example.gallery


class TemporaryClass {

    var pictures: MutableList<Picture> = mutableListOf()

    fun addPictures() {
        pictures.add(Picture("kot", "super", 4, R.drawable.kot))
        pictures.add(Picture("pies", "niefajne", 2, R.drawable.pies))
        pictures.add(Picture("alpy", "superjestto", 1, R.drawable.alpy))
        pictures.add(Picture("droga", "fajne", 0, R.drawable.droga))
        pictures.add(Picture("zaba", "super", 5, R.drawable.zaba))
    }


    fun selector(p: Picture): Int = p.rating


    fun sortPictures() {
//        pictures.sortWith(compareBy { it.rating })
        pictures.sortByDescending { selector(it) }
        pictures.forEach { println(it) }

    }


    //pobieranie i tworzenie listy zdjęć
    //sortowanie
}