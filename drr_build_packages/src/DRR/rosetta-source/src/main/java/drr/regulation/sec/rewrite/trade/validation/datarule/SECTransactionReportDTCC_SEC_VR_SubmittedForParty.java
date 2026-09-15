package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_SubmittedForParty")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_SubmittedForParty.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_SubmittedForParty extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_SubmittedForParty";
	String DEFINITION = "if [\"Party1\", \"BOTH\"] all <> dtccAdditionalFields -> submittedForParty then dtccAdditionalFields -> submittedForParty = counterparty1";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_SubmittedForParty {
	
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
				if (notEqual(MapperC.<String>of(MapperS.of("Party1"), MapperS.of("BOTH")), MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<String>map("getSubmittedForParty", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittedForParty()), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<String>map("getSubmittedForParty", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittedForParty()), MapperS.of(sECTransactionReport).<String>map("getCounterparty1", _sECTransactionReport -> _sECTransactionReport.getCounterparty1()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_SubmittedForParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
