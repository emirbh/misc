package cdm.product.common.settlement.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.UnitType;
import cdm.base.math.functions.UnitEquals;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceUnitEquals.PriceUnitEqualsDefault.class)
public abstract class PriceUnitEquals implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected UnitEquals unitEquals;

	/**
	* @param p1 
	* @param p2 
	* @return result 
	*/
	public Boolean evaluate(PriceSchedule p1, PriceSchedule p2) {
		Boolean result = doEvaluate(p1, p2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(PriceSchedule p1, PriceSchedule p2);

	protected abstract MapperS<Boolean> unitMatches(PriceSchedule p1, PriceSchedule p2);

	protected abstract MapperS<Boolean> perUnitOfMatches(PriceSchedule p1, PriceSchedule p2);

	protected abstract MapperS<Boolean> priceTypeMatches(PriceSchedule p1, PriceSchedule p2);

	protected abstract MapperS<Boolean> priceExpressionMatches(PriceSchedule p1, PriceSchedule p2);

	protected abstract MapperS<Boolean> arithmeticOperatorMatches(PriceSchedule p1, PriceSchedule p2);

	public static class PriceUnitEqualsDefault extends PriceUnitEquals {
		@Override
		protected Boolean doEvaluate(PriceSchedule p1, PriceSchedule p2) {
			Boolean result = null;
			return assignOutput(result, p1, p2);
		}
		
		protected Boolean assignOutput(Boolean result, PriceSchedule p1, PriceSchedule p2) {
			result = ComparisonResult.ofNullSafe(unitMatches(p1, p2)).andNullSafe(ComparisonResult.ofNullSafe(perUnitOfMatches(p1, p2))).andNullSafe(ComparisonResult.ofNullSafe(priceTypeMatches(p1, p2))).andNullSafe(ComparisonResult.ofNullSafe(priceExpressionMatches(p1, p2))).andNullSafe(ComparisonResult.ofNullSafe(arithmeticOperatorMatches(p1, p2))).get();
			
			return result;
		}
		
		@Override
		protected MapperS<Boolean> unitMatches(PriceSchedule p1, PriceSchedule p2) {
			return MapperS.of(unitEquals.evaluate(MapperS.of(p1).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get(), MapperS.of(p2).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get()));
		}
		
		@Override
		protected MapperS<Boolean> perUnitOfMatches(PriceSchedule p1, PriceSchedule p2) {
			return MapperS.of(unitEquals.evaluate(MapperS.of(p1).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).get(), MapperS.of(p2).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).get()));
		}
		
		@Override
		protected MapperS<Boolean> priceTypeMatches(PriceSchedule p1, PriceSchedule p2) {
			return notExists(MapperS.of(p1).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType())).andNullSafe(notExists(MapperS.of(p2).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()))).orNullSafe(areEqual(MapperS.of(p1).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(p2).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), CardinalityOperator.All)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> priceExpressionMatches(PriceSchedule p1, PriceSchedule p2) {
			return notExists(MapperS.of(p1).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression())).andNullSafe(notExists(MapperS.of(p2).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()))).orNullSafe(areEqual(MapperS.of(p1).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), MapperS.of(p2).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()), CardinalityOperator.All)).asMapper();
		}
		
		@Override
		protected MapperS<Boolean> arithmeticOperatorMatches(PriceSchedule p1, PriceSchedule p2) {
			return notExists(MapperS.of(p1).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator())).andNullSafe(notExists(MapperS.of(p2).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).orNullSafe(areEqual(MapperS.of(p1).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()), MapperS.of(p2).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()), CardinalityOperator.All)).asMapper();
		}
	}
}
