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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceScheduleCount_Validation.PriceScheduleCount_ValidationDefault.class)
public abstract class PriceScheduleCount_Validation implements RosettaFunction {

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

	protected abstract MapperS<Integer> priceCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule);

	protected abstract MapperS<Integer> effectiveDateCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule);

	protected abstract MapperS<Integer> endDateCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule);

	public static class PriceScheduleCount_ValidationDefault extends PriceScheduleCount_Validation {
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
				if (exists(MapperC.<PricePeriod>of(priceSchedule).<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate())).getOrDefault(false)) {
					ifThenElseResult = areEqual(priceCount(actionType, priceSchedule), endDateCount(actionType, priceSchedule), CardinalityOperator.All);
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = areEqual(priceCount(actionType, priceSchedule), effectiveDateCount(actionType, priceSchedule), CardinalityOperator.All).andNullSafe(ifThenElseResult).get();
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<Integer> priceCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
			return MapperS.of(MapperC.<PricePeriod>of(priceSchedule).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).resultCount());
		}
		
		@Override
		protected MapperS<Integer> effectiveDateCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
			return MapperS.of(MapperC.<PricePeriod>of(priceSchedule).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).resultCount());
		}
		
		@Override
		protected MapperS<Integer> endDateCount(ActionTypeEnum actionType, List<? extends PricePeriod> priceSchedule) {
			return MapperS.of(MapperC.<PricePeriod>of(priceSchedule).<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).resultCount());
		}
	}
}
