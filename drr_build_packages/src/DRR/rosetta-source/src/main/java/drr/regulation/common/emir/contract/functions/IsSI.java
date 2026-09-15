package drr.regulation.common.emir.contract.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsSI.IsSIDefault.class)
public abstract class IsSI implements RosettaFunction {

	/**
	* @param micData 
	* @return result 
	*/
	public Boolean evaluate(MicData micData) {
		Boolean result = doEvaluate(micData);
		
		return result;
	}

	protected abstract Boolean doEvaluate(MicData micData);

	public static class IsSIDefault extends IsSI {
		@Override
		protected Boolean doEvaluate(MicData micData) {
			Boolean result = null;
			return assignOutput(result, micData);
		}
		
		protected Boolean assignOutput(Boolean result, MicData micData) {
			result = areEqual(MapperS.of(micData).<MicMarketCategoryEnum>map("getMarketCategory", _micData -> _micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.SINT), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
