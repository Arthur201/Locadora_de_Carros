package br.com.ada.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ALUGUEL")
@IdClass(Aluguel.class)
@Getter
@Setter
public class Aluguel implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Integer id;
    @Column(name = "ID_CARRO")
    private @Id Integer IdCarro;
    @Column(name = "ID_CLIENTE")
    private @Id Integer idCliente;
    @Column(name = "data_retirada")
    private LocalDate dataRetirada;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    @Column(name = "ID_Endereco_retirada")
    private @Id Integer idEnderecoRetirada;
    @Column(name = "ID_Endereco_devolucao")
    private @Id Integer idEnderecoDevolucao;
    @Column(name = "quilometragem_rodada")
    private Float quilometragemRodada = 0.0f;
    private Enum ativo;


}
