package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.FloatingRateIndex;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapInitialRate.MapInitialRateDefault.class)
public abstract class MapInitialRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlInitialRate 
	* @param fpmlFloatingRateIndex 
	* @return initialRate 
	*/
	public Price evaluate(BigDecimal fpmlInitialRate, FloatingRateIndex fpmlFloatingRateIndex) {
		Price.PriceBuilder initialRateBuilder = doEvaluate(fpmlInitialRate, fpmlFloatingRateIndex);
		
		final Price initialRate;
		if (initialRateBuilder == null) {
			initialRate = null;
		} else {
			initialRate = initialRateBuilder.build();
			objectValidator.validate(Price.class, initialRate);
		}
		
		return initialRate;
	}

	protected abstract Price.PriceBuilder doEvaluate(BigDecimal fpmlInitialRate, FloatingRateIndex fpmlFloatingRateIndex);

	public static class MapInitialRateDefault extends MapInitialRate {
		@Override
		protected Price.PriceBuilder doEvaluate(BigDecimal fpmlInitialRate, FloatingRateIndex fpmlFloatingRateIndex) {
			Price.PriceBuilder initialRate = Price.builder();
			return assignOutput(initialRate, fpmlInitialRate, fpmlFloatingRateIndex);
		}
		
		protected Price.PriceBuilder assignOutput(Price.PriceBuilder initialRate, BigDecimal fpmlInitialRate, FloatingRateIndex fpmlFloatingRateIndex) {
			if (exists(MapperS.of(fpmlInitialRate)).getOrDefault(false)) {
				PriceTypeEnum ifThenElseResult = null;
				if (exists(MapperS.of(fpmlFloatingRateIndex)).getOrDefault(false)) {
					ifThenElseResult = PriceTypeEnum.INTEREST_RATE;
				}
				initialRate = toBuilder(Price.builder()
					.setValue(fpmlInitialRate)
					.setUnit(null)
					.setPerUnitOf(null)
					.setPriceType(ifThenElseResult)
					.build());
			} else {
				initialRate = null;
			}
			
			return Optional.ofNullable(initialRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
