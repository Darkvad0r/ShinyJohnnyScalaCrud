package com.example.core.control
import com.example._
import org.elasticsearch.action.search.SearchResponse
import scala.concurrent._
import ExecutionContext.Implicits.global

class CrudController extends elastic4s
{
    def getFromElasticSearch (id:Integer) : Future[String] = {
        val result: Future[SearchResponse] = get
        result onFailure {
            case t: Throwable => println("An error has occured: " + t)
        }
        result map { response =>
            response.toString
        }
    }
}
