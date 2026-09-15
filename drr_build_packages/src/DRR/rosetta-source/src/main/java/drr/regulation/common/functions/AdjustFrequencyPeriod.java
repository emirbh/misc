package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.quantity.QuantityFrequency;
import drr.standards.iso.FrequencyPeriodEnum;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(AdjustFrequencyPeriod.AdjustFrequencyPeriodDefault.class)
public abstract class AdjustFrequencyPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param period 
	* @param periodMultiplier 
	* @return periodValues 
	*/
	public QuantityFrequency evaluate(FrequencyPeriodEnum period, BigDecimal periodMultiplier) {
		QuantityFrequency.QuantityFrequencyBuilder periodValuesBuilder = doEvaluate(period, periodMultiplier);
		
		final QuantityFrequency periodValues;
		if (periodValuesBuilder == null) {
			periodValues = null;
		} else {
			periodValues = periodValuesBuilder.build();
			objectValidator.validate(QuantityFrequency.class, periodValues);
		}
		
		return periodValues;
	}

	protected abstract QuantityFrequency.QuantityFrequencyBuilder doEvaluate(FrequencyPeriodEnum period, BigDecimal periodMultiplier);

	public static class AdjustFrequencyPeriodDefault extends AdjustFrequencyPeriod {
		@Override
		protected QuantityFrequency.QuantityFrequencyBuilder doEvaluate(FrequencyPeriodEnum period, BigDecimal periodMultiplier) {
			QuantityFrequency.QuantityFrequencyBuilder periodValues = QuantityFrequency.builder();
			return assignOutput(periodValues, period, periodMultiplier);
		}
		
		protected QuantityFrequency.QuantityFrequencyBuilder assignOutput(QuantityFrequency.QuantityFrequencyBuilder periodValues, FrequencyPeriodEnum period, BigDecimal periodMultiplier) {
			final FrequencyPeriodEnum ifThenElseResult0;
			if (areEqual(MapperS.of(period), MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(periodMultiplier), MapperS.of(BigDecimal.valueOf(12)), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = FrequencyPeriodEnum.YEAR;
			} else {
				ifThenElseResult0 = period;
			}
			final Integer ifThenElseResult1;
			if (areEqual(MapperS.of(period), MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(periodMultiplier), MapperS.of(BigDecimal.valueOf(12)), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = 1;
			} else {
				ifThenElseResult1 = periodMultiplier == null ? null : periodMultiplier.intValueExact();
			}
			periodValues = toBuilder(QuantityFrequency.builder()
				.setPeriod(ifThenElseResult0)
				.setPeriodMultiplier(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(periodValues)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
