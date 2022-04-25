package br.com.zup.edu.nossodezeer.musica;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "musica", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private NumeroDeOuvintes numeroDeOuvintes;

    @OneToOne(mappedBy = "musica", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikes quantidadeLikes;
    
    @Version
    private int versao;

    private LocalDateTime criadoEm = now();

    private LocalDateTime atualiazadoEm = now();


    public Musica(String nome) {
        this.nome = nome;
        this.numeroDeOuvintes = new NumeroDeOuvintes(this);
        this.quantidadeLikes = new QuantidadeLikes(this);
    }

    /**
     * @deprecated construtor de uso exclusivo
     */
    @Deprecated
    public Musica() {
    }


    public void aumentarOuvinte() {
        this.numeroDeOuvintes.incrementa();;
    }

    public void aumentarLikes() {
        this.quantidadeLikes.incrementa();
    }
}

