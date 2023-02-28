package br.com.ada.Menus;

import br.com.ada.Interfaces.IMenuExibicao;
import br.com.ada.Interfaces.IMenuProcessamento;
import org.hibernate.Session;

import java.util.Scanner;

public class Inicial implements IMenuProcessamento<Session, String> {
    Scanner sc = new Scanner(System.in);
    private static final Inicial menuInicial = new Inicial();
    public static Inicial getInstance(){
        return menuInicial;
    }

    @Override
    public void exibir(Session session) {
        System.out.print("\n Bem vindo à Carloca!! Para locar um carro, " +
                "faça login ou crie uma conta:\n" +
                "1 -- login\n" +
                "2 -- criar conta\n" +
                "3 -- sair");

        processar(session,sc.next());


    }
    public void processar(Session session, String opcaoCliente) {
        switch (opcaoCliente){
            case "1":
                Login.getInstance().exibir(session);
                break;
            case "2":
                Cadastro.getInstance().exibir(session);
                break;
            case "3":
                System.out.println("Obrigado por nos escolher! Esperamos você de volta!");
                System.exit(0);
        }
    }
}
