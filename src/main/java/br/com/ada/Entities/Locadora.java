package br.com.ada.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;

import java.util.List;

@Getter
@Setter
public class Locadora {

    private static final Locadora locadora = new Locadora();

    public static Locadora getInstance(){
        return locadora;
    }

    public String createClient(Session session, String nome, String cpf) {
        Cliente client = new Cliente();
        client.setNome(nome);
        client.setCPF(cpf);
        client.setSituacao("ativo");

        session.save(client);

        session.beginTransaction();
        session.getTransaction().commit();
        return "Cadastro criado!";
    }
    public void readClients(Session session) {
        List<Cliente> clientes = session.createQuery("from Cliente").getResultList();

        clientes.forEach(cliente -> {
            System.out.printf("cliente %s", cliente.getNome());
            System.out.println();
        });
    }

    public void createCarro(Session session, String montadora, String modelo, String categoria, Integer codigoCarro, String situacao){
        Carro carro = new Carro();
        carro.setMontadora(montadora);
        carro.setModelo(modelo);
        carro.setCategoria(categoria);
        carro.setCodigoCarro(codigoCarro);
        carro.setSituacao(situacao);

        session.save(carro);
        session.beginTransaction();
        session.getTransaction().commit();

    }

    public void readCarros(Session session){
        List<Carro> carros = session.createQuery("from Carro where situacao = 'disponivel'").getResultList();

        carros.forEach(carro -> {
            System.out.printf("carro %s | Categoria: %s | Código do carro: %d \n", carro.getModelo(), carro.getCategoria(), carro.getCodigoCarro());
            System.out.println();
        });
    }

    public Carro readCarroSelecionado(Session session, Integer carroSelecionado){
        Carro carro = (Carro) session.createQuery("from Carro where codigo_carro = :codigo_carro").setParameter("codigo_carro", carroSelecionado).getSingleResult();
        return carro;

    }

    public List<Endereco_Unidades> getEnderecoUnidades(Session session){
        List<Endereco_Unidades> enderecosUnidades = session.createQuery("from Endereco_Unidades").getResultList();
        return  enderecosUnidades;

    }
}
