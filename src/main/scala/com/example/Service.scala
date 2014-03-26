package com.example

import akka.actor.Actor
import spray.routing._
import com.example.core.control.CrudController

class ServiceActor extends Actor with Service {

  def actorRefFactory = context

  def receive = runRoute(routes)
}

trait Service extends HttpService {

  val crudController = new CrudController()

  val routes = {

      path("ads" / IntNumber) {
          id =>
              get {
                  ctx =>
                      ctx.complete(
                        crudController.getFromElasticSearch
                      )
              } ~ post {
                  ctx =>
                      ctx.complete(
                          crudController.postToElasticSearch
                      )
              } ~ put {
                  ctx =>
                      ctx.complete(
                          crudController.putToElasticSearch
                      )
              } ~ delete {
                  ctx =>
                      ctx.complete(
                          crudController.deleteFromElasticSearch
                      )
              }
      }
  }
}