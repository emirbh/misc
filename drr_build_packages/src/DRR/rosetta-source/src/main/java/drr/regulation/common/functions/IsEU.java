package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEU.IsEUDefault.class)
public abstract class IsEU implements RosettaFunction {

	/**
	* @param countryCode 
	* @return result 
	*/
	public Boolean evaluate(String countryCode) {
		Boolean result = doEvaluate(countryCode);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String countryCode);

	public static class IsEUDefault extends IsEU {
		@Override
		protected Boolean doEvaluate(String countryCode) {
			Boolean result = null;
			return assignOutput(result, countryCode);
		}
		
		protected Boolean assignOutput(Boolean result, String countryCode) {
			if (areEqual(MapperC.<String>of(MapperS.of("BE"), MapperS.of("BG"), MapperS.of("CZ"), MapperS.of("DK"), MapperS.of("DE"), MapperS.of("EE"), MapperS.of("IE"), MapperS.of("EL"), MapperS.of("ES"), MapperS.of("FR"), MapperS.of("HR"), MapperS.of("IT"), MapperS.of("CY"), MapperS.of("LV"), MapperS.of("LT"), MapperS.of("LU"), MapperS.of("HU"), MapperS.of("MT"), MapperS.of("NL"), MapperS.of("AT"), MapperS.of("PL"), MapperS.of("PT"), MapperS.of("RO"), MapperS.of("SI"), MapperS.of("SK"), MapperS.of("FI"), MapperS.of("SE")), MapperS.of(countryCode), CardinalityOperator.Any).getOrDefault(false)) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}
	}
}
