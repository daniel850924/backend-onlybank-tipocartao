package br.unibh.sdm.backend_onlybank.entidades;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tipo_cartao")
public class TipoCartao {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(length = 100)
	@Size(min = 3, max = 100)
	private String bandeira;

	@NotBlank
	@Column(length = 100)
	@Size(min = 3, max = 100)
	private String modalidade;

	public TipoCartao() {
	}

	public TipoCartao(String bandeira, String modalidade) {
		this.bandeira = bandeira;
		this.modalidade = modalidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "TipoCartao{" +
				"id=" + id +
				", bandeira='" + bandeira + '\'' +
				", modalidade='" + modalidade + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TipoCartao that = (TipoCartao) o;
		return Objects.equals(id, that.id) && Objects.equals(bandeira, that.bandeira) && Objects.equals(modalidade, that.modalidade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, bandeira, modalidade);
	}
}
