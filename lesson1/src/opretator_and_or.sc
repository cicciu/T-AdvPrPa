object opretator_and_or {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def and(x:Boolean, y:Boolean):Boolean =
  	if(x)
  		y
  	else
  		false                             //> and: (x: Boolean, y: Boolean)Boolean
  		
  def or(x:Boolean, y:Boolean):Boolean=
  	if(x)true else y                          //> or: (x: Boolean, y: Boolean)Boolean
  		
  or(false,false)                                 //> res0: Boolean = false
  or(true,false)                                  //> res1: Boolean = true
  or(false,true)                                  //> res2: Boolean = true
  or(true,true)                                   //> res3: Boolean = true
  
  
  and(false,false)                                //> res4: Boolean = false
  and(true,false)                                 //> res5: Boolean = false
  and(false,true)                                 //> res6: Boolean = false
  and(true,true)                                  //> res7: Boolean = true
  
  true || true                                    //> res8: Boolean(true) = true
  true || false                                   //> res9: Boolean(true) = true
  false || true                                   //> res10: Boolean(true) = true
  false || false                                  //> res11: Boolean(false) = false
  
  def not(x:Boolean):Boolean=
  	if(x)
  		false
  	else
  		true                              //> not: (x: Boolean)Boolean
  not(or(true,true))                              //> res12: Boolean = false
  	
}