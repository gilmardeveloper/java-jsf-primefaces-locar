package br.com.slv.converters;

import java.math.BigDecimal;

public class ValorConverter {

	public BigDecimal toMoney(String valor) {

//		MonetaryAmountFormat format = MonetaryFormats
//				.getAmountFormat(AmountFormatQueryBuilder.of(Locale.getDefault()).set(CurrencyStyle.SYMBOL).build());
//		double doubleValueExact = format.parse(valor).getNumber().doubleValueExact();
//		MonetaryAmount amount = Monetary.getDefaultAmountFactory().setCurrency("BRL").setNumber(doubleValueExact)
//				.create();

		return new BigDecimal(valor);

	}

	public BigDecimal toMoney(Double valor) {
		return new BigDecimal(valor);
	}

	public String toString(BigDecimal money) {
		return money.toString();
	}

	public Double toDouble(BigDecimal money) {
		return money.doubleValue();
	}

}
