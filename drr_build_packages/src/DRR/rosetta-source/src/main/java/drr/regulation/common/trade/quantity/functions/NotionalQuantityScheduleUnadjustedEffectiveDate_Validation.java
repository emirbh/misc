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
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityScheduleUnadjustedEffectiveDate_Validation.NotionalQuantityScheduleUnadjustedEffectiveDate_ValidationDefault.class)
public abstract class NotionalQuantityScheduleUnadjustedEffectiveDate_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotionalQuantityScheduleCount_Validation notionalQuantityScheduleCount_Validation;

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

	public static class NotionalQuantityScheduleUnadjustedEffectiveDate_ValidationDefault extends NotionalQuantityScheduleUnadjustedEffectiveDate_Validation {
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
				if (exists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue())).getOrDefault(false)) {
					ifThenElseResult = exists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = ifThenElseResult.andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(notionalQuantityScheduleCount_Validation.evaluate(actionType, assetClass, notionalQuantitySchedule)))).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
