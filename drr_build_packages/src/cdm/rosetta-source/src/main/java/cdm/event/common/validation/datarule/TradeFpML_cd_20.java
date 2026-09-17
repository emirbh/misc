package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.metafields.FieldWithMetaContractualDefinitionsEnum;
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
@RosettaDataRule("TradeFpML_cd_20")
@ImplementedBy(TradeFpML_cd_20.Default.class)
public interface TradeFpML_cd_20 extends Validator<Trade> {
	
	String NAME = "TradeFpML_cd_20";
	String DEFINITION = "if contractDetails -> documentation -> legalAgreementIdentification -> agreementName -> contractualDefinitionsType any = ContractualDefinitionsEnum -> ISDA2003CreditDerivatives then product -> economicTerms -> payout -> CreditDefaultPayout -> protectionTerms -> obligations -> notContingent is absent";
	
	class Default implements TradeFpML_cd_20 {
	
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
				if (areEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<LegalAgreement>mapC("getDocumentation", contractDetails -> contractDetails.getDocumentation()).<LegalAgreementIdentification>map("getLegalAgreementIdentification", legalAgreement -> legalAgreement.getLegalAgreementIdentification()).<AgreementName>map("getAgreementName", legalAgreementIdentification -> legalAgreementIdentification.getAgreementName()).<FieldWithMetaContractualDefinitionsEnum>mapC("getContractualDefinitionsType", agreementName -> agreementName.getContractualDefinitionsType()).<ContractualDefinitionsEnum>map("Type coercion", fieldWithMetaContractualDefinitionsEnum -> fieldWithMetaContractualDefinitionsEnum.getValue()), MapperS.of(ContractualDefinitionsEnum.ISDA_2003_CREDIT_DERIVATIVES), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultPayout -> creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", protectionTerms -> protectionTerms.getObligations()).<Boolean>map("getNotContingent", obligations -> obligations.getNotContingent()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeFpML_cd_20 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
