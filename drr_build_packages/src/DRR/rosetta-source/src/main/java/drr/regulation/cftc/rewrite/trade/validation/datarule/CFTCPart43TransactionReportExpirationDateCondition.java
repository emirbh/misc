package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportExpirationDateCondition")
@ImplementedBy(CFTCPart43TransactionReportExpirationDateCondition.Default.class)
public interface CFTCPart43TransactionReportExpirationDateCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportExpirationDateCondition";
	String DEFINITION = "if expirationDate exists then expirationDate = effectiveDate or expirationDate > effectiveDate else False";
	
	class Default implements CFTCPart43TransactionReportExpirationDateCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (exists(MapperS.of(cFTCPart43TransactionReport).<Date>map("getExpirationDate", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getExpirationDate())).getOrDefault(false)) {
					return areEqual(MapperS.of(cFTCPart43TransactionReport).<Date>map("getExpirationDate", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getExpirationDate()), MapperS.of(cFTCPart43TransactionReport).<Date>map("getEffectiveDate", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getEffectiveDate()), CardinalityOperator.All).orNullSafe(greaterThan(MapperS.of(cFTCPart43TransactionReport).<Date>map("getExpirationDate", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getExpirationDate()), MapperS.of(cFTCPart43TransactionReport).<Date>map("getEffectiveDate", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getEffectiveDate()), CardinalityOperator.All));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportExpirationDateCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
