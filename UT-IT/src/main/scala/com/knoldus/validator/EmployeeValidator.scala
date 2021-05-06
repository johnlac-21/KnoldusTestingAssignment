package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee

class EmployeeValidator {

  def employeeIsValid(employee: Employee): Boolean = {
    val email: EmailValidator = new EmailValidator()
    val duplicateCheck = new CompanyReadDto
    val duplicate = duplicateCheck.getCompanyByName(employee.companyName)
    if(duplicate.isEmpty) false
    else if(!email.emailIdIsValid(employee.emailId)) false
    else true
  }
}
