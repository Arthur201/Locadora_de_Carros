package br.com.ada.Interfaces;

import org.hibernate.Session;

public interface IMenuProcessamento<T, E>  {
    void exibir(T t);
    void processar(T t, E e);
}
