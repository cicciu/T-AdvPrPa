object advanced_lists_and_for_comprehensions_5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet");$skip(104); 
  
  
  def dup[B](x:List[B]):List[B]={
		x.foldRight(List.empty[B])((elem, acc)=> elem::elem::acc)
  };System.out.println("""dup: [B](x: List[B])List[B]""");$skip(34); 
  
  def rep[A](l:A)=List[A](l,l);System.out.println("""rep: [A](l: A)List[A]""");$skip(56); 
  def dup2[B](x:List[B]):List[B]={
		x.flatMap(rep)
  };System.out.println("""dup2: [B](x: List[B])List[B]""");$skip(24); val res$0 = 
  
  dup(List(1,2,3,4));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(22); val res$1 = 
  dup2(List(1,2,3,4));System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(26); 
  
  val n1=List(1,2,4,6);System.out.println("""n1  : List[Int] = """ + $show(n1 ));$skip(23); 
  val n2=List(2,3,5,7);System.out.println("""n2  : List[Int] = """ + $show(n2 ));$skip(216); 
  
  def merge(x:List[Int],y:List[Int]):List[Int] = {
  	(x,y) match{
  		case (x,Nil) => x
  		case (Nil,y) => y
  		case (e1::rest1, e2::rest2) => if(e1<e2) e1::merge(rest1, y) else e2::merge(x,rest2)
  	}
  	
  };System.out.println("""merge: (x: List[Int], y: List[Int])List[Int]""");$skip(18); val res$2 = 
  
  merge(n1,n2);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(45); 
  
  //exercice 3
  val b = (1 to 10).toList;System.out.println("""b  : List[Int] = """ + $show(b ));$skip(162); 
  
  def filter(f:Int=>Boolean, x:List[Int]):List[Int]={
  	x match{
  		case Nil=>Nil
  		case e::rest=> if(f(e)) e::filter(f,rest) else filter(f,rest)
  	}
  };System.out.println("""filter: (f: Int => Boolean, x: List[Int])List[Int]""");$skip(158); 
  
  def partition(f:Int=>Boolean, a:List[Int]):(List[Int],List[Int])={
  	val tv=filter(f,a)
  	val fv= filter(f andThen((x:Boolean)=> !x),a)
  	(tv,fv)
  };System.out.println("""partition: (f: Int => Boolean, a: List[Int])(List[Int], List[Int])""");$skip(111); 
  def partition2(f:Int=>Boolean, a:List[Int]):(List[Int],List[Int])={
  	(filter(f,a), a diff filter(f,a))
  };System.out.println("""partition2: (f: Int => Boolean, a: List[Int])(List[Int], List[Int])""");$skip(22); val res$3 = 
  
  filter(_%2==0,b);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(23); val res$4 = 
  partition2(_%2==0,b);System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(101); 
  
  //Question 1
  
  def lengthStrings(ls:List[String]):List[Int]={
  	ls.map((x)=> x.length )
  };System.out.println("""lengthStrings: (ls: List[String])List[Int]""");$skip(51); val res$5 = 
  
  lengthStrings(List("How","long","are","we?"));System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(169); 
  
  def dup[A](value:A, nb:Int):List[A]={
  	//l.foldRight(List.empty[A])((elem,acc)=> if(acc==Nil)elem else Nil
  	val l = List.range(1, nb)
  	l.map((x)=> value)
  };System.out.println("""dup: [A](value: A, nb: Int)List[A]""");$skip(19); val res$6 = 
  
  dup("foo", 5);System.out.println("""res6: List[String] = """ + $show(res$6))}
  //returns List("foo", "foo", "foo", "foo", "foo")
	//dup(List(1,2,3), 2) returns List(List(1,2,3), List(1,2,3))
  
  
  
}
