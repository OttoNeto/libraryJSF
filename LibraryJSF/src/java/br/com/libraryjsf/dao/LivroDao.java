/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.libraryjsf.dao;


import br.com.libraryjsf.facade.ILivroDao;
import br.com.libraryjsf.model.Livro;
import br.com.libraryjsf.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Felps
 */
public class LivroDao implements ILivroDao {

    private EntityManager em;

    @Override
    public void salvar(Livro livro) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public Livro buscar(String titulo) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo");
            query.setParameter("titulo", titulo);
            return (Livro) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Livro buscarById(long id) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l WHERE l.id = :id");
            query.setParameter("id", id);
            return (Livro) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void editar(Livro livro) throws Exception {//DONE

        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            livro.setAno(livro.getAno());
            livro.setAutor(livro.getAutor());
            livro.setCategoria(livro.getCategoria());
            livro.setEditora(livro.getEditora());
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    /*
    * ALTERANDO OO STATUS DO LIVRO PARA FALSE
     */
    @Override
    public void remover(Livro livro) throws Exception {//DONE
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            livro.setStatus(false);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    @Override
    public List<Livro> listarAll() throws Exception {
        List<Livro> lista = null;
 
        try {

            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM Livro l");
            lista = query.getResultList();
            JPAUtil.close();
            return lista;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
