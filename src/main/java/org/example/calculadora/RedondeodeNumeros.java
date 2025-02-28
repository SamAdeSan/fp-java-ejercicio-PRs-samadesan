package org.example.calculadora;

public class RedondeodeNumeros {
    private double num;

    public RedondeodeNumeros(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }
    public int numerordondejat(){
        int numr = (int) this.num;
        if(this.num-numr>=0.5){
            numr+=1;
        }
        return numr;
    }
}