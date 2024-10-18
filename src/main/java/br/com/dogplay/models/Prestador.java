package br.com.dogplay.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "prestador")


public class Prestador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String preco;
    private String passeador;
    private String adestrador;
    private String localizacao;
    @ManyToMany
    @JoinTable (name = "prestador_servico",
            joinColumns = {@JoinColumn(name = "id_prestador") },
            inverseJoinColumns = { @JoinColumn(name = "id_servico") })
    private List<Servico> servicos;

}