object higher_order_functions_2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Question 1 - Tail recursion a)
  def fact(x:Int):Int = if(x==0) 1 else x * fact(x-1)
                                                  //> fact: (x: Int)Int
	def factTail(x:Int, acc:Int):Int = if(x==0) acc else factTail(x-1, x * acc)
                                                  //> factTail: (x: Int, acc: Int)Int
	
  fact(4)                                         //> res0: Int = 24
  factTail(5,1)                                   //> res1: Int = 120
  
  //Question 1 - Tail recursion b)
  def fibo(x:Int):Int = if(x==0) 0 else if(x==1) 1 else fibo(x-1)+fibo(x-2)
                                                  //> fibo: (x: Int)Int
  
  def fiboTail(x:Int, acc:Int):Int=if(x==0) 0 else if(x==1) 1 else fiboTail(x-1,acc+x-1)+fiboTail(x-2,acc+x-2)
                                                  //> fiboTail: (x: Int, acc: Int)Int
  fibo(20)                                        //> res2: Int = 6765
  fiboTail(20,0)                                  //> res3: Int = 6765
  
  
  
  //Lecture 2
  def sumInts(a:Int,b:Int):Double=if(a>b) 0 else a+ sumInts(a+1,b)
                                                  //> sumInts: (a: Int, b: Int)Double
  sumInts(1,3)                                    //> res4: Double = 6.0
  
  //Question 2 - Higher-order-functions
  def sum(f:Int => Double, a:Int, b:Int)={
  	def iter(a:Int, acc:Double):Double ={
  		if(a>b)
  			acc
  		else
  			iter(a+1,f(a)+acc)
  	}
  	iter(a,0)
  }                                               //> sum: (f: Int => Double, a: Int, b: Int)Double
  sum(x=>x*x, 1,3)                                //> res5: Double = 14.0
  
  //Question 3 - Currying
  
  
  def productBis(f:Int=>Double, a:Int, b:Int):Double={
  	def iter(a:Int, acc:Double):Double ={
  		if(a>b)
  			acc
  		else
  			iter(a+1,f(a)*acc)
  	}
  	iter(a,1)
  }                                               //> productBis: (f: Int => Double, a: Int, b: Int)Double
  productBis(x=>x, 1,3)                           //> res6: Double = 6.0
  
  def product(f:Int=>Double)(a:Int, b:Int):Double= {
  	if(a>b)
  		1
  	else
  		f(a)*product(f)(a+1,b)
  }                                               //> product: (f: Int => Double)(a: Int, b: Int)Double
  
  product(x=>x)( 1,3)                             //> res7: Double = 6.0
}