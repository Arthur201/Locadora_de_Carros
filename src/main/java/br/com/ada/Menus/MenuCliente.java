package br.com.ada.Menus;

import br.com.ada.Entities.Cliente;
import br.com.ada.Interfaces.IMenuParametrizado;
import br.com.ada.Interfaces.IMenuProcessamento;
import org.hibernate.Session;

import java.util.Scanner;

public class MenuCliente implements IMenuParametrizado<Session, Cliente, String> {
    Scanner sc = new Scanner(System.in);
    private static final MenuCliente menuCliente = new MenuCliente();
    public static MenuCliente getInstance(){
        return menuCliente;
    }
    @Override
    public void exibir(Session session, Cliente cliente) {
        System.out.println("Olá " + cliente.getNome() + "! Bem vindo à Carloca! O que deseja:\n" +
                "1 -- Locar\n" +
                "2 -- Devolver\n" +
                "3 -- Consultar dados de locação\n" +
                "4 -- Voltar");

        processar(session, cliente, sc.next());
    }

    @Override
    public void processar(Session session,Cliente cliente, String opcaoCliente) {
        switch (opcaoCliente){
            case "1":
                MenuAluguel.getInstance().exibir(session, cliente);
                break;
            case "2":
//                menuDevolucao;
                break;
            case "3":
//                menuLocacao;
            case "4":
                Login.getInstance().exibir(session);
        }
    }
}
