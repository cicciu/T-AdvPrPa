object opretator_and_or {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 
  println("Welcome to the Scala worksheet");$skip(81); 
  
  
  def and(x:Boolean, y:Boolean):Boolean =
  	if(x)
  		y
  	else
  		false;System.out.println("""and: (x: Boolean, y: Boolean)Boolean""");$skip(65); 
  		
  def or(x:Boolean, y:Boolean):Boolean=
  	if(x)true else y;System.out.println("""or: (x: Boolean, y: Boolean)Boolean""");$skip(23); val res$0 = 
  		
  or(false,false);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(17); val res$1 = 
  or(true,false);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(17); val res$2 = 
  or(false,true);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(16); val res$3 = 
  or(true,true);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(25); val res$4 = 
  
  
  and(false,false);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(18); val res$5 = 
  and(true,false);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(18); val res$6 = 
  and(false,true);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(17); val res$7 = 
  and(true,true);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(18); val res$8 = 
  
  true || true;System.out.println("""res8: Boolean(true) = """ + $show(res$8));$skip(16); val res$9 = 
  true || false;System.out.println("""res9: Boolean(true) = """ + $show(res$9));$skip(16); val res$10 = 
  false || true;System.out.println("""res10: Boolean(true) = """ + $show(res$10));$skip(17); val res$11 = 
  false || false;System.out.println("""res11: Boolean(false) = """ + $show(res$11));$skip(69); 
  
  def not(x:Boolean):Boolean=
  	if(x)
  		false
  	else
  		true;System.out.println("""not: (x: Boolean)Boolean""");$skip(21); val res$12 = 
  not(or(true,true));System.out.println("""res12: Boolean = """ + $show(res$12))}
  	
}
