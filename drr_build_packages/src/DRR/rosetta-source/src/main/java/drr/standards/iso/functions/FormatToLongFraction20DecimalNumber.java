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
import java.math.BigInteger;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FormatToLongFraction20DecimalNumber.FormatToLongFraction20DecimalNumberDefault.class)
public abstract class FormatToLongFraction20DecimalNumber implements RosettaFunction {
	
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

	public static class FormatToLongFraction20DecimalNumberDefault extends FormatToLongFraction20DecimalNumber {
		@Override
		protected BigDecimal doEvaluate(BigDecimal inputNumber) {
			BigDecimal formattedNumber = null;
			return assignOutput(formattedNumber, inputNumber);
		}
		
		protected BigDecimal assignOutput(BigDecimal formattedNumber, BigDecimal inputNumber) {
			final BigInteger bigInteger = new BigInteger("99999999999999999999");
			if (lessThanEquals(MapperS.of(abs.evaluate(inputNumber)), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All).getOrDefault(false)) {
				final MapperS<BigDecimal> thenArg = MapperS.of(roundToPrecision.evaluate(inputNumber, 19, RoundingDirectionEnum.NEAREST, true));
				formattedNumber = MapperS.of(roundToSignificantFigures.evaluate(thenArg.get(), 20, RoundingDirectionEnum.NEAREST)).get();
			} else {
				formattedNumber = inputNumber;
			}
			
			return formattedNumber;
		}
	}
}
