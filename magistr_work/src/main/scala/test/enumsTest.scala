package test

class enumsTest extends Enumeration {

  case class Te(
                 name: String
               ) extends super.Val

  implicit def valueToTeVal(x: Value): Te = x.asInstanceOf[Te]

  def valueToTeVal1(x: Value): Te = x.asInstanceOf[Te]

  val za = Te("a")
  val b = Te("bbaba")
  val c = Te("c")

}

object main {
  def main(args: Array[String]): Unit = {

    val enumsTest = new enumsTest
    println(enumsTest.b)
//    println(enumsTest.valueToTeVal1(enumsTest.b))
    enumsTest.values.foreach(println(_))
  }
}
