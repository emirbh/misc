package drr.regulation.jfsa.rewrite.trade.validation.datarule;

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
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0094_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0094_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0094_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0094_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then (if leg1 -> notionalAmountSchedule -> value count <> leg1 -> notionalAmountSchedule -> effectiveDate count then False else if leg1 -> notionalAmountSchedule -> value any < 0 then False)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0094_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg1", _jFSATransactionReport -> _jFSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg1", _jFSATransactionReport -> _jFSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).resultCount()), CardinalityOperator.Any).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
					}
					if (lessThan(MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg1", _jFSATransactionReport -> _jFSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.Any).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
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
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0094_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
