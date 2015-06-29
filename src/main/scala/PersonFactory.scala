package people

object PersonFactory{

    private val myGenerator = scala.util.Random
    private val nameMaxLength: Int = 8
    private val maxAge : Int = 100;
	  private val alphabet : Int = 26;
    private val interestLen : Int = 2
    private val interestListLen : Int = 5

    def generateNumRange( length : Int) : Int = math.abs(myGenerator.nextInt) % length


    def getAge : Int = generateNumRange(maxAge)

    def getNameLength : Int = generateNumRange(nameMaxLength) + 1

    def getInterestLen : Int = generateNumRange(interestListLen) + 1

    def mapRangeToFunction(n : Int, func : Int => Any) : List[Any] = (1 to n).toList.map(func(_))

    def getName =  mapRangeToFunction(getNameLength, getChar _) mkString("")

    def getChar(n: Int) : Char = (generateNumRange(alphabet) + 97)toChar


    def getAPerson(n: Int) : Person = new Person(getName, getAge, makeInterestList(getInterestLen))

    def getNPeople(n: Int) : List[_] =  mapRangeToFunction(n, getAPerson _)


    def getNJson(n : Int) : String = {
    var sum =  "["
    for( _ <- (0 until n) ) sum += getAPerson(1).toJson+ ",";
    sum += getAPerson(1).toJson + "]"
    sum
  }

    def makeInterest(n  : Int) : String = mapRangeToFunction(interestLen, getChar _) mkString("")

    def makeInterestList(n : Int) : List[String] = mapRangeToFunction(n, makeInterest _) map (_.toString)
}
