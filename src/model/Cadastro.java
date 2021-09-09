package model;

import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
@NamedQuery(name="Cadastro.encontrarTodos", query="SELECT c FROM Cadastro c"),
@NamedQuery(name="Cadastro.busca", 
			query="SELECT c FROM Cadastro c WHERE LOWER(c.titulo) LIKE :varTitulo AND "
					+ "LOWER(c.descricao) LIKE :varDescricao AND"
					+ " LOWER(c.responsavel) LIKE :varResponsavel "
					+ "AND LOWER(c.situacao) LIKE :varSituacao AND c.id = :varId"),
@NamedQuery(name="Cadastro.busca_semId", 
query="SELECT c FROM Cadastro c WHERE LOWER(c.titulo) LIKE :varTitulo AND "
		+ "LOWER(c.descricao) LIKE :varDescricao AND"
		+ " LOWER(c.responsavel) LIKE :varResponsavel "
		+ "AND LOWER(c.situacao) LIKE :varSituacao")
})
@Entity
public class Cadastro  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String titulo;
	
	@Column(columnDefinition = "TEXT")
    private String descricao;
	
    private String responsavel;
    private String prioridade;
    private String situacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar deadline = Calendar.getInstance();
    
    
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public Calendar getDeadline() {
		return deadline;
	}
	public void setDeadline(Calendar deadline) {
		this.deadline = deadline;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
    
	
}
