package br.com.ada.Interfaces;

public interface IMenuParametrizado<T, S, R> {
    void exibir(T t, S s);
    void processar(T t, S s, R r);
}
