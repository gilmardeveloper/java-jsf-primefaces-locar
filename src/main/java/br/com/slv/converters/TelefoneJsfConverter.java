package br.com.slv.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.slv.models.Telefone;

@FacesConverter("telefoneConverter")
public class TelefoneJsfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String valor) {
		return ui.getAttributes().get(valor);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object valor) {
		
		Telefone telefone = (Telefone) valor;
		String id = String.valueOf(telefone.getId());
		ui.getAttributes().put(id, telefone);
		
		return id;
	}

}
