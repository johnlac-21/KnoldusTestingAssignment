package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {
    val email: EmailValidator = new EmailValidator()
    val duplicateCheck = new CompanyReadDto
    val duplicate = duplicateCheck.getCompanyByName(company.name)
    if(!duplicate.isEmpty) false
    else if(!email.emailIdIsValid(company.emailId)) false
    else true


  }
}
