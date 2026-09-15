package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_ExpirationDate")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_ExpirationDate.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_ExpirationDate extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_ExpirationDate";
	String DEFINITION = "if expirationDate exists then expirationDate = effectiveDate or expirationDate > effectiveDate";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_ExpirationDate {
	
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
				if (exists(MapperS.of(sECTransactionReport).<Date>map("getExpirationDate", _sECTransactionReport -> _sECTransactionReport.getExpirationDate())).getOrDefault(false)) {
					return areEqual(MapperS.of(sECTransactionReport).<Date>map("getExpirationDate", _sECTransactionReport -> _sECTransactionReport.getExpirationDate()), MapperS.of(sECTransactionReport).<Date>map("getEffectiveDate", _sECTransactionReport -> _sECTransactionReport.getEffectiveDate()), CardinalityOperator.All).orNullSafe(greaterThan(MapperS.of(sECTransactionReport).<Date>map("getExpirationDate", _sECTransactionReport -> _sECTransactionReport.getExpirationDate()), MapperS.of(sECTransactionReport).<Date>map("getEffectiveDate", _sECTransactionReport -> _sECTransactionReport.getEffectiveDate()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_ExpirationDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
