package br.com.dogplay.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Servico")

public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String taxa;
    private String preco;
    private String localizacao;
    private String endereco;
    private String atividade;
    private int horaPasseio;
    @ManyToMany(mappedBy = "servicos")
    private List<Prestador> prestador;
}