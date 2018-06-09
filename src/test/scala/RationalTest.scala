import org.scalatest.{FunSuite, Matchers}

class RationalTest extends FunSuite with Matchers {

  test("should return an exception when denominator is 0") {
    intercept[IllegalArgumentException](new Rational(3, 0))
  }

  test("should return the representation of a rational number") {
    new Rational(3, 4).toString should be("3/4")
  }

  test("should add two rational numbers") {
    val result = new Rational(1, 2).add(new Rational(1, 3))
    result should be(new Rational(5, 6))
  }

  test("should substract two rational numbers") {
    val result = new Rational(1, 2).substract(new Rational(2, 3))
    result should be(new Rational(-1, 6))
  }

  test("should multiply two rational numbers") {
    val result = new Rational(1, 2).multiply(new Rational(2, 3))
    result should be(new Rational(2, 6))
  }

  test("should divide two rational numbers") {
    val result = new Rational(1, 2).divide(new Rational(2, 3))
    result should be(new Rational(3, 4))
  }

  test("should return an equivalent rational number normalized by greatest common divisor") {
    new Rational(10, 20) should be(new Rational(1, 2))
  }

}
