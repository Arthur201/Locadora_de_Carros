package br.com.ada.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO_UNIDADES")
@Getter
@Setter
public class Endereco_Unidades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Integer id;
    private String logradouro;
    private String cidade;
    private String estado;
    private String CEP;

}
