package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.Counterparty2_06_Validation;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1009_06")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1009_06.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1009_06 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1009_06";
	String DEFINITION = "Counterparty2_06_Validation(counterparty2IdentifierType, counterparty2)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_06 {
	
		@Inject protected Counterparty2_06_Validation counterparty2_06_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty2_06_Validation.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<Boolean>map("getCounterparty2IdentifierType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2IdentifierType()).get(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_06 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
