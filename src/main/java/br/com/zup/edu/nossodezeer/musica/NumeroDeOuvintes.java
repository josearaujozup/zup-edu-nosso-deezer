package br.com.zup.edu.nossodezeer.musica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class NumeroDeOuvintes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private long quantidade;
	
	@Version
    private int versao;
	
	@OneToOne
	private Musica musica;

	public NumeroDeOuvintes(Musica musica) {
		this.musica = musica;
		this.quantidade=0;
	}
	
	/**
     * @deprecated
     */
    @Deprecated
	public NumeroDeOuvintes() {
		
	}
	
	public void incrementa() {
		this.quantidade++;
	}
	
}
