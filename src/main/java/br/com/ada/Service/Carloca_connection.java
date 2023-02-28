package br.com.ada.Service;


import br.com.ada.Entities.*;
import br.com.ada.Menus.Inicial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Carloca_connection {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(Carro.class);
        configuration.addAnnotatedClass(Locadora.class);
        configuration.addAnnotatedClass(Aluguel.class);
        configuration.addAnnotatedClass(Endereco_Unidades.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Inicial.getInstance().exibir(session);

    }






}

