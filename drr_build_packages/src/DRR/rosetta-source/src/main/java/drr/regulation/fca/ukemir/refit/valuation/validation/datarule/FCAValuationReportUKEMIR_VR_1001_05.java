package drr.regulation.fca.ukemir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.ReportingTimestamp_05_Validation_UK;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAValuationReportUKEMIR_VR_1001_05")
@ImplementedBy(FCAValuationReportUKEMIR_VR_1001_05.Default.class)
public interface FCAValuationReportUKEMIR_VR_1001_05 extends Validator<FCAValuationReport> {
	
	String NAME = "FCAValuationReportUKEMIR_VR_1001_05";
	String DEFINITION = "ReportingTimestamp_05_Validation_UK(reportingTimestamp)";
	
	class Default implements FCAValuationReportUKEMIR_VR_1001_05 {
	
		@Inject protected ReportingTimestamp_05_Validation_UK reportingTimestamp_05_Validation_UK;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(reportingTimestamp_05_Validation_UK.evaluate(MapperS.of(fCAValuationReport).<ZonedDateTime>map("getReportingTimestamp", _fCAValuationReport -> _fCAValuationReport.getReportingTimestamp()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAValuationReportUKEMIR_VR_1001_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			return Collections.emptyList();
		}
	}
}
