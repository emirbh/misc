package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3030_02")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3030_02.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3030_02 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3030_02";
	String DEFINITION = "if (executionAgentOfCounterparty1 exists and executionAgentOfCounterparty2 is absent) or (executionAgentOfCounterparty1 is absent and executionAgentOfCounterparty2 exists) then nonReportable -> relationshipRecord exists";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3030_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			try {
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).orNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2())))).getOrDefault(false)) {
					return exists(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<String>map("getRelationshipRecord", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getRelationshipRecord()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3030_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
