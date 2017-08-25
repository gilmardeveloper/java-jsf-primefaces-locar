package br.com.slv.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.slv.annotations.Transactional;
import br.com.slv.models.Pessoa;
import br.com.slv.repositories.PessoaRepository;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	@Inject
	private PessoaRepository pessoaRepository;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void add() {
		this.pessoa = new Pessoa();
	}

	public void update(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Transactional
	public String salvar() {

		pessoaRepository.save(pessoa);
		return "home?faces-redirect=true";
	}

	public Pessoa getPessoaPorCpf(String cpf) {
		return pessoaRepository.find(cpf);
	}

	@Transactional
	public void remove(Pessoa pessoa) {
		pessoaRepository.remove(pessoa);
	}

	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}

}
