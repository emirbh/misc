package drr.regulation.hkma.rewrite.valuation.validation.datarule;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMAValuationReportDOC0011")
@ImplementedBy(HKMAValuationReportDOC0011.Default.class)
public interface HKMAValuationReportDOC0011 extends Validator<HKMAValuationReport> {
	
	String NAME = "HKMAValuationReportDOC0011";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> EROR, ActionTypeEnum -> REVI, ActionTypeEnum -> PRTO] any = actionType then reportingTimestamp <= Now";
	
	class Default implements HKMAValuationReportDOC0011 {
	
		@Inject protected Now now;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAValuationReport hKMAValuationReport) {
			ComparisonResult result = executeDataRule(hKMAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMAValuationReport hKMAValuationReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.PRTO)), MapperS.of(hKMAValuationReport).<ActionTypeEnum>map("getActionType", _hKMAValuationReport -> _hKMAValuationReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return lessThanEquals(MapperS.of(hKMAValuationReport).<ZonedDateTime>map("getReportingTimestamp", _hKMAValuationReport -> _hKMAValuationReport.getReportingTimestamp()), MapperS.of(now.evaluate()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAValuationReportDOC0011 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAValuationReport hKMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
