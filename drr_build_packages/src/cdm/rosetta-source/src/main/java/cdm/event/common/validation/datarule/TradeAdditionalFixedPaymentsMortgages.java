package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.common.DebtClassEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.ContractualSupplementTypeEnum;
import cdm.legaldocumentation.common.ContractualTermsSupplement;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualSupplementTypeEnum;
import cdm.product.asset.AdditionalFixedPayments;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingAmountEvents;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("TradeAdditionalFixedPaymentsMortgages")
@ImplementedBy(TradeAdditionalFixedPaymentsMortgages.Default.class)
public interface TradeAdditionalFixedPaymentsMortgages extends Validator<Trade> {
	
	String NAME = "TradeAdditionalFixedPaymentsMortgages";
	String DEFINITION = "if ((product -> economicTerms -> payout -> CreditDefaultPayout -> generalTerms -> referenceInformation -> referenceObligation -> security -> instrumentType any = InstrumentTypeEnum -> Debt and product -> economicTerms -> payout -> CreditDefaultPayout -> generalTerms -> referenceInformation -> referenceObligation -> security -> debtType -> debtClass any = DebtClassEnum -> AssetBacked) or contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualTermsSupplement -> contractualTermsSupplementType contains ContractualSupplementTypeEnum -> CDSonMBS) and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> floatingAmountEvents exists then (product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> interestShortfallReimbursement exists and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> principalShortfallReimbursement exists and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> writedownReimbursement exists)";
	
	class Default implements TradeAdditionalFixedPaymentsMortgages {
	
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
				if (areEqual(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtClassEnum>map("getDebtClass", debtType -> debtType.getDebtClass()), MapperS.of(DebtClassEnum.ASSET_BACKED), CardinalityOperator.Any)).orNullSafe(contains(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<ContractualTermsSupplement>mapC("getContractualTermsSupplement", agreementName -> agreementName.getContractualTermsSupplement()).<FieldWithMetaContractualSupplementTypeEnum>map("getContractualTermsSupplementType", contractualTermsSupplement -> contractualTermsSupplement.getContractualTermsSupplementType()).<ContractualSupplementTypeEnum>map("Type coercion", fieldWithMetaContractualSupplementTypeEnum -> fieldWithMetaContractualSupplementTypeEnum.getValue()), MapperS.of(ContractualSupplementTypeEnum.CD_SON_MBS))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", protectionTerms -> protectionTerms.getFloatingAmountEvents()))).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", protectionTerms -> protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", floatingAmountEvents -> floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getInterestShortfallReimbursement", additionalFixedPayments -> additionalFixedPayments.getInterestShortfallReimbursement())).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", protectionTerms -> protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", floatingAmountEvents -> floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getPrincipalShortfallReimbursement", additionalFixedPayments -> additionalFixedPayments.getPrincipalShortfallReimbursement()))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", protectionTerms -> protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", floatingAmountEvents -> floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getWritedownReimbursement", additionalFixedPayments -> additionalFixedPayments.getWritedownReimbursement())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeAdditionalFixedPaymentsMortgages {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
