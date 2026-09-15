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
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_Counterparty1")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_Counterparty1.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_Counterparty1 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_Counterparty1";
	String DEFINITION = "if dtccAdditionalFields -> tradeParty1IDType = \"NPID\" then [\"XXXX\", \"XOFF\", \"BILT\"] any <> platformIdentifier and cleared = I";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_Counterparty1 {
	
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
				if (areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1IDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1IDType()), MapperS.of("NPID"), CardinalityOperator.All).getOrDefault(false)) {
					return notEqual(MapperC.<String>of(MapperS.of("XXXX"), MapperS.of("XOFF"), MapperS.of("BILT")), MapperS.of(sECTransactionReport).<String>map("getPlatformIdentifier", _sECTransactionReport -> _sECTransactionReport.getPlatformIdentifier()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<ClearedEnum>map("getCleared", _sECTransactionReport -> _sECTransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_Counterparty1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
