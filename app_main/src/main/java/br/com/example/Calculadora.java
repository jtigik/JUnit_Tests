package br.com.example;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println(calc.somar(3, 4));
    }
}
