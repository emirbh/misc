package drr.standards.iso.functions;

import cdm.base.math.RoundingDirectionEnum;
import cdm.base.math.functions.Abs;
import cdm.base.math.functions.RoundToPrecision;
import cdm.base.math.functions.RoundToSignificantFigures;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FormatToMax5Number.FormatToMax5NumberDefault.class)
public abstract class FormatToMax5Number implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected RoundToPrecision roundToPrecision;
	@Inject protected RoundToSignificantFigures roundToSignificantFigures;

	/**
	* @param inputNumber 
	* @return formattedNumber 
	*/
	public BigDecimal evaluate(BigDecimal inputNumber) {
		BigDecimal formattedNumber = doEvaluate(inputNumber);
		
		return formattedNumber;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal inputNumber);

	public static class FormatToMax5NumberDefault extends FormatToMax5Number {
		@Override
		protected BigDecimal doEvaluate(BigDecimal inputNumber) {
			BigDecimal formattedNumber = null;
			return assignOutput(formattedNumber, inputNumber);
		}
		
		protected BigDecimal assignOutput(BigDecimal formattedNumber, BigDecimal inputNumber) {
			if (lessThanEquals(MapperS.of(abs.evaluate(inputNumber)), MapperS.of(BigDecimal.valueOf(99999)), CardinalityOperator.All).getOrDefault(false)) {
				final MapperS<BigDecimal> thenArg = MapperS.of(roundToPrecision.evaluate(inputNumber, 0, RoundingDirectionEnum.NEAREST, true));
				formattedNumber = MapperS.of(roundToSignificantFigures.evaluate(thenArg.get(), 5, RoundingDirectionEnum.NEAREST)).get();
			} else {
				formattedNumber = inputNumber;
			}
			
			return formattedNumber;
		}
	}
}
