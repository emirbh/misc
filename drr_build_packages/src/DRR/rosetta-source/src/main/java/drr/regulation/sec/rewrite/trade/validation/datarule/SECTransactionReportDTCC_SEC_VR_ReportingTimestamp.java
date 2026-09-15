package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_ReportingTimestamp")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_ReportingTimestamp.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_ReportingTimestamp extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_ReportingTimestamp";
	String DEFINITION = "reportingTimestamp = executionTimestamp or reportingTimestamp > executionTimestamp";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_ReportingTimestamp {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				return areEqual(MapperS.of(sECTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _sECTransactionReport -> _sECTransactionReport.getReportingTimestamp()), MapperS.of(sECTransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _sECTransactionReport -> _sECTransactionReport.getExecutionTimestamp()), CardinalityOperator.All).orNullSafe(greaterThan(MapperS.of(sECTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _sECTransactionReport -> _sECTransactionReport.getReportingTimestamp()), MapperS.of(sECTransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _sECTransactionReport -> _sECTransactionReport.getExecutionTimestamp()), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_ReportingTimestamp {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
