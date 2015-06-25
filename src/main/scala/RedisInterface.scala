package people
import com.redis._

object RedisInterface {

    val r = new RedisClient("localhost", 6379)


    def writeToRedis(key : String, value : Any) = r.set(key, value)

    def setExpire( key: String, expire : Int) = r.expire(key, expire)

    def writeToRedisWithExpire(key : String, value: Any, expire : Int) = {
        writeToRedis(key, value)
        setExpire(key, expire)
    }

    def getFromRedis(key: String) = r.get(key)

    def getFromRedisAndDelete (key : String) = {
      r.get(key)
      r.del(key)
    }

    def printLastSave: Unit = r.lastsave


    def getPattern(pattern : String)  = r.keys(pattern)

    def printPattern(pattern: String) : Unit = r.keys(pattern).map(println(_))
}
