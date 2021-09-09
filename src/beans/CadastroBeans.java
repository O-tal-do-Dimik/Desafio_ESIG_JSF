package beans;


import model.Cadastro;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.CadastroDao;


@ManagedBean
@ViewScoped
public class CadastroBeans {

	
	private Cadastro cadastro = new Cadastro();
	private Cadastro cadastroBusca = new Cadastro();
	private Integer cadastroId;

	public Cadastro getCadastro() {
		return cadastro;
	}
	
	public Cadastro getCadastroBusca() {
		return cadastroBusca;
	}
	
	public Integer getCadastroId() {
		return cadastroId;
	}
	public void setCadastroId(Integer cadastroId) {
		this.cadastroId = cadastroId;
	}
	
	
	
	public void CadastroById() {
		
		CadastroDao dao = new CadastroDao();
		this.cadastro = dao.procuraIdcadastro(Cadastro.class, cadastroId); 
	}
	
	
	
    public String salvar() {
		
		System.out.println("Gravando Cadastro " + this.cadastro.getTitulo());
		System.out.println("Gravando Cadastro " + this.cadastro.getDescricao());
		System.out.println("Gravando Cadastro " + this.cadastro.getResponsavel());
		System.out.println("Gravando Cadastro " + this.cadastro.getPrioridade());
		System.out.println("Gravando Cadastro " + this.cadastro.getDeadline());
		System.out.println("Gravando Cadastro " + this.cadastro.getSituacao());
		
		CadastroDao cadastroDao = new CadastroDao();
		
		if(this.cadastro.getId() == null){
			this.cadastro.setSituacao("Em andamento");
			cadastroDao.criaCadastro(this.cadastro);

			this.cadastro = new Cadastro(); // Limpa Campo
		}else{
			cadastroDao.atualizaCadastro(this.cadastro);
			this.cadastro = new Cadastro(); // Limpa Campo
		}
		return "titulo?faces-redirect=true";
	}
    
    
	public List<Cadastro> getListaCadastro() {
		
		List<Cadastro> listCadastro;
//		CadastroDao dao = new CadastroDao();
//		listCadastro = dao.listCadastro();
		
		if(this.cadastroBusca.getTitulo() == null) {
			//trazendo todos os cadastros do banco
			CadastroDao dao = new CadastroDao();
			listCadastro = dao.listCadastro();
		}else {
			//retornar lista de busca
			CadastroDao dao = new CadastroDao();
			
			String titulo_busca = this.cadastroBusca.getTitulo();
			String descricao_busca = this.cadastroBusca.getDescricao();
			String responsavel_busca = this.cadastroBusca.getResponsavel();
			String situacao_busca = this.cadastroBusca.getSituacao();
			Integer id_busca = this.cadastroBusca.getId();
			
			
			
			System.out.println(titulo_busca +" | "+ descricao_busca+" | "+responsavel_busca+" | "+situacao_busca+" | "+id_busca);
			
			listCadastro = dao.listBusca(titulo_busca, descricao_busca, 
					responsavel_busca, situacao_busca, id_busca);
		}
			
			
		return listCadastro;
	}
	
	

	public void deletar(Cadastro cadastro, Integer id) {
		
		CadastroDao dao = new CadastroDao();
		dao.deletaCadastro(Cadastro.class, id);
	}
	
	
	
	public void concluir(Cadastro cadastro, Integer id) {
		
		CadastroDao dao = new CadastroDao();
		Cadastro cadastro_concluir = dao.procuraIdcadastro(Cadastro.class, id);
		
		cadastro_concluir.setSituacao("Concluída");
		dao.atualizaCadastro(cadastro_concluir);
	}
	
	
	public void  carregaCadastro(Cadastro cadastro) {

		this.cadastro = cadastro;
	}

	
	
}
