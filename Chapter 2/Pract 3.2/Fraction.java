
package pract3_2;


public final class Fraction extends Number {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator <= 0){
            throw new IllegalArgumentException();
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public Fraction sum(int number){
        return sum(new Fraction(number, 1));
    }

    public Fraction sum(Fraction fraction){
        return new Fraction(numerator * fraction.denominator + fraction.numerator * denominator, denominator * numerator);
    }

    public Fraction minus(int number){
        return minus(new Fraction(number, 1));
    }

    public Fraction minus(Fraction fraction){
        return new Fraction(numerator * fraction.denominator + fraction.numerator * denominator, denominator * numerator);
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
    }

    public Fraction multiply(int number){
        return multiply(new Fraction(number, 1));
    }

    public Fraction divide(Fraction fraction){
        return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
    }

    public Fraction divide(int number){
        return divide(new Fraction(number, 1));
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) (numerator / denominator);
    }

    @Override
    public double doubleValue() {
        return (float) numerator / denominator;
    }
}
