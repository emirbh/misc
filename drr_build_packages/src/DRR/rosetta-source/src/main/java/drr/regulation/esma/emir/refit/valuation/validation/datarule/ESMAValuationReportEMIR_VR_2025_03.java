package drr.regulation.esma.emir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.Delta_03_Validation;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAValuationReportEMIR_VR_2025_03")
@ImplementedBy(ESMAValuationReportEMIR_VR_2025_03.Default.class)
public interface ESMAValuationReportEMIR_VR_2025_03 extends Validator<ESMAValuationReport> {
	
	String NAME = "ESMAValuationReportEMIR_VR_2025_03";
	String DEFINITION = "Delta_03_Validation(delta)";
	
	class Default implements ESMAValuationReportEMIR_VR_2025_03 {
	
		@Inject protected Delta_03_Validation delta_03_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAValuationReport eSMAValuationReport) {
			ComparisonResult result = executeDataRule(eSMAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAValuationReport eSMAValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(delta_03_Validation.evaluate(MapperS.of(eSMAValuationReport).<BigDecimal>map("getDelta", _eSMAValuationReport -> _eSMAValuationReport.getDelta()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAValuationReportEMIR_VR_2025_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAValuationReport eSMAValuationReport) {
			return Collections.emptyList();
		}
	}
}
