package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0078a_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0078a_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0078a_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0078a_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then (if leg2 -> notionalAmountSchedule -> value count <> leg2 -> notionalAmountSchedule -> effectiveDate count then False else True) and if [CommonAssetClass -> CRDT, CommonAssetClass -> EQUI, CommonAssetClass -> CURR, CommonAssetClass -> INTR] any = assetClass and leg2 -> notionalAmountSchedule exists then leg2 -> notionalAmountSchedule -> value all >= 0 else True";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0078a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (notEqual(MapperS.of(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), MapperS.of(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).resultCount()), CardinalityOperator.Any).getOrDefault(false)) {
						ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(false));
					} else {
						ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					final ComparisonResult ifThenElseResult1;
					if (areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.CURR), MapperS.of(CommonAssetClass.INTR)), MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()))).getOrDefault(false)) {
						ifThenElseResult1 = greaterThanEquals(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0078a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
