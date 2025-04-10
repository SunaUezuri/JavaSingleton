package br.com.fiap.suna.tranquilo.view;

import br.com.fiap.suna.tranquilo.dao.InvestimentoDao;
import br.com.fiap.suna.tranquilo.dao.InvestimentoDaoImpl;
import br.com.fiap.suna.tranquilo.entity.Investimento;
import br.com.fiap.suna.tranquilo.entity.TipoInvestimento;
import br.com.fiap.suna.tranquilo.exception.CommitException;
import br.com.fiap.suna.tranquilo.exception.IdNaoEncontradoException;
import br.com.fiap.suna.tranquilo.singleton.EntityManagerFactorySingleton;
import javax.persistence.EntityManager;

public class View {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        InvestimentoDao dao = new InvestimentoDaoImpl(em);

        Investimento investimento = new Investimento("Tranquilo Coin Better", 10000001.0, TipoInvestimento.CRIPTO);

        //Cadastrar
        try {
            dao.salvar(investimento);
            dao.commit();
            System.out.println("Investimento Cadastrado!");
        } catch (CommitException e){
            System.out.println(e.getMessage());
        }

        //Read
        try {
            Investimento busca = dao.buscar(2);
            System.out.println(busca.getNome());

            //Atualizar
            busca.setValor(1000.0);
            dao.salvar(busca);
            dao.commit();
            System.out.println("Investimento atualizado");
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (CommitException f) {
            System.out.println(f.getMessage());
        }

        //Deletar
        try {
            dao.remover(2);
            dao.commit();
            System.out.println("Investimento removido!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
