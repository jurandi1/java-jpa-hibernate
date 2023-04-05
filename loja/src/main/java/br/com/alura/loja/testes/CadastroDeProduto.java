package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
//		Produto celular = new Produto("Xiaomi Redmi","Muito legal!", new BigDecimal("900"), celulares);
        
        EntityManager em = JPAUtil.getEntityManager();
//      ProdutoDao produtoDao = new ProdutoDao(em); 
//      CategoriaDao categoriaDao = new CategoriaDao(em); 
        
        em.getTransaction().begin();
        
//      categoriaDao.cadastrar(celulares);
//      produtoDao.cadastrar(celular);
        
        em.persist(celulares); // De transient para Managed
        celulares.setNome("JURA");
        
        em.getTransaction().commit();
        em.close(); // Fechando o EntityManager
        
        celulares.setNome("1234");  // Qualquer alteração após o close é ignorada. 
	}

}
