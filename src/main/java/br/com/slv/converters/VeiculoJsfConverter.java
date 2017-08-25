package br.com.slv.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.slv.models.Locacao;

@FacesConverter("locacaoConverter")
public class VeiculoJsfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String valor) {
		return ui.getAttributes().get(valor);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object valor) {

		Locacao locacao = (Locacao) valor;
		String id = String.valueOf(locacao.getId());
		ui.getAttributes().put(id, locacao);

		return id;
	}

}
