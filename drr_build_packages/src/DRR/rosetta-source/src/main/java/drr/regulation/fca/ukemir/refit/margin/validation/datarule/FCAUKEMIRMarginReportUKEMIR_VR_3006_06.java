package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.string.functions.SubString;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3006_06")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3006_06.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3006_06 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3006_06";
	String DEFINITION = "if counterparty2IdentifierType = False then SubString(counterparty2, 1, 20) = counterparty1";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3006_06 {
	
		@Inject protected SubString subString;
		
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
				if (areEqual(MapperS.of(fCAUKEMIRMarginReport).<Boolean>map("getCounterparty2IdentifierType", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(subString.evaluate(MapperS.of(fCAUKEMIRMarginReport).<String>map("getCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCounterparty2()).get(), 1, 20)), MapperS.of(fCAUKEMIRMarginReport).<String>map("getCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCounterparty1()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3006_06 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
