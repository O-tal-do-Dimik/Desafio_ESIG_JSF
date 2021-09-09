package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cadastro;

public class CadastroDao extends GenericDao {

	public List<Cadastro> listCadastro() {

		
		EntityManager entityManager = new EntityManagerCadastro().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.getTransaction();

		Query query = entityManager.createNamedQuery("Cadastro.encontrarTodos");

		@SuppressWarnings("unchecked")
		List<Cadastro> cadastros = ((List<Cadastro>) query.getResultList());

		entityManager.getTransaction().commit();
		entityManager.close();

		return cadastros;
	}
	
	
	//
	public List<Cadastro> listBusca(String titulo_busca, String descricao_busca, String responsavel_busca, String situacao_busca, Integer id_busca) {
		 
		
			EntityManager entityManager = new EntityManagerCadastro().getEntityManager();
	
			entityManager.getTransaction().begin();
			entityManager.getTransaction();
	
			//executa query de busca
			Query query = null;
			
			if(id_busca == null)
			{
				query = entityManager.createNamedQuery("Cadastro.busca_semId");
			}else {
				query = entityManager.createNamedQuery("Cadastro.busca");
				query.setParameter("varId", id_busca);
			}
			
			query.setParameter("varTitulo", titulo_busca.toLowerCase()+"%");
			query.setParameter("varDescricao", descricao_busca.toLowerCase()+"%");
			query.setParameter("varResponsavel", responsavel_busca.toLowerCase()+"%");
			query.setParameter("varSituacao", situacao_busca.toLowerCase()+"%");

			
			
			@SuppressWarnings("unchecked")
			List<Cadastro> cadastros = ((List<Cadastro>) query.getResultList());
	
			entityManager.getTransaction().commit();
			entityManager.close();
	
			
			
			return cadastros;
			
			
		}
	
	
	
}
