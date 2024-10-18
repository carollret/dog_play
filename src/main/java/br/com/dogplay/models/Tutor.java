package br.com.dogplay.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Usuarios")


public class Tutor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String endereco;

}