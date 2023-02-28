package br.com.ada.Menus;

import br.com.ada.Entities.*;
import br.com.ada.Interfaces.IMenuParametrizado;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAluguel implements IMenuParametrizado<Session, Cliente, List> {
    private static final MenuAluguel menuAluguel = new MenuAluguel();
    public static MenuAluguel getInstance(){
        return menuAluguel;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void exibir(Session session, Cliente cliente) {
        System.out.println("Abaixo estão nossos carros disponíveis para locação:");
        Locadora.getInstance().readCarros(session);
        System.out.println("Selecione o código do carro o qual deseja locar");
        int codigoCarroSelecionado = sc.nextInt();

        System.out.println("Você selecionou o nosso " + Locadora.getInstance().readCarroSelecionado(session,codigoCarroSelecionado).getModelo());
        System.out.println("Quantas diárias você deseja? ");
        int diarias = sc.nextInt();

        Locadora.getInstance().readEnderecoUnidades(session).forEach(endereco_unidades -> {
            System.out.println(endereco_unidades.toString());
            System.out.println();
        });
        System.out.println("Selecione a unidade a qual deseja fazer a retirada do carro. Digite seu respectivo ID:  ");
        int IdUnidadeDesejada = sc.nextInt();

        System.out.println("Parabéns!! Você acaba de locar nosso " + Locadora.getInstance().readCarroSelecionado(session,codigoCarroSelecionado).getMontadora() + " " + Locadora.getInstance().readCarroSelecionado(session,codigoCarroSelecionado).getModelo() +
                " por " + diarias + " dias, sendo a data de devolução "
                + LocalDate.now().plusDays(diarias));

        List<Integer> infoAluguel = new ArrayList<>();
        infoAluguel.add(0,codigoCarroSelecionado);
        infoAluguel.add(1,diarias);
        infoAluguel.add(2,IdUnidadeDesejada);

        processar(session,cliente, infoAluguel);
    }

    @Override
    public void processar(Session session, Cliente cliente,List infoAluguel) {
        Carro carro = new Carro();
        carro.setCodigoCarro((Integer) infoAluguel.get(0));

        Aluguel aluguel = new Aluguel();
        aluguel.setIdCarro(carro.getId());
        aluguel.setIdCliente(cliente.getId());
        aluguel.setDataRetirada(LocalDate.now());
        aluguel.setDataDevolucao(LocalDate.now().plusDays((Integer)infoAluguel.get(1)));
        aluguel.setIdEnderecoRetirada((Integer) infoAluguel.get(2));
        aluguel.setIdEnderecoDevolucao((Integer) infoAluguel.get(2));
        aluguel.setAtivo(Status_Aluguel.S);

        session.save(aluguel);
        session.beginTransaction();
        session.getTransaction().commit();


        // update situacaoCarro para "indisponivel";
        // update status do cliente para "inloca";
    }
}
