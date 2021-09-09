package test;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;

import org.junit.Test;

import dao.EntityManagerCadastro;
import model.Cadastro;

public class DaoCadastroTeste {

		

	@Test
	public void populaTabelaCompetence() throws ParseException{
		
		EntityManagerCadastro  emp = new EntityManagerCadastro();
		EntityManager entityManager = emp.getEntityManager();
		
		entityManager.getTransaction().begin();
		
	
		Cadastro cadastro = new Cadastro();
						cadastro.setTitulo("teste");
						cadastro.setDescricao("asasa ");
						cadastro.setResponsavel("xxxx");
						cadastro.setPrioridade("zzzzz");
						cadastro.setSituacao("weqwqw");
						
						Date date = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2012");
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						
				
						cadastro.setDeadline(calendar);
				
				
		
		entityManager.persist(cadastro);

		entityManager.getTransaction().commit();
		entityManager.close();
		
		assertEquals("teste", cadastro.getTitulo()); 
			
		  	
	}
	
	
}