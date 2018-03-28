object functional_data_structure_3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet")
  
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
	};$skip(1047); 
	val r = new Rational(10,20);System.out.println("""r  : functional_data_structure_3.Rational = """ + $show(r ));$skip(28); 
	val r2 = new Rational(2,3);System.out.println("""r2  : functional_data_structure_3.Rational = """ + $show(r2 ));$skip(28); 
	val r4 = new Rational(1,1);System.out.println("""r4  : functional_data_structure_3.Rational = """ + $show(r4 ));$skip(4); val res$0 = 
	-r;System.out.println("""res0: functional_data_structure_3.Rational = """ + $show(res$0));$skip(8); val res$1 = 
	r < r4;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(12); val res$2 = 
	r2.max(r4);System.out.println("""res2: functional_data_structure_3.Rational = """ + $show(res$2));$skip(8); val res$3 = 
	r2 + r;System.out.println("""res3: functional_data_structure_3.Rational = """ + $show(res$3));$skip(31); 
	
	val x = new Rational(10,20);System.out.println("""x  : functional_data_structure_3.Rational = """ + $show(x ));$skip(27); 
	val y = new Rational(2,3);System.out.println("""y  : functional_data_structure_3.Rational = """ + $show(y ));$skip(11); val res$4 = 
	x + x * y;System.out.println("""res4: functional_data_structure_3.Rational = """ + $show(res$4));$skip(11); val res$5 = 
	x + (x*y);System.out.println("""res5: functional_data_structure_3.Rational = """ + $show(res$5));$skip(9); val res$6 = 
	(x+x)*y
	
	
	
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
 	};System.out.println("""res6: functional_data_structure_3.Rational = """ + $show(res$6));$skip(919); 
 	println(Empty);$skip(23); 
	println(Empty.add(3));$skip(30); 
	println(Empty.add(3).add(2));$skip(53); 
	
	var s = Empty.add(3).add(2).add(1).add(10).add(4);System.out.println("""s  : functional_data_structure_3.IntSet = """ + $show(s ));$skip(20); 
	s.foreach(println)}
	
}
