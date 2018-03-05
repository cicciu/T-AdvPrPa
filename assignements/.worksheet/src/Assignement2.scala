object Assignement2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  println("Welcome to the Scala worksheet");$skip(57); 
  
  def fact(x:Int):Int = if(x==0) 1 else x * fact(x-1);System.out.println("""fact: (x: Int)Int""");$skip(11); val res$0 = 

  fact(4);System.out.println("""res0: Int = """ + $show(res$0))}
}
