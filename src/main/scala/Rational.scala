class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g


  def this(n: Int) = this(n, 1)

  def canEqual(other: Any): Boolean = other.isInstanceOf[Rational]

  override def equals(other: Any): Boolean = other match {
    case that: Rational =>
      (that canEqual this) &&
        numer == that.numer &&
        denom == that.denom
    case _ => false
  }

  override def toString: String = numer + "/" + denom

  def add(otherRational: Rational): Rational = {
    new Rational(
      denom * otherRational.numer + otherRational.denom * numer, otherRational.denom * denom)
  }

  def substract(otherRational: Rational): Rational = add(new Rational(-otherRational.numer, otherRational.denom))

  def multiply(otherRational: Rational): Rational = {
    new Rational(
      numer * otherRational.numer, otherRational.denom * denom)
  }

  def divide(otherRational: Rational): Rational = multiply(new Rational(otherRational.denom, otherRational.numer))

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}

