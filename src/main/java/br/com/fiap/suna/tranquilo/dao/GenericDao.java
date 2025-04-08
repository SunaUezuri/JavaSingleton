package br.com.fiap.suna.tranquilo.dao;


import br.com.fiap.suna.tranquilo.exception.CommitException;
import br.com.fiap.suna.tranquilo.exception.IdNaoEncontradoException;

public interface GenericDao<T,K> {

    T salvar(T entidade);

    void remover(K id) throws IdNaoEncontradoException;

    T buscar(K id) throws IdNaoEncontradoException;

    void commit() throws CommitException;

}
