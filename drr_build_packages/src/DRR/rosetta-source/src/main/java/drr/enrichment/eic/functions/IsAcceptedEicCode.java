package drr.enrichment.eic.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsAcceptedEicCode.IsAcceptedEicCodeDefault.class)
public abstract class IsAcceptedEicCode implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetAcceptedEicCodes getAcceptedEicCodes;

	/**
	* @param eicCode 
	* @return result 
	*/
	public Boolean evaluate(List<String> eicCode) {
		Boolean result = doEvaluate(eicCode);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<String> eicCode);

	public static class IsAcceptedEicCodeDefault extends IsAcceptedEicCode {
		@Override
		protected Boolean doEvaluate(List<String> eicCode) {
			if (eicCode == null) {
				eicCode = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, eicCode);
		}
		
		protected Boolean assignOutput(Boolean result, List<String> eicCode) {
			if (exists(MapperC.<String>of(eicCode)).getOrDefault(false)) {
				final MapperC<String> thenArg0 = MapperC.<String>of(eicCode);
				final MapperC<Boolean> thenArg1 = thenArg0
					.mapItem(ec -> contains(MapperC.<String>of(getAcceptedEicCodes.evaluate()), ec).asMapper());
				result = areEqual(thenArg1, MapperS.of(true), CardinalityOperator.All).asMapper().get();
			} else {
				result = false;
			}
			
			return result;
		}
	}
}
