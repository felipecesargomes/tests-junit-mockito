package br.com.felipecesar.tests_junit_mockito.model;


public class Motor {

    private boolean ligado;
    private int velocidadeMax;
    private int potencia;

    public int getVelocidadeMax() {
        return velocidadeMax;
    }

    public void setVelocidadeMax(int velocidadeMax) {
        this.velocidadeMax = velocidadeMax;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void ligar() {
        ligado = true;
        System.out.println("Motor ligado");
    }

    public void desligar() {
        ligado = false;
        System.out.println("Motor desligado");
    }

    public void acelerar() {
        System.out.println("Motor acelerando");
    }

    public void frear() {
        System.out.println("Motor freando");
    }

    public void parar() {
        System.out.println("Motor parando");
    }

    public void girar() {
        System.out.println("Motor girando");
    }

    public void virar() {
        System.out.println("Motor virando");
    }

    public void andar() {
        System.out.println("Motor andando");
    }

    public Motor() {
        System.out.println("Motor ligado");
    }

    @Override
    public String toString() {
        return "Motor{" +
                "ligado=" + ligado +
                ", velocidadeMax=" + velocidadeMax +
                ", potencia=" + potencia +
                '}';
    }
}
