package br.com.slv.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.slv.annotations.Transactional;
import br.com.slv.models.Veiculo;
import br.com.slv.repositories.VeiculoRepository;

@Named
@ViewScoped
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Veiculo veiculo;

	@Inject
	private VeiculoRepository veiculoRepository;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void add() {
		this.veiculo = new Veiculo();
	}

	public void update(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Transactional
	public String salvar() {

		veiculoRepository.save(veiculo);
		return "veiculo?faces-redirect=true";
	}

	public Veiculo getVeiculoPorplaca(String placa) {
		return veiculoRepository.find(placa);
	}

	@Transactional
	public void remove(Veiculo veiculo) {
		veiculoRepository.remove(veiculo);
	}

	public List<Veiculo> getVeiculos() {
		return veiculoRepository.findAll();
	}

}
