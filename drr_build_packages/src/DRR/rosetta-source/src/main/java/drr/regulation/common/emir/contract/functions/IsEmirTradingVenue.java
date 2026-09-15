package drr.regulation.common.emir.contract.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEmirTradingVenue.IsEmirTradingVenueDefault.class)
public abstract class IsEmirTradingVenue implements RosettaFunction {

	/**
	* @param micData 
	* @return result 
	*/
	public Boolean evaluate(MicData micData) {
		Boolean result = doEvaluate(micData);
		
		return result;
	}

	protected abstract Boolean doEvaluate(MicData micData);

	public static class IsEmirTradingVenueDefault extends IsEmirTradingVenue {
		@Override
		protected Boolean doEvaluate(MicData micData) {
			Boolean result = null;
			return assignOutput(result, micData);
		}
		
		protected Boolean assignOutput(Boolean result, MicData micData) {
			if (exists(MapperS.of(micData).<MicMarketCategoryEnum>map("getMarketCategory", _micData -> _micData.getMarketCategory())).getOrDefault(false)) {
				result = contains(MapperC.<MicMarketCategoryEnum>of(MapperS.of(MicMarketCategoryEnum.RMKT), MapperS.of(MicMarketCategoryEnum.MLTF), MapperS.of(MicMarketCategoryEnum.OTFS)), MapperS.of(micData).<MicMarketCategoryEnum>map("getMarketCategory", _micData -> _micData.getMarketCategory())).get();
			} else {
				result = false;
			}
			
			return result;
		}
	}
}
