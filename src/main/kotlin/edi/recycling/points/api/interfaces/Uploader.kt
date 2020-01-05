package edi.recycling.points.api


interface Uploader<T> {
    fun uploadSingleItem(item : T)
}