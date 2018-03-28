object higher_order_functions_2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(92); 
  
  //Question 1 - Tail recursion a)
  def fact(x:Int):Int = if(x==0) 1 else x * fact(x-1);System.out.println("""fact: (x: Int)Int""");$skip(77); 
	def factTail(x:Int, acc:Int):Int = if(x==0) acc else factTail(x-1, x * acc);System.out.println("""factTail: (x: Int, acc: Int)Int""");$skip(12); val res$0 = 
	
  fact(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  factTail(5,1);System.out.println("""res1: Int = """ + $show(res$1));$skip(114); 
  
  //Question 1 - Tail recursion b)
  def fibo(x:Int):Int = if(x==0) 0 else if(x==1) 1 else fibo(x-1)+fibo(x-2);System.out.println("""fibo: (x: Int)Int""");$skip(114); 
  
  def fiboTail(x:Int, acc:Int):Int=if(x==0) 0 else if(x==1) 1 else fiboTail(x-1,acc+x-1)+fiboTail(x-2,acc+x-2);System.out.println("""fiboTail: (x: Int, acc: Int)Int""");$skip(11); val res$2 = 
  fibo(20);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
  fiboTail(20,0);System.out.println("""res3: Int = """ + $show(res$3));$skip(90); 
  
  
  
  //Lecture 2
  def sumInts(a:Int,b:Int):Double=if(a>b) 0 else a+ sumInts(a+1,b);System.out.println("""sumInts: (a: Int, b: Int)Double""");$skip(15); val res$4 = 
  sumInts(1,4);System.out.println("""res4: Double = """ + $show(res$4));$skip(203); 
  
  //Question 2 - Higher-order-functions
  def sum(f:Int => Double, a:Int, b:Int)={
  	def iter(a:Int, acc:Double):Double ={
  		if(a>b)
  			acc
  		else
  			iter(a+1,f(a)+acc)
  	}
  	iter(a,0)
  };System.out.println("""sum: (f: Int => Double, a: Int, b: Int)Double""");$skip(19); val res$5 = 
  sum(x=>x*x, 1,3);System.out.println("""res5: Double = """ + $show(res$5));$skip(211); 
  
  //Question 3 - Currying
  
  //a)
  def productBis(f:Int=>Double, a:Int, b:Int):Double={
  	def iter(a:Int, acc:Double):Double ={
  		if(a>b)
  			acc
  		else
  			iter(a+1,f(a)*acc)
  	}
  	iter(a,1)
  };System.out.println("""productBis: (f: Int => Double, a: Int, b: Int)Double""");$skip(24); val res$6 = 
  productBis(x=>x, 1,3);System.out.println("""res6: Double = """ + $show(res$6));$skip(112); 
  
  def product(f:Int=>Double)(a:Int, b:Int):Double= {
  	if(a>b)
  		1
  	else
  		f(a)*product(f)(a+1,b)
  };System.out.println("""product: (f: Int => Double)(a: Int, b: Int)Double""");$skip(25); val res$7 = 
  
  product(x=>x)( 1,3);System.out.println("""res7: Double = """ + $show(res$7));$skip(54); 
  
  //b)
  def factorial(n:Int) = product(x=>x)(1,n);System.out.println("""factorial: (n: Int)Double""");$skip(18); val res$8 = 
  
  factorial(2);System.out.println("""res8: Double = """ + $show(res$8));$skip(15); val res$9 = 
  factorial(3);System.out.println("""res9: Double = """ + $show(res$9));$skip(193); 
  
  //c)
  def mapReduce(f:Int=>Int, combine:(Int,Int)=>Int, initValue:Int)(a:Int,b:Int):Int={
  	if(a>b)
  		initValue
  	else
  		combine(f(a), mapReduce(f, combine, initValue)(a+1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, initValue: Int)(a: Int, b: Int)Int""");$skip(98); 
  
  def prodAsMapReduce(f:Int=>Int)(a:Int,b:Int)={
  	mapReduce(f, (x, y) => x * y, 1)(a, b)
  };System.out.println("""prodAsMapReduce: (f: Int => Int)(a: Int, b: Int)Int""");$skip(97); 
  
  def sumAsMapReduce(f:Int=>Int)(a:Int,b:Int)={
  	mapReduce(f, (x, y) => x + y, 0)(a, b)
  };System.out.println("""sumAsMapReduce: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$10 = 
  
  sumAsMapReduce(x=>x)(1,3);System.out.println("""res10: Int = """ + $show(res$10));$skip(29); val res$11 = 
  prodAsMapReduce(x=>x)(1,3);System.out.println("""res11: Int = """ + $show(res$11));$skip(402); 
  
  //exos supl f(g(g)
  //1. f(g(x)) ou f et g sont des fonctions quelconques, donner l'implémentation curryfiée
	//2. Ecrire une fonction isSorted qui prend une liste (ou un tableau, comme vous voulez) en argument et qui retourne si la liste est triée selon une fonction passée également en argument (curryfiée).
 	def mapReduce2(f:Int=>Int, combine:(Int,Int)=>Int, initValue:Int)(a:Int){
 	???
 	};System.out.println("""mapReduce2: (f: Int => Int, combine: (Int, Int) => Int, initValue: Int)(a: Int)Unit""")}
  
  
  
}
