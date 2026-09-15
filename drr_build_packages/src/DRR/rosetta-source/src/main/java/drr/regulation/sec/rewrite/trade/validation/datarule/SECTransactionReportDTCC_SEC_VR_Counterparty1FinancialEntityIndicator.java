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
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator";
	String DEFINITION = "if cleared = N or cleared = I then counterparty1FinancialEntityIndicator exists";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator {
	
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
				if (areEqual(MapperS.of(sECTransactionReport).<ClearedEnum>map("getCleared", _sECTransactionReport -> _sECTransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<ClearedEnum>map("getCleared", _sECTransactionReport -> _sECTransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<Boolean>map("getCounterparty1FinancialEntityIndicator", _sECTransactionReport -> _sECTransactionReport.getCounterparty1FinancialEntityIndicator()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
