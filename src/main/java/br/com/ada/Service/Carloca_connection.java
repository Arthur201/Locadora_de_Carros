package br.com.ada.Service;


import br.com.ada.Entities.Aluguel;
import br.com.ada.Entities.Carro;
import br.com.ada.Entities.Cliente;
import br.com.ada.Entities.Locadora;
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

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Inicial.getInstance().exibir(session);

    }






}

