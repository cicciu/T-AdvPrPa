object functional_data_structure_3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //other exercice
  class Rational(n: Int, d: Int) {
		require(d!=0)
		
		
		
		private val g = pgcd(n,d)
		private def pgcd(x:Int,y:Int):Int= if(y==0) x else pgcd(y,x%y)
		def num = n/g
		def denom = d/g
		
		
		def +(that: Rational) = {
			new Rational(num * that.denom + that.num * denom,
			denom * that.denom)
		}
	
		def -(that: Rational) = {
			new Rational(num * that.denom - that.num * denom,
			denom * that.denom)
		}
	
		def *(that: Rational) = {
			new Rational(num * that.num, denom * that.denom)
		}
		
		def /(that: Rational) = {
			new Rational(num * that.denom, denom * that.num)
		}
	
		def ==(that: Rational) = {
			num * that.denom == denom * that.num
		}
		
		def unary_-()={
			new Rational(-this.num,this.denom)
		}
		
		def <(that:Rational)={
			this.num/this.denom < that.num/that.denom
		}
		
		def max(that:Rational)={
			if(this<that) that else this
		}
	
		override def toString() = num + "/" + denom
	}
	
	object Rational{
		implicit def intToRat(x:Int,y:Int) = new Rational(x,y)
	}
	val r = new Rational(10,20)               //> r  : functional_data_structure_3.Rational = 1/2
	val r2 = new Rational(2,3)                //> r2  : functional_data_structure_3.Rational = 2/3
	val r4 = new Rational(1,1)                //> r4  : functional_data_structure_3.Rational = 1/1
	-r                                        //> res0: functional_data_structure_3.Rational = 1/-2
	r < r4                                    //> res1: Boolean = true
	r2.max(r4)                                //> res2: functional_data_structure_3.Rational = 1/1
	r2 + r                                    //> res3: functional_data_structure_3.Rational = 7/6
	
	val x = new Rational(10,20)               //> x  : functional_data_structure_3.Rational = 1/2
	val y = new Rational(2,3)                 //> y  : functional_data_structure_3.Rational = 2/3
	x + x * y                                 //> res4: functional_data_structure_3.Rational = 5/6
	x + (x*y)                                 //> res5: functional_data_structure_3.Rational = 5/6
	(x+x)*y                                   //> res6: functional_data_structure_3.Rational = 2/3
	
	
	
	//Exercice 1
	abstract class IntSet() {
	  def add(x: Int): IntSet
	  def contains(x: Int): Boolean
	  def foreach(f: Int => Unit): Unit
  }
 
  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
		def add(x: Int): IntSet = {
			if (x < elem) new NonEmpty(elem, left add x, right)
		  else if (x > elem) new NonEmpty(elem, left, right add x)
		  else this
	 	}

		def contains(x: Int): Boolean = {
			if (x < elem) left contains x
			else if (x > elem) right contains x
			else true
		}
		
		override def toString():String="(" + left + "|" + elem + "|" + right + ")"
		
		def foreach(f:Int=>Unit):Unit={
			f(elem)
			left.foreach(f)
			right.foreach(f)
		}
	}

 	object Empty extends IntSet() {
 		def contains(x: Int): Boolean = false
 		def add(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
 		override def toString():String="-"
 		def foreach(f:Int=>Unit):Unit={}
 	}
 	println(Empty)                            //> -
	println(Empty.add(3))                     //> (-|3|-)
	println(Empty.add(3).add(2))              //> ((-|2|-)|3|-)
	
	var s = Empty.add(3).add(2).add(1).add(10).add(4)
                                                  //> s  : functional_data_structure_3.IntSet = (((-|1|-)|2|-)|3|((-|4|-)|10|-))
	s.foreach(println)                        //> 3
                                                  //| 2
                                                  //| 1
                                                  //| 10
                                                  //| 4
	
}