package br.com.ada.Menus;

import br.com.ada.Entities.Cliente;
import br.com.ada.Entities.Locadora;
import br.com.ada.Interfaces.IMenuProcessamento;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro implements IMenuProcessamento<Session, List<String>> {
    private static final Cadastro menuCadastro = new Cadastro();
    public static Cadastro getInstance(){
        return menuCadastro;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void exibir(Session session) {
        System.out.println("Digite seu nome: ");
        String nome = sc.next();
        System.out.println("Digite seu CPF: ");
        String cpf = sc.next();
        List<String> cadastro = new ArrayList<>();

        cadastro.add(0,nome);
        cadastro.add(1,cpf);
        processar(session, cadastro);
    }


    @Override
    public void processar(Session session, List<String> cadastro) {
        System.out.println(Locadora.getInstance().createClient(session,cadastro.get(0), cadastro.get(1)));
        Inicial.getInstance().exibir(session);
    }
}
