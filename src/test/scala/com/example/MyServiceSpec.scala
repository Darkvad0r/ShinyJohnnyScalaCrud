package com.example

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._



class ServiceSpec extends Specification with Specs2RouteTest with Service {
  def actorRefFactory = system
  
  "Service" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> routes ~> check {
        responseAs[String] must contain("Say hello")
      }
    }
  }
}
