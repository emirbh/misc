package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.SubString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsValidLei.IsValidLeiDefault.class)
public abstract class IsValidLei implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ComputeLeiChecksum computeLeiChecksum;
	@Inject protected SubString subString;

	/**
	* @param lei 
	* @return valid 
	*/
	public Boolean evaluate(String lei) {
		Boolean valid = doEvaluate(lei);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(String lei);

	protected abstract MapperS<String> existingChecksum(String lei);

	public static class IsValidLeiDefault extends IsValidLei {
		@Override
		protected Boolean doEvaluate(String lei) {
			Boolean valid = null;
			return assignOutput(valid, lei);
		}
		
		protected Boolean assignOutput(Boolean valid, String lei) {
			valid = areEqual(existingChecksum(lei), MapperS.of(computeLeiChecksum.evaluate(subString.evaluate(lei, 1, 18))), CardinalityOperator.All).get();
			
			return valid;
		}
		
		@Override
		protected MapperS<String> existingChecksum(String lei) {
			return MapperS.of(subString.evaluate(lei, 19, 2));
		}
	}
}
