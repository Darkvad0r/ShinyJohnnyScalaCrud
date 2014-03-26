package com.example.core.control
import com.example._
import org.elasticsearch.action.search.SearchResponse
import scala.concurrent._
import scala.util.{Success, Failure}
import ExecutionContext.Implicits.global

class CrudController extends elastic4s
{

    def getFromElasticSearch (id:Integer) : Future[SearchResponse] = {
        val result: Future[SearchResponse] = get
        result onFailure {
            case t: Throwable => println("An error has occured: " + t)
        }
        result
    }
}
