package br.com.jtigik.testes;

public class Calculadora {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println(calc.soma(2, 3) == 5);
        System.out.println(calc.soma(3, 4) == 7);
        System.out.println(calc.soma(4, 5) == 11);
    }

    public int soma(int i, int j) {
        return i + j;
    }

    // num = Numerador, den = Denominador
    public float divide(int num, int den) {
        return (float) num / den;
    }

}
