package people

object PersonFactory{

  private val myGenerator = scala.util.Random
  private val NAMELENGHTMAX: Int = 15;
	private val MAXAGE: Int = 150;
	private val ALPHABET: Int = 26;



def generateMaxLength( length : Int) : Int = math.abs(myGenerator.nextInt) % length
                                                  //> generateMaxLength: (length: Int)Int

  def getAge : Int = generateMaxLength(MAXAGE)    //> getAge: => Int

  def getNameLength : Int = generateMaxLength(NAMELENGHTMAX) + 1
                                                  //> getNameLength: => Int

  def getName =  mapRangeToFunction(getNameLength, getChar _) mkString("")
                                                  //> getName: => String

  def mapRangeToFunction(n : Int, func : Int => _ ) : List[_] = (1 to getNameLength).toList.map(func(_))
                                                  //> mapRangeToFunction: (n: Int, func: Function1[Int, _])List[_]

  def getChar(n: Int) : Char = (generateMaxLength(ALPHABET) + 97) toChar
                                                  //> getChar: (n: Int)Char

  def getAPerson(n: Int) : Person = new Person(getName, getAge)
                                                  //> getAPerson: (n: Int)peopleScala.Person

  def getNPeople(n: Int) : List[_] =  mapRangeToFunction(n, getAPerson _)
                                                  //> getNPeople: (n: Int)List[_]
  def getNJson(n : Int) : String = {
    var sum =  "["
    for( _ <- 0 until n ) sum += getAPerson(1).toJson+ ",";
    sum += getAPerson(1).toJson + "]"
    sum
  }
}
