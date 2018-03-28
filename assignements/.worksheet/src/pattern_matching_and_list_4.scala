object pattern_matching_and_list_4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(188); 
  
  //exercice in course
  def patFoo(x: Any) = {
		x match{
			case x:Int if(x%4==0) => true
			case x:Char if(x>='A' && x<='Z') => true
			case x:Boolean=>true
			case _=> false
		}
	};System.out.println("""patFoo: (x: Any)Boolean""");$skip(15); val res$0 = 
	
	patFoo('B');System.out.println("""res0: Boolean = """ + $show(res$0));$skip(15); val res$1 = 
	patFoo(false);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(104); 
	
	def isort(xs: List[Int]):List[Int]={
		if(xs.isEmpty) Nil
		else insert2(xs.head, isort(xs.tail))
	};System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(148); 
	
	def insert(elem:Int, l:List[Int]):List[Int]={
		if(l.isEmpty) List(elem)
		else if(elem < l.head ) elem::l
		else l.head::insert(elem,l.tail)
	};System.out.println("""insert: (elem: Int, l: List[Int])List[Int]""");$skip(179); 
	def insert2(elem:Int, l:List[Int]):List[Int]={
		l match{
			case Nil=> List(elem)
			case head::rest=>{
				if(elem < head) elem::l
				else head::insert(elem,rest)
			}
		}
	};System.out.println("""insert2: (elem: Int, l: List[Int])List[Int]""");$skip(34); val res$2 = 
	
	
	insert(3, List(1,3,4,3,2,0));System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(28); val res$3 = 
	
	isort(List(1,3,4,3,2,0))
	
	
	//question 1
	sealed abstract class Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr
	case class Product(e1: Expr, e2: Expr) extends Expr;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(339); 
	
	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
		case Product(e1, e2) => eval(e1) * eval(e2)
	};System.out.println("""eval: (e: pattern_matching_and_list_4.Expr)Int""");$skip(393); 
	
	def show(e:Expr):String = e match{
		case Number(n) => n.toString()
		case Sum(e1, e2) => show(e1)+"+"+show(e2)
		case Product(Sum(e1, e2),Sum(e3,e4)) =>"("+show(Sum(e1,e2))+")*("+show(Sum(e2,e3))+")"
		case Product(e1,Sum(e2,e3)) => show(e1)+"*("+show(Sum(e2,e3))+")"
		case Product(Sum(e1, e2),e3) =>"("+show(Sum(e1,e2))+")*"+show(e3)
		case Product(e1, e2) => show(e1) +"*"+ show(e2)
	};System.out.println("""show: (e: pattern_matching_and_list_4.Expr)String""");$skip(64); 

	
	
	val expr0 = Sum(Product(Number(2), Number(3)), Number(4));System.out.println("""expr0  : pattern_matching_and_list_4.Sum = """ + $show(expr0 ));$skip(34); 
	println("Expr0: " + show(expr0));$skip(27); 
	assert(eval(expr0) == 10);$skip(46); 
	
	val expr1 = Product(Number(4), Number(12));System.out.println("""expr1  : pattern_matching_and_list_4.Product = """ + $show(expr1 ));$skip(34); 
	println("Expr1: " + show(expr1));$skip(27); 
	assert(eval(expr1) == 48);$skip(60); 

	val expr2 = Product(Sum(Number(2), Number(3)), Number(4));System.out.println("""expr2  : pattern_matching_and_list_4.Product = """ + $show(expr2 ));$skip(34); 
	println("Expr2: " + show(expr2));$skip(27); 
	assert(eval(expr2) == 20);$skip(60); 

	val expr3 = Product(Number(2), Sum(Number(3), Number(4)));System.out.println("""expr3  : pattern_matching_and_list_4.Product = """ + $show(expr3 ));$skip(34); 
	println("Expr3: " + show(expr3));$skip(27); 
	assert(eval(expr3) == 14);$skip(77); 
	
	val expr4 = Product(Sum(Number(3), Number(4)), Sum(Number(3), Number(4)));System.out.println("""expr4  : pattern_matching_and_list_4.Product = """ + $show(expr4 ));$skip(34); 
	println("Expr4: " + show(expr4));$skip(27); 
	assert(eval(expr3) == 14)
	
	//question 2
	sealed abstract class BinaryTree
	case class Leaf(value: Int) extends BinaryTree
 	case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree;$skip(281); 
 	
 	def leafSum(t:BinaryTree):Int=t match{
 		case Leaf(t)=>t
 		case Node(l,r)=> leafSum(l)+leafSum(r)
 	};System.out.println("""leafSum: (t: pattern_matching_and_list_4.BinaryTree)Int""");$skip(51); 
 	
 	val x = Node(Node(Leaf(3), Leaf(8)), Leaf(5));System.out.println("""x  : pattern_matching_and_list_4.Node = """ + $show(x ));$skip(12); 
	println(x);$skip(21); 
	println(leafSum(x))}
}
