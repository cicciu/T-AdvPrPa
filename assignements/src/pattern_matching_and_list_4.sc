object pattern_matching_and_list_4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //exercice in course
  def patFoo(x: Any) = {
		x match{
			case x:Int if(x%4==0) => true
			case x:Char if(x>='A' && x<='Z') => true
			case x:Boolean=>true
			case _=> false
		}
	}                                         //> patFoo: (x: Any)Boolean
	
	patFoo('B')                               //> res0: Boolean = true
	patFoo(false)                             //> res1: Boolean = true
	
	def isort(xs: List[Int]):List[Int]={
		if(xs.isEmpty) Nil
		else insert2(xs.head, isort(xs.tail))
	}                                         //> isort: (xs: List[Int])List[Int]
	
	def insert(elem:Int, l:List[Int]):List[Int]={
		if(l.isEmpty) List(elem)
		else if(elem < l.head ) elem::l
		else l.head::insert(elem,l.tail)
	}                                         //> insert: (elem: Int, l: List[Int])List[Int]
	def insert2(elem:Int, l:List[Int]):List[Int]={
		l match{
			case Nil=> List(elem)
			case head::rest=>{
				if(elem < head) elem::l
				else head::insert(elem,rest)
			}
		}
	}                                         //> insert2: (elem: Int, l: List[Int])List[Int]
	
	
	insert(3, List(1,3,4,3,2,0))              //> res2: List[Int] = List(1, 3, 3, 4, 3, 2, 0)
	
	isort(List(1,3,4,3,2,0))                  //> res3: List[Int] = List(0, 1, 2, 3, 3, 4)
	
	
	//question 1
	sealed abstract class Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr
	case class Product(e1: Expr, e2: Expr) extends Expr
	
	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
		case Product(e1, e2) => eval(e1) * eval(e2)
	}                                         //> eval: (e: pattern_matching_and_list_4.Expr)Int
	
	def show(e:Expr):String = e match{
		case Number(n) => n.toString()
		case Sum(e1, e2) => show(e1)+"+"+show(e2)
		case Product(Sum(e1, e2),Sum(e3,e4)) =>"("+show(Sum(e1,e2))+")*("+show(Sum(e2,e3))+")"
		case Product(e1,Sum(e2,e3)) => show(e1)+"*("+show(Sum(e2,e3))+")"
		case Product(Sum(e1, e2),e3) =>"("+show(Sum(e1,e2))+")*"+show(e3)
		case Product(e1, e2) => show(e1) +"*"+ show(e2)
	}                                         //> show: (e: pattern_matching_and_list_4.Expr)String

	
	
	val expr0 = Sum(Product(Number(2), Number(3)), Number(4))
                                                  //> expr0  : pattern_matching_and_list_4.Sum = Sum(Product(Number(2),Number(3))
                                                  //| ,Number(4))
	println("Expr0: " + show(expr0))          //> Expr0: 2*3+4
	assert(eval(expr0) == 10)
	
	val expr1 = Product(Number(4), Number(12))//> expr1  : pattern_matching_and_list_4.Product = Product(Number(4),Number(12)
                                                  //| )
	println("Expr1: " + show(expr1))          //> Expr1: 4*12
	assert(eval(expr1) == 48)

	val expr2 = Product(Sum(Number(2), Number(3)), Number(4))
                                                  //> expr2  : pattern_matching_and_list_4.Product = Product(Sum(Number(2),Number
                                                  //| (3)),Number(4))
	println("Expr2: " + show(expr2))          //> Expr2: (2+3)*4
	assert(eval(expr2) == 20)

	val expr3 = Product(Number(2), Sum(Number(3), Number(4)))
                                                  //> expr3  : pattern_matching_and_list_4.Product = Product(Number(2),Sum(Number
                                                  //| (3),Number(4)))
	println("Expr3: " + show(expr3))          //> Expr3: 2*(3+4)
	assert(eval(expr3) == 14)
	
	val expr4 = Product(Sum(Number(3), Number(4)), Sum(Number(3), Number(4)))
                                                  //> expr4  : pattern_matching_and_list_4.Product = Product(Sum(Number(3),Number
                                                  //| (4)),Sum(Number(3),Number(4)))
	println("Expr4: " + show(expr4))          //> Expr4: (3+4)*(4+3)
	assert(eval(expr3) == 14)
	
	//question 2
	sealed abstract class BinaryTree
	case class Leaf(value: Int) extends BinaryTree
 	case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
 	
 	def leafSum(t:BinaryTree):Int=t match{
 		case Leaf(t)=>t
 		case Node(l,r)=> leafSum(l)+leafSum(r)
 	}                                         //> leafSum: (t: pattern_matching_and_list_4.BinaryTree)Int
 	
 	val x = Node(Node(Leaf(3), Leaf(8)), Leaf(5))
                                                  //> x  : pattern_matching_and_list_4.Node = Node(Node(Leaf(3),Leaf(8)),Leaf(5))
                                                  //| 
	println(x)                                //> Node(Node(Leaf(3),Leaf(8)),Leaf(5))
	println(leafSum(x))                       //> 16
}