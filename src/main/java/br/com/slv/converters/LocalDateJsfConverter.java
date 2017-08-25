package br.com.slv.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dataConverter")
public class LocalDateJsfConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String valor) {
		return LocalDate.parse(valor);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object valor) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				 
		LocalDate date = (LocalDate) valor;
		return date.format(formatter);
	}

}
