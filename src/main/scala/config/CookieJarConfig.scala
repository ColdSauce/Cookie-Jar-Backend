package config

/**
  * Created by coldsauce on 8/4/16.
  */

import slick.driver.MySQLDriver.api._
case class CookieJarConfig(database: Database)

object CookieJarConfig {
  def createFromConfigFile(configFileName: String) = {
    new CookieJarConfig(Database.forConfig("db"))
  }
}


