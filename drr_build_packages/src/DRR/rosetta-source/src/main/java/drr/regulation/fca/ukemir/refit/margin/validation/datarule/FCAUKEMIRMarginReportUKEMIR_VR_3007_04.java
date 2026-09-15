package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3007_04")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3007_04.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3007_04 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3007_04";
	String DEFINITION = "collateralTimestamp -> date = eventDate";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3007_04 {
	
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
				return areEqual(MapperS.of(fCAUKEMIRMarginReport).<ZonedDateTime>map("getCollateralTimestamp", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCollateralTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(fCAUKEMIRMarginReport).<Date>map("getEventDate", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getEventDate()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3007_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
