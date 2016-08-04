package models

/**
  * Created by coldsauce on 8/4/16.
  */
case class Cookie(username: String, baseUrl: String, cookieContents: String)

import models.User.UserTable
import slick.driver.MySQLDriver.api._

object Cookie {
  def tupled = (Cookie.apply _).tupled
  class CookieTable(tag: Tag) extends Table[Cookie](tag, "Cookies") {
    def username = column[String]("username", O.PrimaryKey)
    def baseUrl = column[String]("baseUrl")
    def cookieContents = column[String]("CookieContents")
    def users = foreignKey("cookiesFK", username,  UserTable.users)(_.username)
    def * = (username, baseUrl, cookieContents) <> (Cookie.tupled, Cookie.unapply)
  }
  object CookieTable {
    val cookies = TableQuery[CookieTable]
  }
}
