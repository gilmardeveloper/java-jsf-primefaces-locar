package br.com.slv.converters;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ValorPersistenceConverter implements AttributeConverter<MonetaryAmount, Double> {

	@Override
	public Double convertToDatabaseColumn(MonetaryAmount preco) {
		return preco.getNumber().doubleValueExact();
	}

	@Override
	public MonetaryAmount convertToEntityAttribute(Double preco) {
		return Monetary.getDefaultAmountFactory().setCurrency("BRL").setNumber(preco).create();

	}

}
