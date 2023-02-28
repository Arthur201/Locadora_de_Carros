package br.com.ada.Entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CARROS")
@Getter
@Setter
@ToString
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String montadora;
    private String modelo;
    private String categoria;
    @Column(name = "codigo_carro")
    private Integer codigoCarro;
    private String situacao;
}
