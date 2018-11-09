package beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import main.webapp.Pessoa;

@ViewScoped
@Named
public class PessoaBean implements Serializable {
	
	@Inject
	private PessoaService service;

	protected Pessoa pessoa;

	protected Collection<Pessoa> pessoas;

	public PessoaBean() {
	}
	
	@PostConstruct
	public void init() {
		pessoa = newPessoa();
		pessoas = getService().getAll();
	}

	public void remove(Pessoa entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setEntidade(Pessoa entidade) {
		this.pessoa = entidade;
	}

	public Collection<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void save() {
		getService().save(pessoa);
		limpar();
	}

	public void editar(Long id) {
		this.getPessoa().setId(id);
		save();
	}

	public void limpar() {
		pessoas = getService().getAll();
		pessoa = newPessoa();
	}

	protected Pessoa newPessoa() {
		return new Pessoa();
	}

	public PessoaService getService() {
		return service;
	}

}


}
