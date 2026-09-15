package drr.regulation.hkma.rewrite.trade.validation.datarule;

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
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMATransactionReportDOC0068")
@ImplementedBy(HKMATransactionReportDOC0068.Default.class)
public interface HKMATransactionReportDOC0068 extends Validator<HKMATransactionReport> {
	
	String NAME = "HKMATransactionReportDOC0068";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if leg1 -> notionalAmountSchedule -> endDate exists then leg1 -> notionalAmountSchedule -> endDate count = leg1 -> notionalAmountSchedule -> value count";
	
	class Default implements HKMATransactionReportDOC0068 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			ComparisonResult result = executeDataRule(hKMATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMATransactionReport hKMATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(hKMATransactionReport).<ActionTypeEnum>map("getActionType", _hKMATransactionReport -> _hKMATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())).getOrDefault(false)) {
						return areEqual(MapperS.of(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).resultCount()), MapperS.of(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), CardinalityOperator.All);
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMATransactionReportDOC0068 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			return Collections.emptyList();
		}
	}
}
