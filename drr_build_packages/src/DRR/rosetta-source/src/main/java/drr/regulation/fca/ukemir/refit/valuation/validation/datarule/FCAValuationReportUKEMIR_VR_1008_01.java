package drr.regulation.fca.ukemir.refit.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.emir.functions.Counterparty2IdentifierType_01_Validation;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAValuationReportUKEMIR_VR_1008_01")
@ImplementedBy(FCAValuationReportUKEMIR_VR_1008_01.Default.class)
public interface FCAValuationReportUKEMIR_VR_1008_01 extends Validator<FCAValuationReport> {
	
	String NAME = "FCAValuationReportUKEMIR_VR_1008_01";
	String DEFINITION = "Counterparty2IdentifierType_01_Validation(counterparty2IdentifierType)";
	
	class Default implements FCAValuationReportUKEMIR_VR_1008_01 {
	
		@Inject protected Counterparty2IdentifierType_01_Validation counterparty2IdentifierType_01_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty2IdentifierType_01_Validation.evaluate(MapperS.of(fCAValuationReport).<Boolean>map("getCounterparty2IdentifierType", _fCAValuationReport -> _fCAValuationReport.getCounterparty2IdentifierType()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAValuationReportUKEMIR_VR_1008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAValuationReport fCAValuationReport) {
			return Collections.emptyList();
		}
	}
}
