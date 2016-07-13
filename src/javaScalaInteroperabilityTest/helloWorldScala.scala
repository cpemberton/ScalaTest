
package javaScalaInteroperabilityTest
import collection.JavaConversions._

object helloWorldScala {
    def main(args: Array[String]): Unit = {
    println("Hello, Scala World!")
    val pHWJ = new helloWorldJava
    pHWJ.printHWJS()
    }
}