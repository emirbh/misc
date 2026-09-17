package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.ContractualMatrix;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.MatrixTypeEnum;
import cdm.legaldocumentation.common.metafields.FieldWithMetaMatrixTypeEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.ProtectionTerms;
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
@RosettaDataRule("TradeObligationsPhysicalSettlementMatrix")
@ImplementedBy(TradeObligationsPhysicalSettlementMatrix.Default.class)
public interface TradeObligationsPhysicalSettlementMatrix extends Validator<Trade> {
	
	String NAME = "TradeObligationsPhysicalSettlementMatrix";
	String DEFINITION = "if (contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualMatrix -> matrixType all <> MatrixTypeEnum -> CreditDerivativesPhysicalSettlementMatrix or contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualMatrix -> matrixType is absent) and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations exists then (product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> notSubordinated exists and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> notSovereignLender exists and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> notDomesticLaw exists and product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> notDomesticIssuance exists) and (product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> fullFaithAndCreditObLiability exists or product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> generalFundObligationLiability exists or product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> revenueObligationLiability exists)";
	
	class Default implements TradeObligationsPhysicalSettlementMatrix {
	
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
				if (notEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<ContractualMatrix>mapC("getContractualMatrix", agreementName -> agreementName.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", contractualMatrix -> contractualMatrix.getMatrixType()).<MatrixTypeEnum>map("Type coercion", fieldWithMetaMatrixTypeEnum -> fieldWithMetaMatrixTypeEnum.getValue()), MapperS.of(MatrixTypeEnum.CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX), CardinalityOperator.All).orNullSafe(notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<ContractualMatrix>mapC("getContractualMatrix", agreementName -> agreementName.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", contractualMatrix -> contractualMatrix.getMatrixType()))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()))).getOrDefault(false)) {
					return exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getNotSubordinated", obligations -> obligations.getNotSubordinated())).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getNotSovereignLender", obligations -> obligations.getNotSovereignLender()))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getNotDomesticLaw", obligations -> obligations.getNotDomesticLaw()))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getNotDomesticIssuance", obligations -> obligations.getNotDomesticIssuance()))).andNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getFullFaithAndCreditObLiability", obligations -> obligations.getFullFaithAndCreditObLiability())).orNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getGeneralFundObligationLiability", obligations -> obligations.getGeneralFundObligationLiability()))).orNullSafe(exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getRevenueObligationLiability", obligations -> obligations.getRevenueObligationLiability()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeObligationsPhysicalSettlementMatrix {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
