package br.com.example;

public class Main {

    public int soma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Main calc = new Main();
        System.out.println(calc.soma(3, 4));
    }
}
