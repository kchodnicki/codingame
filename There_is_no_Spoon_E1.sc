import math._
import Array._
import scala.util._

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
object Player extends App {
    val width = readInt // the number of cells on the X axis
    val height = readInt // the number of cells on the Y axis
    var myMatrix = ofDim[String](width,height)
    var lineToPrint = ""
    
    //read matrix
    for(h <- 0 until height) {
        var w = 0
        val line = readLine.map(_.toString) // width characters, each either 0 or .
        for (i <- line) {
            myMatrix(w)(h) = i
            w += 1
        }
    }
    
    //process cells
    for {
        h <- 0 until height
        w <- 0 until width
        if myMatrix(w)(h) == "0"
    } {
        var (nextwx, nextwy) = findNextW(w,h)
        var (nexthx, nexthy) = findNextH(w,h)
        
        println(s"$w $h $nextwx $nextwy $nexthx $nexthy")
    }
    
    //find next horizontal not empty cell
    def findNextW(w:Int, h:Int) : (String, String) = {
        for (x <- w+1 until width) {
            if (myMatrix(x)(h) == "0") return (s"$x",s"$h")
        }
        return ("-1","-1")
    }
    
    //find next vertical not empty cell
    def findNextH(w:Int, h:Int) : (String, String) = {
        for (y <- h+1 until height) {
            if (myMatrix(w)(y) == "0") return (s"$w",s"$y")
        }
        return ("-1","-1")
    }
    
}
