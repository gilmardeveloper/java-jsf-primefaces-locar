package br.com.slv.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.money.MonetaryAmount;

@FacesConverter("valorConverter")
public class ValorJsfConverter implements Converter {

	private ValorConverter converter;

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String valor) {
		converter = new ValorConverter();
		return converter.toMoney(valor);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object money) {
		converter = new ValorConverter();
		return converter.toString((MonetaryAmount) money);
	}

}
