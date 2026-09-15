package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ReportLevelEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Level_01_Validation.Level_01_ValidationDefault.class)
public abstract class Level_01_Validation implements RosettaFunction {

	/**
	* @param level 
	* @return result 
	*/
	public Boolean evaluate(ReportLevelEnum level) {
		Boolean result = doEvaluate(level);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportLevelEnum level);

	public static class Level_01_ValidationDefault extends Level_01_Validation {
		@Override
		protected Boolean doEvaluate(ReportLevelEnum level) {
			Boolean result = null;
			return assignOutput(result, level);
		}
		
		protected Boolean assignOutput(Boolean result, ReportLevelEnum level) {
			result = areEqual(MapperC.<ReportLevelEnum>of(MapperS.of(ReportLevelEnum.TCTN), MapperS.of(ReportLevelEnum.PSTN)), MapperS.of(level), CardinalityOperator.Any).get();
			
			return result;
		}
	}
}
