package br.com.aps;

public class Texto {

    private String texto;
    private Texto proximo;

    //metodo construtor leva o nome da classe
    //metodo construtor serve para inicializar os objetos da classe
    public Texto(String texto) {
        this.texto = texto;
    }

    public Texto getProximo() {
        return proximo;
    }

    public void setProximo(Texto proximo) {
        this.proximo = proximo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
