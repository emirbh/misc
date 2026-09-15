package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.shared.Currency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCurrency.MapCurrencyDefault.class)
public abstract class MapCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlCurrency 
	* @return currencyWithScheme 
	*/
	public FieldWithMetaString evaluate(Currency fpmlCurrency) {
		FieldWithMetaString.FieldWithMetaStringBuilder currencyWithSchemeBuilder = doEvaluate(fpmlCurrency);
		
		final FieldWithMetaString currencyWithScheme;
		if (currencyWithSchemeBuilder == null) {
			currencyWithScheme = null;
		} else {
			currencyWithScheme = currencyWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaString.class, currencyWithScheme);
		}
		
		return currencyWithScheme;
	}

	protected abstract FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(Currency fpmlCurrency);

	public static class MapCurrencyDefault extends MapCurrency {
		@Override
		protected FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(Currency fpmlCurrency) {
			FieldWithMetaString.FieldWithMetaStringBuilder currencyWithScheme = FieldWithMetaString.builder();
			return assignOutput(currencyWithScheme, fpmlCurrency);
		}
		
		protected FieldWithMetaString.FieldWithMetaStringBuilder assignOutput(FieldWithMetaString.FieldWithMetaStringBuilder currencyWithScheme, Currency fpmlCurrency) {
			currencyWithScheme = toBuilder(mapStringWithScheme.evaluate(MapperS.of(fpmlCurrency).<String>map("getValue", currency -> currency.getValue()).get(), MapperS.of(fpmlCurrency).<String>map("getCurrencyScheme", currency -> currency.getCurrencyScheme()).get()));
			
			return Optional.ofNullable(currencyWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
