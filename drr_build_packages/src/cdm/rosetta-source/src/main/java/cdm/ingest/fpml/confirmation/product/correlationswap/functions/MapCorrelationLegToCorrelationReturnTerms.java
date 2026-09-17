package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.math.NumberBound;
import cdm.base.math.NumberRange;
import cdm.observable.asset.DividendApplicability;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.asset.CorrelationReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.eq.shared.BoundedCorrelation;
import fpml.consolidated.eq.shared.Correlation;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationLegToCorrelationReturnTerms.MapCorrelationLegToCorrelationReturnTermsDefault.class)
public abstract class MapCorrelationLegToCorrelationReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCorrelationLeg 
	* @return correlationReturnTerms 
	*/
	public CorrelationReturnTerms evaluate(CorrelationLeg fpmlCorrelationLeg) {
		CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTermsBuilder = doEvaluate(fpmlCorrelationLeg);
		
		final CorrelationReturnTerms correlationReturnTerms;
		if (correlationReturnTermsBuilder == null) {
			correlationReturnTerms = null;
		} else {
			correlationReturnTerms = correlationReturnTermsBuilder.build();
			objectValidator.validate(CorrelationReturnTerms.class, correlationReturnTerms);
		}
		
		return correlationReturnTerms;
	}

	protected abstract CorrelationReturnTerms.CorrelationReturnTermsBuilder doEvaluate(CorrelationLeg fpmlCorrelationLeg);

	protected abstract MapperS<? extends CorrelationAmount> fpmlAmount(CorrelationLeg fpmlCorrelationLeg);

	public static class MapCorrelationLegToCorrelationReturnTermsDefault extends MapCorrelationLegToCorrelationReturnTerms {
		@Override
		protected CorrelationReturnTerms.CorrelationReturnTermsBuilder doEvaluate(CorrelationLeg fpmlCorrelationLeg) {
			CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTerms = CorrelationReturnTerms.builder();
			return assignOutput(correlationReturnTerms, fpmlCorrelationLeg);
		}
		
		protected CorrelationReturnTerms.CorrelationReturnTermsBuilder assignOutput(CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTerms, CorrelationLeg fpmlCorrelationLeg) {
			correlationReturnTerms = toBuilder(CorrelationReturnTerms.builder()
				.setDividendApplicability(DividendApplicability.builder()
					.setAllDividends(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Boolean>map("getAllDividends", correlationAmount -> correlationAmount.getAllDividends()).get())
					.build())
				.setExpectedN(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<Integer>map("getExpectedN", correlation -> correlation.getExpectedN()).get())
				.setValuationTerms(null)
				.setCorrelationStrikePrice(Price.builder()
					.setValue(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<BigDecimal>map("getCorrelationStrikePrice", correlation -> correlation.getCorrelationStrikePrice()).get())
					.setPriceType(PriceTypeEnum.CORRELATION)
					.build())
				.setBoundedCorrelation(NumberRange.builder()
					.setLowerBound(NumberBound.builder()
						.setNumber(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<BoundedCorrelation>map("getBoundedCorrelation", correlation -> correlation.getBoundedCorrelation()).<BigDecimal>map("getMinimumBoundaryPercent", boundedCorrelation -> boundedCorrelation.getMinimumBoundaryPercent()).get())
						.setInclusive(null)
						.build())
					.setUpperBound(NumberBound.builder()
						.setNumber(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<BoundedCorrelation>map("getBoundedCorrelation", correlation -> correlation.getBoundedCorrelation()).<BigDecimal>map("getMaximumBoundaryPercent", boundedCorrelation -> boundedCorrelation.getMaximumBoundaryPercent()).get())
						.setInclusive(null)
						.build())
					.build())
				.setNumberOfDataSeries(MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<Integer>map("getNumberOfDataSeries", correlation -> correlation.getNumberOfDataSeries()).get())
				.build());
			
			return Optional.ofNullable(correlationReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CorrelationAmount> fpmlAmount(CorrelationLeg fpmlCorrelationLeg) {
			return MapperS.of(fpmlCorrelationLeg).<CorrelationAmount>map("getAmount", correlationLeg -> correlationLeg.getAmount());
		}
	}
}
