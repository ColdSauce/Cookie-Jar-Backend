import config.CookieJarConfig
import org.apache.log4j.BasicConfigurator
import resources.CookieJarResource
import service.DatabaseService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by coldsauce on 8/4/16.
  */
object Launcher {
  private def printHelp(): Unit = {
    //TODO: Make this use an actual logger.
    //AND make it have a legit message instead of something dumb..
    println("You need to put a config file in your argument!")
  }
  def main(args: Array[String]): Unit = {
    BasicConfigurator.configure();
    args.length match {
      case 0 => printHelp()
        return
      case 1 =>
        val cookieJarConfig = CookieJarConfig.createFromConfigFile(args(0))
        val dbService = DatabaseService.createFromConfig(cookieJarConfig)
//        Await.result(dbService.createSchema(), 5 seconds)
        val cookieJarResource = CookieJarResource.createWithDatabaseService(dbService)
        cookieJarResource.runServer().awaitShutdown()
    }

  }
}
