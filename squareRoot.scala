/*

<<<<<<<<<<<<<<<---------------- TASK ---------------->>>>>>>>>>>>>>>
Find square root of number (n) using Babylonian method:
1. Start with an arbitrary positive start value x (the closer to the actual square root, the better it is).
  e.g. say number (n) is 5 so x can be 2 as (2*2 = 4 which is closer to 5).
2. Initialize y = 1.
3. Do following until desired approximation is achieved (i.e. accuracy level specified by the user is attained):
   a) x = (x + y)/2
   b) y = n/x

NOTE: User is required to provide two non-negative numbers as inputs at command line
*/

// <<<<<<<<<<<<<<<---------------- SOLUTION STARTS ---------------->>>>>>>>>>>>>>>

import scala.util.Try            //As Try block is used, so its import is required

object squareRoot extends App{         //sqaureRoot object (Singleton Class) is created which will
                                       //inherit main method from App trait
  if(Try{
    args(0).toDouble   //arguments received from command line are converted to Double
    args(1).toDouble

  }.isSuccess) {           //One of the try methods (other is "isFailure") -> here it's used
                           //to check whether body of Try returns success or not, if success is returned then
                           //body of if executes otherwise else part executes
    var n = args(0).toDouble         //number whose square root is to be calculated
    var e = args(1).toDouble         //error level specified by the user which specifies how much accuracy level is desired


    if (n >= 0 && e >= 0) {      //if both arguments are non-negative then if block executes otherwise else block executes

      // procedure to find best value of x
      var i = 0.toDouble
      var x = 0.toDouble
      while (i * i < n) {
        i = i + 1
      }
      x = i //Best value is assigned to x when this loop stops

      //now procedure to calculate the square root starts
      var y = 1.toDouble
      while ((x - y).abs > e) {
        x = (x + y) / 2
        y = n / x
      }
      println("Square root is " + x)
    }
    else println("<<<<<<<-------- WRONG INPUT (Please enter valid non-negative numbers only) -------->>>>>>>")
  }
  else{
    println("!!!!!..... Please enter valid non-negative numbers only.....!!!!!")
  }
}
//******************************** SOLUTION1 ENDS ********************************