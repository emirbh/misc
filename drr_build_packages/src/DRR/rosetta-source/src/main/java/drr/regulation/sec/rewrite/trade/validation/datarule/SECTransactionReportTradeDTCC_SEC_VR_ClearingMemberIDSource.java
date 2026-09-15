package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource";
	String DEFINITION = "if clearingMember exists then dtccAdditionalFields -> tradeParty1ClearingBrokerIDType exists";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			ComparisonResult result = executeDataRule(sECTransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReportTrade sECTransactionReportTrade) {
			try {
				if (exists(MapperS.of(sECTransactionReportTrade).<String>map("getClearingMember", _sECTransactionReportTrade -> _sECTransactionReportTrade.getClearingMember())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReportTrade -> _sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ClearingBrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ClearingBrokerIDType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_ClearingMemberIDSource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
