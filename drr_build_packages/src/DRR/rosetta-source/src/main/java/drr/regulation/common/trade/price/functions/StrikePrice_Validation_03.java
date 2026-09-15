package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePrice_Validation_03.StrikePrice_Validation_03Default.class)
public abstract class StrikePrice_Validation_03 implements RosettaFunction {

	/**
	* @param actionType 
	* @param contractType 
	* @param strikePriceSchedule 
	* @param strikePrice 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice) {
		Boolean result = doEvaluate(actionType, contractType, strikePriceSchedule, strikePrice);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice);

	public static class StrikePrice_Validation_03Default extends StrikePrice_Validation_03 {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice) {
			if (strikePriceSchedule == null) {
				strikePriceSchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, contractType, strikePriceSchedule, strikePrice);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonContractType contractType, List<? extends PricePeriod> strikePriceSchedule, PriceFormat strikePrice) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(contractType), MapperS.of(CommonContractType.SWAP), CardinalityOperator.All)).getOrDefault(false)) {
				if (exists(MapperC.<PricePeriod>of(strikePriceSchedule).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice())).getOrDefault(false)) {
					result = exists(MapperS.of(strikePrice)).get();
				} else {
					result = null;
				}
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
