package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.StringContains;
import javax.inject.Inject;


@ImplementedBy(IsCRPBullion.IsCRPBullionDefault.class)
public abstract class IsCRPBullion implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param identifier 
	* @return result 
	*/
	public Boolean evaluate(String identifier) {
		Boolean result = doEvaluate(identifier);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String identifier);

	public static class IsCRPBullionDefault extends IsCRPBullion {
		@Override
		protected Boolean doEvaluate(String identifier) {
			Boolean result = null;
			return assignOutput(result, identifier);
		}
		
		protected Boolean assignOutput(Boolean result, String identifier) {
			result = ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "GOLD-"))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "PALLADIUM-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "PLATINUM-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "SILVER-")))).get();
			
			return result;
		}
	}
}
