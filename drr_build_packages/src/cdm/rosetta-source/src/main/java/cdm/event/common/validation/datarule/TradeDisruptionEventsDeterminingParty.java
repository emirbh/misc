package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.Agreement;
import cdm.legaldocumentation.common.AgreementTerms;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.transaction.AdditionalDisruptionEvents;
import cdm.legaldocumentation.transaction.EquityAdditionalTerms;
import cdm.legaldocumentation.transaction.ExtraordinaryEvents;
import cdm.legaldocumentation.transaction.TransactionAdditionalTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TradeDisruptionEventsDeterminingParty")
@ImplementedBy(TradeDisruptionEventsDeterminingParty.Default.class)
public interface TradeDisruptionEventsDeterminingParty extends Validator<Trade> {
	
	String NAME = "TradeDisruptionEventsDeterminingParty";
	String DEFINITION = "if contractDetails -> documentation -> agreementTerms -> agreement -> transactionAdditionalTerms -> equityAdditionalTerms -> extraordinaryEvents -> additionalDisruptionEvents -> determiningParty exists then ancillaryParty -> role contains AncillaryRoleEnum -> DisruptionEventsDeterminingParty and if ancillaryParty -> role contains AncillaryRoleEnum -> DisruptionEventsDeterminingParty then contractDetails -> documentation -> agreementTerms -> agreement -> transactionAdditionalTerms -> equityAdditionalTerms -> extraordinaryEvents -> additionalDisruptionEvents -> determiningParty exists";
	
	class Default implements TradeDisruptionEventsDeterminingParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			ComparisonResult result = executeDataRule(trade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Trade trade) {
			try {
				if (exists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<AgreementTerms>map("getAgreementTerms", legalAgreement -> legalAgreement.getAgreementTerms()).<Agreement>map("getAgreement", agreementTerms -> agreementTerms.getAgreement()).<TransactionAdditionalTerms>map("getTransactionAdditionalTerms", agreement -> agreement.getTransactionAdditionalTerms()).<EquityAdditionalTerms>map("getEquityAdditionalTerms", transactionAdditionalTerms -> transactionAdditionalTerms.getEquityAdditionalTerms()).<ExtraordinaryEvents>map("getExtraordinaryEvents", equityAdditionalTerms -> equityAdditionalTerms.getExtraordinaryEvents()).<AdditionalDisruptionEvents>map("getAdditionalDisruptionEvents", extraordinaryEvents -> extraordinaryEvents.getAdditionalDisruptionEvents()).<AncillaryRoleEnum>map("getDeterminingParty", additionalDisruptionEvents -> additionalDisruptionEvents.getDeterminingParty())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (contains(MapperS.of(trade).<AncillaryParty>mapC("getAncillaryParty", _trade -> _trade.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.DISRUPTION_EVENTS_DETERMINING_PARTY)).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<AgreementTerms>map("getAgreementTerms", legalAgreement -> legalAgreement.getAgreementTerms()).<Agreement>map("getAgreement", agreementTerms -> agreementTerms.getAgreement()).<TransactionAdditionalTerms>map("getTransactionAdditionalTerms", agreement -> agreement.getTransactionAdditionalTerms()).<EquityAdditionalTerms>map("getEquityAdditionalTerms", transactionAdditionalTerms -> transactionAdditionalTerms.getEquityAdditionalTerms()).<ExtraordinaryEvents>map("getExtraordinaryEvents", equityAdditionalTerms -> equityAdditionalTerms.getExtraordinaryEvents()).<AdditionalDisruptionEvents>map("getAdditionalDisruptionEvents", extraordinaryEvents -> extraordinaryEvents.getAdditionalDisruptionEvents()).<AncillaryRoleEnum>map("getDeterminingParty", additionalDisruptionEvents -> additionalDisruptionEvents.getDeterminingParty()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return contains(MapperS.of(trade).<AncillaryParty>mapC("getAncillaryParty", _trade -> _trade.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.DISRUPTION_EVENTS_DETERMINING_PARTY)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeDisruptionEventsDeterminingParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
