package drr.base.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceNotationEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DefaultBasisToPercentage.DefaultBasisToPercentageDefault.class)
public abstract class DefaultBasisToPercentage implements RosettaFunction {

	/**
	* @param value 
	* @param forceDefault 
	* @return result 
	*/
	public PriceNotationEnum evaluate(PriceNotationEnum value, Boolean forceDefault) {
		PriceNotationEnum result = doEvaluate(value, forceDefault);
		
		return result;
	}

	protected abstract PriceNotationEnum doEvaluate(PriceNotationEnum value, Boolean forceDefault);

	public static class DefaultBasisToPercentageDefault extends DefaultBasisToPercentage {
		@Override
		protected PriceNotationEnum doEvaluate(PriceNotationEnum value, Boolean forceDefault) {
			PriceNotationEnum result = null;
			return assignOutput(result, value, forceDefault);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum result, PriceNotationEnum value, Boolean forceDefault) {
			if (areEqual(MapperS.of(value), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(value), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(forceDefault), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
				result = PriceNotationEnum.PERCENTAGE;
			} else {
				result = value;
			}
			
			return result;
		}
	}
}
