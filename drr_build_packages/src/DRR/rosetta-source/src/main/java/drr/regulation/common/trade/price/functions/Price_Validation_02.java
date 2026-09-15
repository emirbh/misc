package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Price_Validation_02.Price_Validation_02Default.class)
public abstract class Price_Validation_02 implements RosettaFunction {

	/**
	* @param actionType 
	* @param leg1 
	* @param leg2 
	* @param strikePrice 
	* @param optionPremiumAmount 
	* @param price 
	* @param priceSchedule 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonLeg leg1, CommonLeg leg2, PriceFormat strikePrice, BigDecimal optionPremiumAmount, PriceFormat price, List<? extends PricePeriod> priceSchedule) {
		Boolean result = doEvaluate(actionType, leg1, leg2, strikePrice, optionPremiumAmount, price, priceSchedule);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg leg1, CommonLeg leg2, PriceFormat strikePrice, BigDecimal optionPremiumAmount, PriceFormat price, List<? extends PricePeriod> priceSchedule);

	public static class Price_Validation_02Default extends Price_Validation_02 {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg leg1, CommonLeg leg2, PriceFormat strikePrice, BigDecimal optionPremiumAmount, PriceFormat price, List<? extends PricePeriod> priceSchedule) {
			if (priceSchedule == null) {
				priceSchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, leg1, leg2, strikePrice, optionPremiumAmount, price, priceSchedule);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonLeg leg1, CommonLeg leg2, PriceFormat strikePrice, BigDecimal optionPremiumAmount, PriceFormat price, List<? extends PricePeriod> priceSchedule) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult0;
				if (notExists(MapperS.of(leg1).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).andNullSafe(notExists(MapperS.of(leg2).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()))).andNullSafe(notExists(MapperS.of(leg1).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()))).andNullSafe(notExists(MapperS.of(leg2).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()))).andNullSafe(notExists(MapperS.of(strikePrice))).andNullSafe(notExists(MapperS.of(optionPremiumAmount))).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(price));
				} else {
					ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				final ComparisonResult ifThenElseResult1;
				if (exists(MapperC.<PricePeriod>of(priceSchedule).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice())).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(price));
				} else {
					ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = ifThenElseResult0.andNullSafe(ifThenElseResult1).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
