package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.EventDate_04_Validation;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2153_04")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2153_04.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2153_04 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2153_04";
	String DEFINITION = "EventDate_04_Validation(eventDate, reportingTimestamp)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2153_04 {
	
		@Inject protected EventDate_04_Validation eventDate_04_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(eventDate_04_Validation.evaluate(MapperS.of(eSMAEMIRTransactionReport).<Date>map("getEventDate", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEventDate()).get(), MapperS.of(eSMAEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReportingTimestamp()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2153_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
