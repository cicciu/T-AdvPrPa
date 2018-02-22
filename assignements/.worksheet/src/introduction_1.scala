object introduction_1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  println("Welcome to the Scala worksheet");$skip(61); 

	//####Question 1 - Using ScalaIDE####
	
	//b)
	def foo=5.0;System.out.println("""foo: => Double""");$skip(13); 
	def bar = 3;System.out.println("""bar: => Int""");$skip(33); 
	def sum(x:Double,y:Double)= x+y;System.out.println("""sum: (x: Double, y: Double)Double""");$skip(37); 
	
	
	//e)
	def square(x:Double)= x*x;System.out.println("""square: (x: Double)Double""");$skip(11); val res$0 = 
	square(5);System.out.println("""res0: Double = """ + $show(res$0));$skip(50); 
	
	//f)
	def square4(x:Double)= square(square(x));System.out.println("""square4: (x: Double)Double""");$skip(12); val res$1 = 
	square4(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(126); 
	
	//####Question 2 - Getting our hands dirty
	//def sqrt(x:Double):Double=
	//a b c d e)
	def abs(x:Double)=if(x<0)-x else x;System.out.println("""abs: (x: Double)Double""");$skip(98); 
	
	def isGoodEnough(value:Double, approximation:Double)= abs(square(approximation)-value)<0.00001;System.out.println("""isGoodEnough: (value: Double, approximation: Double)Boolean""");$skip(48); 
	def f(x:Double, value:Double)= square(x)-value;System.out.println("""f: (x: Double, value: Double)Double""");$skip(25); 
	def fPrim(x:Double)=2*x;System.out.println("""fPrim: (x: Double)Double""");$skip(64); 
	
	def improve(x:Double, value:Double)= x-(f(x,value)/fPrim(x));System.out.println("""improve: (x: Double, value: Double)Double""");$skip(194); 
	
  def sqrtRecursion(value:Double, approximation:Double):Double={
  	if(isGoodEnough(value, approximation))
  		approximation
  	else
  		sqrtRecursion(value, improve(approximation,value))
  };System.out.println("""sqrtRecursion: (value: Double, approximation: Double)Double""");$skip(52); 
  
  def sqrt(value:Double)=sqrtRecursion(value,10);System.out.println("""sqrt: (value: Double)Double""");$skip(14); val res$2 = 
  
  sqrt(36);System.out.println("""res2: Double = """ + $show(res$2));$skip(65); 
  
  //f) /!\ il y a une faute encore
  def cube(x:Double)=x*x*x;System.out.println("""cube: (x: Double)Double""");$skip(102); 
  
  def isGoodEnoughCube(value:Double, approximation:Double)= abs(cube(approximation)-value)<0.00001;System.out.println("""isGoodEnoughCube: (value: Double, approximation: Double)Boolean""");$skip(54); 
  
  def fCube(x:Double, value:Double)= cube(x)-value;System.out.println("""fCube: (x: Double, value: Double)Double""");$skip(37); 
	def fPrimCube(x:Double)=3*square(x);System.out.println("""fPrimCube: (x: Double)Double""");$skip(76); 
	
	def improveCube(x:Double, value:Double)= x-(fCube(x,value)/fPrimCube(x));System.out.println("""improveCube: (x: Double, value: Double)Double""");$skip(195); 
	
	def crtRecursion(value:Double, approximation:Double):Double={
  	if(isGoodEnough(value, approximation))
  		approximation
  	else
  		crtRecursion(value, improveCube(approximation,value))
  };System.out.println("""crtRecursion: (value: Double, approximation: Double)Double""");$skip(50); 
  
  def crt(value:Double)=crtRecursion(value,10);System.out.println("""crt: (value: Double)Double""")}
  
  //crt(16)
  
 	
}
