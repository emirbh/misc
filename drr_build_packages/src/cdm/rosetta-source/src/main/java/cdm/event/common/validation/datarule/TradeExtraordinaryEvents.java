package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.Agreement;
import cdm.legaldocumentation.common.AgreementTerms;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.transaction.EquityAdditionalTerms;
import cdm.legaldocumentation.transaction.ExtraordinaryEvents;
import cdm.legaldocumentation.transaction.TransactionAdditionalTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
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
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TradeExtraordinaryEvents")
@ImplementedBy(TradeExtraordinaryEvents.Default.class)
public interface TradeExtraordinaryEvents extends Validator<Trade> {
	
	String NAME = "TradeExtraordinaryEvents";
	String DEFINITION = "if contractDetails -> documentation -> agreementTerms -> agreement -> transactionAdditionalTerms -> equityAdditionalTerms -> extraordinaryEvents exists then (product -> economicTerms -> payout -> PerformancePayout -> returnTerms -> priceReturnTerms exists or product -> economicTerms -> payout -> OptionPayout exists) and Qualify_AssetClass_Equity(product -> economicTerms)";
	
	class Default implements TradeExtraordinaryEvents {
	
		@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
		
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
				if (exists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<AgreementTerms>map("getAgreementTerms", legalAgreement -> legalAgreement.getAgreementTerms()).<Agreement>map("getAgreement", agreementTerms -> agreementTerms.getAgreement()).<TransactionAdditionalTerms>map("getTransactionAdditionalTerms", agreement -> agreement.getTransactionAdditionalTerms()).<EquityAdditionalTerms>map("getEquityAdditionalTerms", transactionAdditionalTerms -> transactionAdditionalTerms.getEquityAdditionalTerms()).<ExtraordinaryEvents>map("getExtraordinaryEvents", equityAdditionalTerms -> equityAdditionalTerms.getExtraordinaryEvents())).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<PriceReturnTerms>map("getPriceReturnTerms", returnTerms -> returnTerms.getPriceReturnTerms())).orNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeExtraordinaryEvents {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
