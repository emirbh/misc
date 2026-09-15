package cdm.ingest.fpml.confirmation.common.functions;

import cdm.observable.asset.QuotedCurrencyPair;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.shared.Currency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuotedCurrencyPair.MapQuotedCurrencyPairDefault.class)
public abstract class MapQuotedCurrencyPair implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlQuotedCurrencyPair 
	* @return quotedCurrencyPair 
	*/
	public QuotedCurrencyPair evaluate(fpml.consolidated.shared.QuotedCurrencyPair fpmlQuotedCurrencyPair) {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPairBuilder = doEvaluate(fpmlQuotedCurrencyPair);
		
		final QuotedCurrencyPair quotedCurrencyPair;
		if (quotedCurrencyPairBuilder == null) {
			quotedCurrencyPair = null;
		} else {
			quotedCurrencyPair = quotedCurrencyPairBuilder.build();
			objectValidator.validate(QuotedCurrencyPair.class, quotedCurrencyPair);
		}
		
		return quotedCurrencyPair;
	}

	protected abstract QuotedCurrencyPair.QuotedCurrencyPairBuilder doEvaluate(fpml.consolidated.shared.QuotedCurrencyPair fpmlQuotedCurrencyPair);

	public static class MapQuotedCurrencyPairDefault extends MapQuotedCurrencyPair {
		@Override
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder doEvaluate(fpml.consolidated.shared.QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair = QuotedCurrencyPair.builder();
			return assignOutput(quotedCurrencyPair, fpmlQuotedCurrencyPair);
		}
		
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder assignOutput(QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair, fpml.consolidated.shared.QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			quotedCurrencyPair = toBuilder(QuotedCurrencyPair.builder()
				.setCurrency1(mapCurrency.evaluate(MapperS.of(fpmlQuotedCurrencyPair).<Currency>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1()).get()))
				.setCurrency2(mapCurrency.evaluate(MapperS.of(fpmlQuotedCurrencyPair).<Currency>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2()).get()))
				.setQuoteBasis(MapperS.of(fpmlQuotedCurrencyPair).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()).checkedMap("to-enum", e -> cdm.observable.asset.QuoteBasisEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(quotedCurrencyPair)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
