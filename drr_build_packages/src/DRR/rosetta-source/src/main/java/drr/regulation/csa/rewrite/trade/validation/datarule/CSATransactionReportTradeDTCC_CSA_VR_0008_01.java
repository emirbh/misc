package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeDTCC_CSA_VR_0008_01")
@ImplementedBy(CSATransactionReportTradeDTCC_CSA_VR_0008_01.Default.class)
public interface CSATransactionReportTradeDTCC_CSA_VR_0008_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeDTCC_CSA_VR_0008_01";
	String DEFINITION = "if dtccAdditionalFields -> tradeParty1BrokerIDType exists then brokerID exists";
	
	class Default implements CSATransactionReportTradeDTCC_CSA_VR_0008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (exists(MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1BrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1BrokerIDType())).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<String>map("getBrokerID", _cSATransactionReportTrade -> _cSATransactionReportTrade.getBrokerID()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeDTCC_CSA_VR_0008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
