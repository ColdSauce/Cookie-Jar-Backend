package resources


import config.CookieJarConfig
import models.User
import org.http4s._, org.http4s.dsl._
import org.http4s.headers.`Content-Type`
import org.http4s.server.blaze._

import org.http4s.MediaType._
import repr.JsonRepr.CreateUserRepr
import service.DatabaseService
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scalaz.concurrent.Task
import io.circe.{Decoder, Encoder}
import org.http4s.Response
import org.http4s.dsl._

import scala.concurrent.duration._
import scalaz.\/
import io.circe.generic.auto._
/**
  *
  * Created by coldsauce on 8/4/16.
  */
class CookieJarResource(databaseService: DatabaseService) {
  val Port = 8081
  val Url = "localhost"

  implicit def circeJsonDecoder[A](implicit decoder: Decoder[A]) = org.http4s.circe.jsonOf[A]
  implicit def circeJsonEncoder[A](implicit encoder: Encoder[A]) = org.http4s.circe.jsonEncoderOf[A]

  val createUserService = HttpService {
    case req @ POST -> Root / "createUser" =>
      req.decode[CreateUserRepr](repr => {
        val user = new User(repr.username, repr.password)
        databaseService.insertUser(user)
        repr.cookies.foreach(cookie => databaseService.insertCookie(cookie))
        Ok("Got it to work!")
      })
  }


  val services = createUserService

  val builder = BlazeBuilder.bindHttp(8081, "localhost").mountService(services, "/")

  def runServer() = {
    builder.run
  }
}

object CookieJarResource {
  def createWithDatabaseService(dbService: DatabaseService): CookieJarResource = {
    new CookieJarResource(dbService)
  }
}
