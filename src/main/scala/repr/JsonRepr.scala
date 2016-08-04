package repr

import models.{Cookie, User}

/**
  * Created by coldsauce on 8/4/16.
  */
object JsonRepr {
  case class CreateUserRepr(username: String, password: String, cookies: Vector[Cookie])
}
