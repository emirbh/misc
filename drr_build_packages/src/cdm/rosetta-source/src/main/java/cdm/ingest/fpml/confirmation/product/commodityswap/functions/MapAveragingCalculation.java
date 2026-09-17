package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.math.AveragingCalculationMethod;
import cdm.base.math.AveragingCalculationMethodEnum;
import cdm.product.template.AveragingCalculation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAveragingCalculation.MapAveragingCalculationDefault.class)
public abstract class MapAveragingCalculation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlAveragingMethod 
	* @return averagingCalculation 
	*/
	public AveragingCalculation evaluate(AveragingMethodEnum fpmlAveragingMethod) {
		AveragingCalculation.AveragingCalculationBuilder averagingCalculationBuilder = doEvaluate(fpmlAveragingMethod);
		
		final AveragingCalculation averagingCalculation;
		if (averagingCalculationBuilder == null) {
			averagingCalculation = null;
		} else {
			averagingCalculation = averagingCalculationBuilder.build();
			objectValidator.validate(AveragingCalculation.class, averagingCalculation);
		}
		
		return averagingCalculation;
	}

	protected abstract AveragingCalculation.AveragingCalculationBuilder doEvaluate(AveragingMethodEnum fpmlAveragingMethod);

	public static class MapAveragingCalculationDefault extends MapAveragingCalculation {
		@Override
		protected AveragingCalculation.AveragingCalculationBuilder doEvaluate(AveragingMethodEnum fpmlAveragingMethod) {
			AveragingCalculation.AveragingCalculationBuilder averagingCalculation = AveragingCalculation.builder();
			return assignOutput(averagingCalculation, fpmlAveragingMethod);
		}
		
		protected AveragingCalculation.AveragingCalculationBuilder assignOutput(AveragingCalculation.AveragingCalculationBuilder averagingCalculation, AveragingMethodEnum fpmlAveragingMethod) {
			final Boolean ifThenElseResult0;
			if (areEqual(MapperS.of(fpmlAveragingMethod), MapperS.of(AveragingMethodEnum.UNWEIGHTED), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = false;
			} else if (areEqual(MapperS.of(fpmlAveragingMethod), MapperS.of(AveragingMethodEnum.WEIGHTED), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = true;
			} else {
				ifThenElseResult0 = null;
			}
			AveragingCalculationMethodEnum ifThenElseResult1 = null;
			if (areEqual(MapperS.of(fpmlAveragingMethod), MapperS.of(AveragingMethodEnum.UNWEIGHTED), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(fpmlAveragingMethod), MapperS.of(AveragingMethodEnum.WEIGHTED), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult1 = AveragingCalculationMethodEnum.ARITHMETIC;
			}
			averagingCalculation = toBuilder(AveragingCalculation.builder()
				.setAveragingMethod(AveragingCalculationMethod.builder()
					.setIsWeighted(ifThenElseResult0)
					.setCalculationMethod(ifThenElseResult1)
					.build())
				.setPrecision(null)
				.build());
			
			return Optional.ofNullable(averagingCalculation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
