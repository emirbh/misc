package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1009_05")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1009_05.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1009_05 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1009_05";
	String DEFINITION = "if centralCounterparty <> counterparty2 then counterparty1 <> counterparty2";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_05 {
	
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
				if (notEqual(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCentralCounterparty", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCentralCounterparty()), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2()), CardinalityOperator.Any).getOrDefault(false)) {
					return notEqual(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty1()), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCounterparty2()), CardinalityOperator.Any);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1009_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
