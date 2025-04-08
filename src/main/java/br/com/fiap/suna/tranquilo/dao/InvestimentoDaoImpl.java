package br.com.fiap.suna.tranquilo.dao;

import br.com.fiap.suna.tranquilo.entity.Investimento;
import jakarta.persistence.EntityManager;

public class InvestimentoDaoImpl extends GenericDaoImpl<Investimento, Integer> implements InvestimentoDao {

    public InvestimentoDaoImpl(EntityManager em) {
        super(em);
    }

}
