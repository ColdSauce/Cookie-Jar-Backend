package models

/**
  * Created by coldsauce on 8/4/16.
  */
case class User(username: String, password: String)

import models.Cookie.CookieTable
import slick.driver.MySQLDriver.api._

object User {

  def tupled = (User.apply _).tupled
  class UserTable(tag: Tag) extends Table[User](tag, "Users") {
    def username = column[String]("Username", O.PrimaryKey)
    def password = column[String]("Password")
    def * = (username, password) <> (User.tupled, User.unapply)
  }
  object UserTable {
    val users = TableQuery[UserTable]
  }
}
