package edi.recycling.points.api

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("edi.recycling.points.api")
                .mainClass(Application.javaClass)
                .start()
    }
}