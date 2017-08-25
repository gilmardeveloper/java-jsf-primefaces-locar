package br.com.slv.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.slv.models.Veiculo;

@FacesConverter("veiculoConverter")
public class LocacaoJsfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String valor) {
		return ui.getAttributes().get(valor);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object valor) {
		
		Veiculo veiculo = (Veiculo) valor;
		String id = String.valueOf(veiculo.getId());
		ui.getAttributes().put(id, veiculo);
		
		return id;
	}

}
