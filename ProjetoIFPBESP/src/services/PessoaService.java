package services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PessoaService implements Serializable, Service<Pessoa>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;
	
	@Inject
	private PessoaDAO PessoaDAO;
	
	@Override
	@TransacionalCdi
	public void save(Pessoa Pessoa) {
		PessoaDAO.save(Pessoa);
	}

	@Override
	@TransacionalCdi
	public void update(Pessoa Pessoa)  {
		PessoaDAO.update(Pessoa);
	}

	@Override
	@TransacionalCdi
	public void remove(Pessoa Pessoa) {
		PessoaDAO.remove(Pessoa);
	}

	@Override
	public Pessoa getByID(long PessoaId)  {
			return PessoaDAO.getByID(PessoaId);
	}

	@Override
	public List<Usuario> getAll() {
			return userDAO.getAll();
	}
		
}
