package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FormatToNonNegativeShortFraction5DecimalNumber.FormatToNonNegativeShortFraction5DecimalNumberDefault.class)
public abstract class FormatToNonNegativeShortFraction5DecimalNumber implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

	/**
	* @param inputNumber 
	* @return formattedNumber 
	*/
	public BigDecimal evaluate(BigDecimal inputNumber) {
		BigDecimal formattedNumber = doEvaluate(inputNumber);
		
		return formattedNumber;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal inputNumber);

	public static class FormatToNonNegativeShortFraction5DecimalNumberDefault extends FormatToNonNegativeShortFraction5DecimalNumber {
		@Override
		protected BigDecimal doEvaluate(BigDecimal inputNumber) {
			BigDecimal formattedNumber = null;
			return assignOutput(formattedNumber, inputNumber);
		}
		
		protected BigDecimal assignOutput(BigDecimal formattedNumber, BigDecimal inputNumber) {
			formattedNumber = formatToShortFraction5DecimalNumber.evaluate(inputNumber);
			
			return formattedNumber;
		}
	}
}
