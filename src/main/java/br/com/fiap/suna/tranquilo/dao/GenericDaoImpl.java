package br.com.fiap.suna.tranquilo.dao;

import java.lang.reflect.ParameterizedType;

import br.com.fiap.suna.tranquilo.exception.CommitException;
import br.com.fiap.suna.tranquilo.exception.IdNaoEncontradoException;
import javax.persistence.EntityManager;

public abstract class GenericDaoImpl<T,K> implements GenericDao<T, K> {

    private EntityManager em;

    private Class<T> clazz; //Atributo que recebe o .class de T (Entidade)

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        //Obter em tempo de execucao o .class da Entidade
        this.clazz = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T salvar(T entidade) {
        return em.merge(entidade);
    }

    public void remover(K id) throws IdNaoEncontradoException {
        T entidade = buscar(id);
        em.remove(entidade);
    }

    public T buscar(K id) throws IdNaoEncontradoException {
        T entidade = em.find(clazz, id);
        if (entidade == null) {
            throw new IdNaoEncontradoException("Entidade nao encontrada");
        }
        return entidade;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
