package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradableProduct;
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
@RosettaDataRule("TradableProductForwardPayout_PredeterminedClearingOrganizationParty")
@ImplementedBy(TradableProductForwardPayout_PredeterminedClearingOrganizationParty.Default.class)
public interface TradableProductForwardPayout_PredeterminedClearingOrganizationParty extends Validator<TradableProduct> {
	
	String NAME = "TradableProductForwardPayout_PredeterminedClearingOrganizationParty";
	String DEFINITION = "if product -> economicTerms -> payout -> SettlementPayout -> settlementTerms -> physicalSettlementTerms -> predeterminedClearingOrganizationParty exists then ancillaryParty -> role contains AncillaryRoleEnum -> PredeterminedClearingOrganizationParty";
	
	class Default implements TradableProductForwardPayout_PredeterminedClearingOrganizationParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			ComparisonResult result = executeDataRule(tradableProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
			try {
				if (exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()).<AncillaryRoleEnum>map("getPredeterminedClearingOrganizationParty", physicalSettlementTerms -> physicalSettlementTerms.getPredeterminedClearingOrganizationParty())).getOrDefault(false)) {
					return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductForwardPayout_PredeterminedClearingOrganizationParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			return Collections.emptyList();
		}
	}
}
