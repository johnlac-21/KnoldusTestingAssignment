
import com.knoldus.models.{Company, Employee}
import com.knoldus.validator.{CompanyValidator, EmailValidator, EmployeeValidator}
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.test.assignmentInterface


class UTTest extends AnyFlatSpec with MockFactory {

  val email: EmailValidator = new EmailValidator()

  "An email" should "have an @" in {
    assert(email.emailIdIsValid("helloJohn.com") == false)
  }

  "An email recipient" should "have only letters and numbers" in {
    assert(email.emailIdIsValid("JoHn12_23@gmail.com") == false)
  }

  "An email domain" should "have only letters and numbers" in {
    assert(email.emailIdIsValid("John@gmail*il.com") == false)
  }

  "An email" should "have a ." in {
    assert(email.emailIdIsValid("John@gmailcom") == false)
  }

  "An email top level Domain" should "be .com, .net, or .org" in {
    assert(email.emailIdIsValid("John@gmail.ca") == false)
  }

  "An email" should "have a correct recipient and domain name" in {
    assert(email.emailIdIsValid("JohnLacalamita@knoldus.com") == true)
  }

  val company = new CompanyValidator
  val employee = new EmployeeValidator

  val comapny1: Company = Company("Knoldus", "knoldus@knoldus.com", "Noida")
  val company2 = Company("Google", "Google$$$@gmail.com", "San Francisco")
  val company3 = Company("Facebook", "Facebook@gmail.com", "Los Angeles")

  "A company name" should "not already exist in the database" in {
    assert(company.companyIsValid(comapny1) == false)
  }

  "A company email" should "be valid" in {
    assert(company.companyIsValid(company2) == false)
  }

  "A company with a valid email and name" should "be valid" in {
    assert(company.companyIsValid(company3) == true)
  }

  val employee1 = Employee("John", "Lacalamita", 19, 100000, "Engineer", "Google", "John@google.com")
  val employee2 = Employee("John", "Lacalamita", 19, 100000, "Engineer", "Knoldus", "Jo###hn@google.com")
  val employee3 = Employee("John", "Lacalamita", 19, 100000, "Engineer", "Knoldus", "John@knoldus.com")

  "An employee's company" should "exist in the database" in {
    assert(employee.employeeIsValid(employee1) == false)
  }

  "An employee's email" should "be valid" in {
    assert(employee.employeeIsValid(employee2) == false)
  }

  "An employee with a valid company and email" should "be a valid employee" in {
    assert(employee.employeeIsValid(employee3) == true)
  }



  val m = mock[assignmentInterface]
  (m.fibonacci _) when(8) returns(21)
  (m.divide _) when(8,4) returns(2)





}
