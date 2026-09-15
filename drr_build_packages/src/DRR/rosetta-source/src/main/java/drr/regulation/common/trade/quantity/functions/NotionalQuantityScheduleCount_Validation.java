package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityScheduleCount_Validation.NotionalQuantityScheduleCount_ValidationDefault.class)
public abstract class NotionalQuantityScheduleCount_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalQuantitySchedule 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
		Boolean result = doEvaluate(actionType, assetClass, notionalQuantitySchedule);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule);

	protected abstract MapperS<Integer> valueCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule);

	protected abstract MapperS<Integer> effectiveDateCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule);

	protected abstract MapperS<Integer> endDateCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule);

	public static class NotionalQuantityScheduleCount_ValidationDefault extends NotionalQuantityScheduleCount_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			if (notionalQuantitySchedule == null) {
				notionalQuantitySchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalQuantitySchedule);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (exists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())).getOrDefault(false)) {
					ifThenElseResult = areEqual(valueCount(actionType, assetClass, notionalQuantitySchedule), endDateCount(actionType, assetClass, notionalQuantitySchedule), CardinalityOperator.All);
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = areEqual(valueCount(actionType, assetClass, notionalQuantitySchedule), effectiveDateCount(actionType, assetClass, notionalQuantitySchedule), CardinalityOperator.All).andNullSafe(ifThenElseResult).get();
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<Integer> valueCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			return MapperS.of(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount());
		}
		
		@Override
		protected MapperS<Integer> effectiveDateCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			return MapperS.of(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).resultCount());
		}
		
		@Override
		protected MapperS<Integer> endDateCount(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			return MapperS.of(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).resultCount());
		}
	}
}
