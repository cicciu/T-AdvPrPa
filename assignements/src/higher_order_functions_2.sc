object higher_order_functions_2 {
  println("Welcome to the Scala worksheet")
  
  //Question 1 - Tail recursion a)
  def fact(x:Int):Int = if(x==0) 1 else x * fact(x-1)
	def factTail(x:Int, acc:Int):Int = if(x==0) acc else factTail(x-1, x * acc)
	
  fact(4)
  factTail(5,1)
  
  //Question 1 - Tail recursion b)
  def fibo(x:Int):Int = if(x==0) 0 else if(x==1) 1 else fibo(x-1)+fibo(x-2)
  
  def fiboTail(x:Int, acc:Int):Int=if(x==0) 0 else if(x==1) 1 else fiboTail(x-1,acc+x-1)+fiboTail(x-2,acc+x-2)
  fibo(20)
  fiboTail(20,0)
  
  
  
  //Lecture 2
  def sumInts(a:Int,b:Int):Double=if(a>b) 0 else a+ sumInts(a+1,b)
  sumInts(1,4)
  
  //Question 2 - Higher-order-functions
  def sum(f:Int => Double, a:Int, b:Int)={
  	def iter(a:Int, acc:Double):Double ={
  		if(a>b)
  			acc
  		else
  			iter(a+1,f(a)+acc)
  	}
  	iter(a,0)
  }
  sum(x=>x*x, 1,3)
  
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
  }
  productBis(x=>x, 1,3)
  
  def product(f:Int=>Double)(a:Int, b:Int):Double= {
  	if(a>b)
  		1
  	else
  		f(a)*product(f)(a+1,b)
  }
  
  product(x=>x)( 1,3)
  
  //b)
  def factorial(n:Int) = product(x=>x)(1,n)
  
  factorial(2)
  factorial(3)
  
  //c)
  def mapReduce(f:Int=>Int, combine:(Int,Int)=>Int, initValue:Int)(a:Int,b:Int):Int={
  	if(a>b)
  		initValue
  	else
  		combine(f(a), mapReduce(f, combine, initValue)(a+1, b))
  }
  
  def prodAsMapReduce(f:Int=>Int)(a:Int,b:Int)={
  	mapReduce(f, (x, y) => x * y, 1)(a, b)
  }
  
  def sumAsMapReduce(f:Int=>Int)(a:Int,b:Int)={
  	mapReduce(f, (x, y) => x + y, 0)(a, b)
  }
  
  sumAsMapReduce(x=>x)(1,3)
  prodAsMapReduce(x=>x)(1,3)
  
  //exos supl f(g(g)
  //1. f(g(x)) ou f et g sont des fonctions quelconques, donner l'implémentation curryfiée
	//2. Ecrire une fonction isSorted qui prend une liste (ou un tableau, comme vous voulez) en argument et qui retourne si la liste est triée selon une fonction passée également en argument (curryfiée).
 	def mapReduce2(f:Int=>Int, combine:(Int,Int)=>Int, initValue:Int)(a:Int){
 	???
 	}
  
  
  
}