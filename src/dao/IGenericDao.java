package dao;

import java.util.List;

public interface IGenericDao {

	public abstract <T> void criaCadastro(T entity);

	public abstract <T> T procuraIdcadastro(Class<T> entityClass, Object id);

	public abstract <T> void atualizaCadastro(T entity);

	public abstract <T> void deletaCadastro(Class<T> entityClass, Object id);
	
	public abstract <T> List<T> listaCadastro(Class<T> entityClass);
	
	
}
