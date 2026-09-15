package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.ReportingTimestamp_05_Validation_UK;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1001_05")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1001_05.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1001_05 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1001_05";
	String DEFINITION = "ReportingTimestamp_05_Validation_UK(reportingTimestamp)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1001_05 {
	
		@Inject protected ReportingTimestamp_05_Validation_UK reportingTimestamp_05_Validation_UK;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(reportingTimestamp_05_Validation_UK.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1001_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
