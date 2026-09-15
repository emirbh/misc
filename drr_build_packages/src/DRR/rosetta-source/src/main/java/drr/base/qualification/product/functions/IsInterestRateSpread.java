package drr.base.qualification.product.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsInterestRateSpread.IsInterestRateSpreadDefault.class)
public abstract class IsInterestRateSpread implements RosettaFunction {

	/**
	* @param price 
	* @return result 
	*/
	public Boolean evaluate(PriceSchedule price) {
		Boolean result = doEvaluate(price);
		
		return result;
	}

	protected abstract Boolean doEvaluate(PriceSchedule price);

	public static class IsInterestRateSpreadDefault extends IsInterestRateSpread {
		@Override
		protected Boolean doEvaluate(PriceSchedule price) {
			Boolean result = null;
			return assignOutput(result, price);
		}
		
		protected Boolean assignOutput(Boolean result, PriceSchedule price) {
			result = areEqual(MapperS.of(price).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(price).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.ADD), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
