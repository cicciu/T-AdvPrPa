object introduction_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	//####Question 1 - Using ScalaIDE####
	
	//b)
	def foo=5.0                               //> foo: => Double
	def bar = 3                               //> bar: => Int
	def sum(x:Double,y:Double)= x+y           //> sum: (x: Double, y: Double)Double
	
	
	//e)
	def square(x:Double)= x*x                 //> square: (x: Double)Double
	square(5)                                 //> res0: Double = 25.0
	
	//f)
	def square4(x:Double)= square(square(x))  //> square4: (x: Double)Double
	square4(2)                                //> res1: Double = 16.0
	
	//####Question 2 - Getting our hands dirty
	//def sqrt(x:Double):Double=
	//a b c d e)
	def abs(x:Double)=if(x<0)-x else x        //> abs: (x: Double)Double
	
	def isGoodEnough(value:Double, approximation:Double)= abs(square(approximation)-value)<0.00001
                                                  //> isGoodEnough: (value: Double, approximation: Double)Boolean
	def f(x:Double, value:Double)= square(x)-value
                                                  //> f: (x: Double, value: Double)Double
	def fPrim(x:Double)=2*x                   //> fPrim: (x: Double)Double
	
	def improve(x:Double, value:Double)= x-(f(x,value)/fPrim(x))
                                                  //> improve: (x: Double, value: Double)Double
	
  def sqrtRecursion(value:Double, approximation:Double):Double={
  	if(isGoodEnough(value, approximation))
  		approximation
  	else
  		sqrtRecursion(value, improve(approximation,value))
  }                                               //> sqrtRecursion: (value: Double, approximation: Double)Double
  
  def sqrt(value:Double)=sqrtRecursion(value,10)  //> sqrt: (value: Double)Double
  
  sqrt(36)                                        //> res2: Double = 6.000000002793968
  
  //f) /!\ il y a une faute encore
  def cube(x:Double)=x*x*x                        //> cube: (x: Double)Double
  
  def isGoodEnoughCube(value:Double, approximation:Double)= abs(cube(approximation)-value)<0.00001
                                                  //> isGoodEnoughCube: (value: Double, approximation: Double)Boolean
  
  def fCube(x:Double, value:Double)= cube(x)-value//> fCube: (x: Double, value: Double)Double
	def fPrimCube(x:Double)=3*square(x)       //> fPrimCube: (x: Double)Double
	
	def improveCube(x:Double, value:Double)= x-(fCube(x,value)/fPrimCube(x))
                                                  //> improveCube: (x: Double, value: Double)Double
	
	def crtRecursion(value:Double, approximation:Double):Double={
  	if(isGoodEnough(value, approximation))
  		approximation
  	else
  		crtRecursion(value, improveCube(approximation,value))
  }                                               //> crtRecursion: (value: Double, approximation: Double)Double
  
  def crt(value:Double)=crtRecursion(value,10)    //> crt: (value: Double)Double
  
  //crt(16)
  
 	
}