package com.example

import com.sksamuel.elastic4s.ElasticClient
import com.sksamuel.elastic4s.ElasticDsl._
import scala.concurrent._
import org.elasticsearch.action.search.SearchResponse

trait elastic4s {

    def get: Future[SearchResponse] = {
        val client = ElasticClient.remote("127.0.0.1", 9201)
        client execute { search in "ads"->"categories" }
    }

    def delete: String = {
        "DELETE received \n"
    }

    def put: String = {
        "PUT received\n"
    }

    def post: String = {
        "POST received\n"
    }
}
