package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationMethod_03_Validation.ValuationMethod_03_ValidationDefault.class)
public abstract class ValuationMethod_03_Validation implements RosettaFunction {

	/**
	* @param valuationAmount 
	* @param valuationMethod 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal valuationAmount, ValuationType1Code valuationMethod) {
		Boolean result = doEvaluate(valuationAmount, valuationMethod);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal valuationAmount, ValuationType1Code valuationMethod);

	public static class ValuationMethod_03_ValidationDefault extends ValuationMethod_03_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ValuationType1Code valuationMethod) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationMethod);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ValuationType1Code valuationMethod) {
			if (notExists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = notExists(MapperS.of(valuationMethod)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
