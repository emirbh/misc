package drr.base.trade.price.functions;

import cdm.base.math.RoundingDirectionEnum;
import cdm.base.math.functions.RoundToPrecision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceNotationEnum;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MultiplyPrice.MultiplyPriceDefault.class)
public abstract class MultiplyPrice implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected RoundToPrecision roundToPrecision;

	/**
	* @param value 
	* @param notation 
	* @return multipliedValue 
	*/
	public BigDecimal evaluate(BigDecimal value, PriceNotationEnum notation) {
		BigDecimal multipliedValue = doEvaluate(value, notation);
		
		return multipliedValue;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal value, PriceNotationEnum notation);

	public static class MultiplyPriceDefault extends MultiplyPrice {
		@Override
		protected BigDecimal doEvaluate(BigDecimal value, PriceNotationEnum notation) {
			BigDecimal multipliedValue = null;
			return assignOutput(multipliedValue, value, notation);
		}
		
		protected BigDecimal assignOutput(BigDecimal multipliedValue, BigDecimal value, PriceNotationEnum notation) {
			if (exists(MapperS.of(value)).getOrDefault(false)) {
				if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
					multipliedValue = roundToPrecision.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(value), MapperS.of(BigDecimal.valueOf(10000))).get(), 0, RoundingDirectionEnum.NEAREST, null);
				} else if (areEqual(MapperS.of(notation), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
					multipliedValue = roundToPrecision.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(value), MapperS.of(BigDecimal.valueOf(100))).get(), 10, RoundingDirectionEnum.NEAREST, null);
				} else {
					multipliedValue = roundToPrecision.evaluate(value, 13, RoundingDirectionEnum.NEAREST, null);
				}
			} else {
				multipliedValue = null;
			}
			
			return multipliedValue;
		}
	}
}
