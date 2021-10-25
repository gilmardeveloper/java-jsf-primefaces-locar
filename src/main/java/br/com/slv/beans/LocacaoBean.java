package br.com.slv.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.slv.annotations.Transactional;
import br.com.slv.models.Locacao;
import br.com.slv.models.Pessoa;
import br.com.slv.repositories.LocacaoRepository;

@Named
@ViewScoped
public class LocacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Locacao locacao;

	@Inject
	private LocacaoRepository locacaoRepository;

	public Locacao getLocacao() {
		return locacao;
	}

	public void load(Pessoa pessoa) {
		locacao.setPessoa(pessoa);
	}

	public List<Locacao> getLocacoes() {
		return locacaoRepository.findAll();
	}

	@Transactional
	public String salvar() {

		LocalDate saida = LocalDate.now();
		LocalDate retorno = LocalDate.now().plusDays(1);

		int days = Period.between(saida, retorno).getDays();
		long hours = Duration.ofDays(days).toHours();

		BigDecimal valorHora = locacao.getVeiculo().getValorHora();
		BigDecimal valor = valorHora.multiply(new BigDecimal(hours));

		locacao.setValor(valor);
		locacao.setDataSaida(saida);
		locacao.setDataRetorno(retorno);

		locacaoRepository.save(locacao);

		return "home?faces-redirect=true";
	}

}
