package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.standards.iso.ActionTypeEnum;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceScheduleEffectiveDate_Validation.PriceScheduleEffectiveDate_ValidationDefault.class)
public abstract class PriceScheduleEffectiveDate_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PriceScheduleCount_Validation priceScheduleCount_Validation;

	/**
	* @param actionType 
	* @param priceSchedule 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
		Boolean result = doEvaluate(actionType, priceSchedule);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule);

	public static class PriceScheduleEffectiveDate_ValidationDefault extends PriceScheduleEffectiveDate_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
			if (priceSchedule == null) {
				priceSchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, priceSchedule);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (exists(MapperC.<PricePeriod>of(priceSchedule).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice())).getOrDefault(false)) {
					ifThenElseResult = exists(MapperC.<PricePeriod>of(priceSchedule).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = ifThenElseResult.andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(priceScheduleCount_Validation.evaluate(actionType, priceSchedule)))).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
