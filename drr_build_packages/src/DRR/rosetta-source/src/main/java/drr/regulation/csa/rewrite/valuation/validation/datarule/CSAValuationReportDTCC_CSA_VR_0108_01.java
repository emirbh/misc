package drr.regulation.csa.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CSAValuationReportDTCC_CSA_VR_0108_01")
@ImplementedBy(CSAValuationReportDTCC_CSA_VR_0108_01.Default.class)
public interface CSAValuationReportDTCC_CSA_VR_0108_01 extends Validator<CSAValuationReport> {
	
	String NAME = "CSAValuationReportDTCC_CSA_VR_0108_01";
	String DEFINITION = "True";
	
	class Default implements CSAValuationReportDTCC_CSA_VR_0108_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport cSAValuationReport) {
			ComparisonResult result = executeDataRule(cSAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAValuationReport cSAValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAValuationReportDTCC_CSA_VR_0108_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAValuationReport cSAValuationReport) {
			return Collections.emptyList();
		}
	}
}
