package drr.regulation.hkma.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMAValuationReportDOC0016")
@ImplementedBy(HKMAValuationReportDOC0016.Default.class)
public interface HKMAValuationReportDOC0016 extends Validator<HKMAValuationReport> {
	
	String NAME = "HKMAValuationReportDOC0016";
	String DEFINITION = "True";
	
	class Default implements HKMAValuationReportDOC0016 {
	
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
				return ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAValuationReportDOC0016 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAValuationReport hKMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
