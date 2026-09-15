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
@RosettaDataRule("HKMAValuationReportDOC0039")
@ImplementedBy(HKMAValuationReportDOC0039.Default.class)
public interface HKMAValuationReportDOC0039 extends Validator<HKMAValuationReport> {
	
	String NAME = "HKMAValuationReportDOC0039";
	String DEFINITION = "if [ActionTypeEnum -> VALU] any = actionType then valuationTimestamp <= Now";
	
	class Default implements HKMAValuationReportDOC0039 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.VALU)), MapperS.of(hKMAValuationReport).<ActionTypeEnum>map("getActionType", _hKMAValuationReport -> _hKMAValuationReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return lessThanEquals(MapperS.of(hKMAValuationReport).<ZonedDateTime>map("getValuationTimestamp", _hKMAValuationReport -> _hKMAValuationReport.getValuationTimestamp()), MapperS.of(now.evaluate()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAValuationReportDOC0039 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAValuationReport hKMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
