package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.StringContains;
import javax.inject.Inject;


@ImplementedBy(IsCRPMetal.IsCRPMetalDefault.class)
public abstract class IsCRPMetal implements RosettaFunction {
	
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

	public static class IsCRPMetalDefault extends IsCRPMetal {
		@Override
		protected Boolean doEvaluate(String identifier) {
			Boolean result = null;
			return assignOutput(result, identifier);
		}
		
		protected Boolean assignOutput(Boolean result, String identifier) {
			result = ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "ALUMINIUM-"))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "COPPER-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "IRON ORE-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "LEAD-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "NASAAC-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "NICKEL-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "STEEL-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "TIN-")))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate(identifier, "ZINC-")))).get();
			
			return result;
		}
	}
}
