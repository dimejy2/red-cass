package people
 class Person(val name: String, val age : Int, var myIdioSync: Array[String] = new Array()){

   val MyName = "MyName"
   val MyAge = "MyAge"
   override def toString : String = f"My name is $name and I am $age."

   def toJson : String = f"""{ "$MyName" : "$name" , "$MyAge": $age }"""
 }
