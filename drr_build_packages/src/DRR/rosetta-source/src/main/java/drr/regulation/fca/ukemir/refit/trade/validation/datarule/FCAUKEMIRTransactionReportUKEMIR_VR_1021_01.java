package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1021_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1021_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1021_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1021_01";
	String DEFINITION = "if (executionAgentCounterparty1 exists and executionAgentCounterparty2 exists) or (executionAgentCounterparty1 is absent and executionAgentCounterparty2 is absent) then nonReportable -> relationshipRecord is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_01 {
	
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
				if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()))).orNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2())))).getOrDefault(false)) {
					return notExists(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<String>map("getRelationshipRecord", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getRelationshipRecord()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
