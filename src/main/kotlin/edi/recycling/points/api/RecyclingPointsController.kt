package edi.recycling.points.api

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/recyclingPoints")
class RecyclingPointsController {

    @Value("\${vars.bucket_name}")
    lateinit var bucketName: String

    @Value("\${vars.json_name}")
    lateinit var jsonName: String

    private val s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.EU_WEST_1).build()

    @ExperimentalStdlibApi
    @Get("/")
    fun index() = s3Client.getObject(bucketName, jsonName)
            .objectContent
            .readBytes()
            .decodeToString()
}