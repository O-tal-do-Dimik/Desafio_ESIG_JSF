package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import dao.CadastroDao;
import model.Cadastro;



public class DaoGenericTeste {


	@Test
	public void Encontrarumcadastro() throws ParseException{
		
		CadastroDao cadastroDao = new CadastroDao();
		
		Cadastro cadastro =  new Cadastro();
				 cadastro.setTitulo("teste1");
				 cadastro.setDescricao("teste1 ");
				 cadastro.setResponsavel("Roberval");
				 cadastro.setPrioridade("Media");
				 cadastro.setSituacao("Concluida");
				
				 Date date = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2012");
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(date);
			
	
			     cadastro.setDeadline(calendar);
			
		cadastroDao.criaCadastro(cadastro);
		
		assertEquals("teste", cadastro.getTitulo());
		
	}
	
	
}
