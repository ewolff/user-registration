package com.ewolff.user_registration.gatling

import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.Headers.Names._
import io.gatling.http.Headers.Values._
import scala.concurrent.duration._
import bootstrap._
import assertions._
import org.springframework.boot.SpringApplication
import com.ewolff.user_registration.RegistrationApplication

class UserRegistration extends Simulation {

  val emailFeeder = new Feeder[String] {

    override def hasNext = true

    override def next: Map[String, String] = {
      val email = scala.math.abs(java.util.UUID.randomUUID.getMostSignificantBits) + "_gatling@dontsend.com"
      Map("email" -> email)
    }
  }

  val httpProtocol = http
    .baseURL("http://127.0.0.1:8080")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en,en-us;q=0.5")
    .connection("keep-alive").
    baseHeaders(Map("Cache-Control" -> "max-age=0"))


  val formHeader = Map(
    "Content-Type" -> "application/x-www-form-urlencoded")

  val scn = scenario("Registration")
    .repeat(10) {
      (
        exec(http("GET index")
          .get("/"))
        .pause(88 milliseconds)
        .exec(http("GET css")
          .get("/css/bootstrap.min.css"))
        .pause(1)
        .exec(http("GET form")
          .get("/user"))
        .pause(7)
        .feed(emailFeeder)
        .exec(http("POST user data")
          .post("/user")
          .headers(formHeader)
          .param("firstname", "Eberhard")
          .param("name", "Wolff")
          .param("email", "${email}"))
        .pause(4)
        .exec(http("POST delete user")
          .post("/userdelete")
          .headers(formHeader)
          .param("email", "${email}")))
    }

  SpringApplication.run(classOf[RegistrationApplication])
  setUp(scn.inject(ramp(5 users) over (10 seconds))).protocols(httpProtocol)
}