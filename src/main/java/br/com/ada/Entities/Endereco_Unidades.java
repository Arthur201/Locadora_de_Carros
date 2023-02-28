package br.com.ada.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO_UNIDADES")
@Getter
@Setter
public class Endereco_Unidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String cidade;
    private String estado;
    private String CEP;

    public String toString(){
        return "Rua/Av " + this.logradouro + ", " + this.cidade + ", " + this.estado + ". " + this.CEP;
    }

}
