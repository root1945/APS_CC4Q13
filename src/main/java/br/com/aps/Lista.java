package br.com.aps;

import java.util.ArrayList;

public class Lista {

    private Texto cabeca = null;
    private Texto cauda = null;
    private String[] lista = new String[10];
    private static String[] name = new String[10];
    private String tudo = "";
    private int total = 0;

    public void adicionarElementoNoFimDaLista(Texto e) {
        if (cabeca == null) {
            cabeca = e;
            cauda = e;
        } else if (cauda.getProximo() == null) {
            cauda.setProximo(e);
            cauda = e;
        }
        total++;
    }

    public int tamanho() {
        return total;
    }

    public String adicionarTodos() {
        Texto aux = cabeca;
        while (aux != null) {
            tudo = tudo + "\n\n" + aux.getTexto();
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == null) {
                    lista[i] = aux.getTexto();
                    break;
                };
            }
            aux = aux.getProximo();
        }
        return tudo;
    }

    public void adicionarElementoNoInicioDaLista(Texto e) {
        e.setProximo(cabeca);
        cabeca = e;
        total++;
    }

    public void removerEstudanteDaLista(Texto e) {
        Texto aux = cabeca;
        while (aux != null) {
            if (aux.getProximo() == e) {
                Texto proximo = aux.getProximo();
                aux.setProximo(proximo.getProximo());
            } else if (aux == e) {
                cabeca = e.getProximo();
            }
            aux = aux.getProximo();
        }
    }

    public String bubbleSort(String[] e) {
        String temp;
        String tudo = "";
        for (int j = 0; j < e.length; j++) {
            for (int i = j + 1; i < e.length; i++) {
                // comparing adjacent strings
                if (e[i] != null) {
                    if (e[i].compareTo(e[j]) < 0) {
                        temp = e[j];
                        e[j] = e[i];
                        e[i] = temp;
                    }
                }
            }
            if (e[j] != null) {
                tudo = tudo + "\n" + e[j];
            }
        }
        return tudo;
    }

    public void adicionarTextoNoMeioDaLista(Texto e, int posicao) {
        Texto aux = cabeca;
        for (int i = 0; i <= posicao; i++) {
            if (i == posicao) {
                e.setProximo(aux.getProximo());
                aux.setProximo(e);
            }
            aux = aux.getProximo();
        }
        total++;
    }

    public static void quicksortn(int low, int high) {
        int i = low, j = high;
        String pivot = name[low + (high - low) / 2];
        while (i <= j) {
            while (name[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (name[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksortn(low, j);
        }
        if (i < high) {
            quicksortn(i, high);
        }
    }

    private static void exchange(int i, int j) {
        String temp = name[i];
        name[i] = name[j];
        name[j] = temp;
    }

    public static void inserirListaQuickSort(int indice, String texto) {
        name[indice] = texto;
    }
    
    public static String mostrarListaQuickSort(){
        String tudo = "";
        for(int i = 0; i < name.length; i++){
            if(name[i] == null) break;
            tudo += "\n" + name[i];
        }
        return tudo;
    }

    public String[] getLista() {
        return lista;
    }

    public String getTudo() {
        return tudo;
    }

    public void setTudo(String tudo) {
        this.tudo = tudo;
    }

    public String getTextoPrimeiro() {
        return (cabeca != null ? cabeca.getTexto() : " ");
    }

    public String getNomeUltimo() {
        return (cauda != null ? cauda.getTexto() : " ");
    }
}
