package drr.regulation.fca.ukemir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.ValuationMethod_03_Validation;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAValuationReportUKEMIR_VR_2024_03")
@ImplementedBy(FCAValuationReportUKEMIR_VR_2024_03.Default.class)
public interface FCAValuationReportUKEMIR_VR_2024_03 extends Validator<FCAValuationReport> {
	
	String NAME = "FCAValuationReportUKEMIR_VR_2024_03";
	String DEFINITION = "ValuationMethod_03_Validation(valuationAmount, valuationMethod)";
	
	class Default implements FCAValuationReportUKEMIR_VR_2024_03 {
	
		@Inject protected ValuationMethod_03_Validation valuationMethod_03_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			ComparisonResult result = executeDataRule(fCAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAValuationReport fCAValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(valuationMethod_03_Validation.evaluate(MapperS.of(fCAValuationReport).<BigDecimal>map("getValuationAmount", _fCAValuationReport -> _fCAValuationReport.getValuationAmount()).get(), MapperS.of(fCAValuationReport).<ValuationType1Code>map("getValuationMethod", _fCAValuationReport -> _fCAValuationReport.getValuationMethod()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAValuationReportUKEMIR_VR_2024_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			return Collections.emptyList();
		}
	}
}
