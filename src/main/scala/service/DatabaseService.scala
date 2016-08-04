package service

import config.CookieJarConfig
import models.Cookie.CookieTable
import models.{Cookie, User}
import models.User.UserTable
import slick.driver.JdbcDriver

import slick.driver.MySQLDriver.api._
/**
  * Created by coldsauce on 8/4/16.
  */
class DatabaseService(database: Database) {
  def createSchema()= {
    database.run((UserTable.users.schema ++ CookieTable.cookies.schema).create)
  }
  def insertUser(user: User) = {
    database.run(UserTable.users.insertOrUpdate(user))
  }
  def insertCookie(cookie: Cookie) = {
    database.run(CookieTable.cookies.insertOrUpdate((cookie)))
  }
}

object DatabaseService {
  def createFromConfig(config: CookieJarConfig): DatabaseService = {
    new DatabaseService(config.database)
  }
}
