package br.com.ada.Menus;

import br.com.ada.Entities.Cliente;
import br.com.ada.Entities.Locadora;
import br.com.ada.Interfaces.IMenuProcessamento;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class Login implements IMenuProcessamento<Session, String> {
    private static final Login menuLogin = new Login();
    public static Login getInstance(){
        return menuLogin;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void exibir(Session session) {
        System.out.println("Para fazer login, digite seus dados abaixo:\n");
        System.out.println("CPF: ");
        processar(session,sc.next());
    }

    @Override
    public void processar(Session session,String cpf) {
        try{
            Cliente cliente = (Cliente) session.createQuery("from Cliente where CPF = :cpf").setParameter("cpf", cpf).getSingleResult();
            MenuCliente.getInstance().exibir(session, cliente);
        }catch(NoResultException e){
            System.out.println("Você ainda não possui cadastro! Cadastre-se já!");
            Cadastro.getInstance().exibir(session);
        }

    }
}
