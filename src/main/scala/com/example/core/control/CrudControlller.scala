package com.example.core.control
import com.example._
import org.elasticsearch.action.search.SearchResponse
import scala.concurrent._
import scala.util.{Success, Failure}
import ExecutionContext.Implicits.global

class CrudController extends elastic4s
{

    def getFromElasticSearch : String = {
        val something: Future[SearchResponse] = get
        something onComplete {
            case Success(p) => println(p)
            case Failure(t) => println("An error has occured: " + t)
        }
        "GET received \n"
    }
    def postToElasticSearch: String = {
        post
    }
    def putToElasticSearch: String = {
        put
    }
    def deleteFromElasticSearch: String = {
        delete
    }
}
