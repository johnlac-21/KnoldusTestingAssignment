package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {
    if(!emailId.contains('@')) false
    else{
      val array: Array[String] = emailId.split('@')
      if(!array(1).contains('.')) false
      else {
        val recipientName = array(0)
        val domainName = array(1).split('.')(0)
        val topLevelDomain = array(1).split('.')(1)
        if(!recipientName.forall(_.isLetterOrDigit)) false
        else if (!domainName.forall(_.isLetterOrDigit)) false
        else if (!topLevelDomain.equals("com") && !topLevelDomain.equals("net") && !topLevelDomain.equals("org")) false
        else true
      }
    }
  }
}

object main extends App{
  val email: EmailValidator = new EmailValidator()
  println(email.emailIdIsValid("JohnLacalamita@knoldus.com"))
}
