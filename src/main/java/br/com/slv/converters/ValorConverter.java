package br.com.slv.converters;

import java.util.Locale;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.format.CurrencyStyle;

public class ValorConverter {

	public MonetaryAmount toMoney(String valor) {

		MonetaryAmountFormat format = MonetaryFormats
				.getAmountFormat(AmountFormatQueryBuilder.of(Locale.getDefault()).set(CurrencyStyle.SYMBOL).build());
		double doubleValueExact = format.parse(valor).getNumber().doubleValueExact();
		MonetaryAmount amount = Monetary.getDefaultAmountFactory().setCurrency("BRL").setNumber(doubleValueExact)
				.create();

		return amount;

	}

	public MonetaryAmount toMoney(Double valor) {
		return Monetary.getDefaultAmountFactory().setCurrency("BRL").setNumber(valor).create();
	}

	public String toString(MonetaryAmount money) {
		MonetaryAmountFormat format = MonetaryFormats
				.getAmountFormat(AmountFormatQueryBuilder.of(Locale.getDefault()).set(CurrencyStyle.SYMBOL).build());
		return format.format(money);
	}

	public Double toDouble(MonetaryAmount money) {
		return money.getNumber().doubleValueExact();
	}

}
