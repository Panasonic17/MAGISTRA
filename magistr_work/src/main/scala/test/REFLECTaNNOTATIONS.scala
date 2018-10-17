package test

import org.apache.spark.sql.Column

import scala.collection.immutable
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._
//

class key() extends scala.annotation.StaticAnnotation

class time() extends scala.annotation.StaticAnnotation

case class test(@key a: String, @time b: String)

object REFLECTaNNOTATIONS {
  private def annotatedFieldsName[A: TypeTag](typeSymbol: TypeSymbol): List[String] = {
    val a: universe.ClassSymbol = typeSymbol.asClass
    null
    //      .primaryConstructor.typeSignature.paramLists.head.filter(s => s.annotations.exists(a => a.tree.tpe <:< typeOf[A])).map(_.name.toString)
  }


  def main(args: Array[String]): Unit = {
    print("sawa")
  }
}


