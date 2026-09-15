package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrencyReference;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.product.asset.DividendCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendCurrency.MapDividendCurrencyDefault.class)
public abstract class MapDividendCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapCurrencyReference mapCurrencyReference;

	/**
	* @param fpmlCurrency 
	* @param fpmlDeterminationMethod 
	* @param fpmlCurrencyReference 
	* @return dividendCurrency 
	*/
	public DividendCurrency evaluate(IdentifiedCurrency fpmlCurrency, DeterminationMethod fpmlDeterminationMethod, IdentifiedCurrencyReference fpmlCurrencyReference) {
		DividendCurrency.DividendCurrencyBuilder dividendCurrencyBuilder = doEvaluate(fpmlCurrency, fpmlDeterminationMethod, fpmlCurrencyReference);
		
		final DividendCurrency dividendCurrency;
		if (dividendCurrencyBuilder == null) {
			dividendCurrency = null;
		} else {
			dividendCurrency = dividendCurrencyBuilder.build();
			objectValidator.validate(DividendCurrency.class, dividendCurrency);
		}
		
		return dividendCurrency;
	}

	protected abstract DividendCurrency.DividendCurrencyBuilder doEvaluate(IdentifiedCurrency fpmlCurrency, DeterminationMethod fpmlDeterminationMethod, IdentifiedCurrencyReference fpmlCurrencyReference);

	public static class MapDividendCurrencyDefault extends MapDividendCurrency {
		@Override
		protected DividendCurrency.DividendCurrencyBuilder doEvaluate(IdentifiedCurrency fpmlCurrency, DeterminationMethod fpmlDeterminationMethod, IdentifiedCurrencyReference fpmlCurrencyReference) {
			DividendCurrency.DividendCurrencyBuilder dividendCurrency = DividendCurrency.builder();
			return assignOutput(dividendCurrency, fpmlCurrency, fpmlDeterminationMethod, fpmlCurrencyReference);
		}
		
		protected DividendCurrency.DividendCurrencyBuilder assignOutput(DividendCurrency.DividendCurrencyBuilder dividendCurrency, IdentifiedCurrency fpmlCurrency, DeterminationMethod fpmlDeterminationMethod, IdentifiedCurrencyReference fpmlCurrencyReference) {
			dividendCurrency = toBuilder(DividendCurrency.builder()
				.setCurrency(mapCurrency.evaluate(fpmlCurrency))
				.setDeterminationMethod(MapperS.of(fpmlDeterminationMethod).<String>map("getValue", determinationMethod -> determinationMethod.getValue()).checkedMap("to-enum", DeterminationMethodEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setCurrencyReference(mapCurrencyReference.evaluate(fpmlCurrencyReference))
				.build());
			
			return Optional.ofNullable(dividendCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
