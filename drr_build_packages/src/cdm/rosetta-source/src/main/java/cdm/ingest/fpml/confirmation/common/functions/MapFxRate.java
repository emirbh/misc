package cdm.ingest.fpml.confirmation.common.functions;

import cdm.observable.asset.FxRate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxRate.MapFxRateDefault.class)
public abstract class MapFxRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;

	/**
	* @param fpmlFxRate 
	* @return fxRate 
	*/
	public FxRate evaluate(fpml.consolidated.shared.FxRate fpmlFxRate) {
		FxRate.FxRateBuilder fxRateBuilder = doEvaluate(fpmlFxRate);
		
		final FxRate fxRate;
		if (fxRateBuilder == null) {
			fxRate = null;
		} else {
			fxRate = fxRateBuilder.build();
			objectValidator.validate(FxRate.class, fxRate);
		}
		
		return fxRate;
	}

	protected abstract FxRate.FxRateBuilder doEvaluate(fpml.consolidated.shared.FxRate fpmlFxRate);

	public static class MapFxRateDefault extends MapFxRate {
		@Override
		protected FxRate.FxRateBuilder doEvaluate(fpml.consolidated.shared.FxRate fpmlFxRate) {
			FxRate.FxRateBuilder fxRate = FxRate.builder();
			return assignOutput(fxRate, fpmlFxRate);
		}
		
		protected FxRate.FxRateBuilder assignOutput(FxRate.FxRateBuilder fxRate, fpml.consolidated.shared.FxRate fpmlFxRate) {
			fxRate = toBuilder(FxRate.builder()
				.setQuotedCurrencyPair(mapQuotedCurrencyPair.evaluate(MapperS.of(fpmlFxRate).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _fxRate -> _fxRate.getQuotedCurrencyPair()).get()))
				.setRate(MapperS.of(fpmlFxRate).<BigDecimal>map("getRate", _fxRate -> _fxRate.getRate()).get())
				.build());
			
			return Optional.ofNullable(fxRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
