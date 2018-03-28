object advanced_lists_and_for_comprehensions_5 {
  println("Welcome to the Scala worksheet")
  
  
  def dup[B](x:List[B]):List[B]={
		x.foldRight(List.empty[B])((elem, acc)=> elem::elem::acc)
  }
  
  def rep[A](l:A)=List[A](l,l)
  def dup2[B](x:List[B]):List[B]={
		x.flatMap(rep)
  }
  
  dup(List(1,2,3,4))
  dup2(List(1,2,3,4))
  
  val n1=List(1,2,4,6)
  val n2=List(2,3,5,7)
  
  def merge(x:List[Int],y:List[Int]):List[Int] = {
  	(x,y) match{
  		case (x,Nil) => x
  		case (Nil,y) => y
  		case (e1::rest1, e2::rest2) => if(e1<e2) e1::merge(rest1, y) else e2::merge(x,rest2)
  	}
  	
  }
  
  merge(n1,n2)
  
  //exercice 3
  val b = (1 to 10).toList
  
  def filter(f:Int=>Boolean, x:List[Int]):List[Int]={
  	x match{
  		case Nil=>Nil
  		case e::rest=> if(f(e)) e::filter(f,rest) else filter(f,rest)
  	}
  }
  
  def partition(f:Int=>Boolean, a:List[Int]):(List[Int],List[Int])={
  	val tv=filter(f,a)
  	val fv= filter(f andThen((x:Boolean)=> !x),a)
  	(tv,fv)
  }
  def partition2(f:Int=>Boolean, a:List[Int]):(List[Int],List[Int])={
  	(filter(f,a), a diff filter(f,a))
  }
  
  filter(_%2==0,b)
  partition2(_%2==0,b)
  
  //Question 1
  
  def lengthStrings(ls:List[String]):List[Int]={
  	ls.map((x)=> x.length )
  }
  
  lengthStrings(List("How","long","are","we?"))
  
  def dup[A](value:A, nb:Int):List[A]={
  	val l = List.range(0, nb)
  	l.map((x)=> value)
  }

  def dup2[A](value:A, nb:Int):List[A]={
    if(nb==0)
      Nil
    else
      value::dup2(value,nb-1)
  }
  
  dup("foo", 5)
  //returns List("foo", "foo", "foo", "foo", "foo")
	dup2(List(1,2,3), 2)

  def dot(l1:List[Int], l2:List[Int]):List[Int]={
    val ls = l1 zip l2
    ls.map((x)=>x._1*x._2)
  }
  dot(List(1,2,3), List(2,4,3))

  //Question 2
  def areTrue(l:List[Boolean]):Boolean={
    l.foldRight(true)((elem, acc)=>elem&acc)
  }
  areTrue(List(true, true, false))
  areTrue(List(true, true, true))

  def lString(ls:List[String]):Int={
    ls.foldRight(0)((elem,acc)=>acc+elem.length)
  }
  lString(List("Folding", "is", "fun"))


  def longest(ls:List[String])={
    ls.foldRight((0,""))((elem,acc)=>
      if(elem.length>acc._1)
        (elem.length,elem)
      else
        (acc)
    )
  }
  longest(List("What", "is", "the", "longest?"))

  def isPresent(l:List[Int], value:Int):Boolean={
    l.foldRight(false)((elem,acc)=>if(elem==value) acc|true  else acc|false)
  }
  isPresent(List(1,2,3,4), 5) //returns false
  isPresent(List(1,2,3,4), 3) //returns true

  def flattenList(l: List[Any]): List[Any]={
    l.foldRight(List.empty[Any]) {
        case (t: List[_],acc) => flattenList(t) ++ acc
        case (t:Any, acc) => t :: acc
      }
  }

  flattenList(List(List(1,1), 2, List(3, List(5, 8))))

}