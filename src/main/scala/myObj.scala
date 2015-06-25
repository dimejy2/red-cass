package people
import people._
import spray.json._

object myObj extends Application{

  val pfac = PersonFactory
  val writeFile = new StringToFile
  val redDb = RedisInterface

  val myJTree = pfac.getNJson(1000).parseJson


  for(_ <- 1 to 1000) {
    var personHold = pfac.getAPerson(1)
    println (personHold)
    redDb.writeToRedisWithExpire(personHold.name, personHold.age, 3000)
  }


  redDb.printPattern("*a*")


  /*val written = writeFile.writeToFile(f"${pfac.getName}.json", f"[ ${pfac.getNJson(10)} ]")*/

}
