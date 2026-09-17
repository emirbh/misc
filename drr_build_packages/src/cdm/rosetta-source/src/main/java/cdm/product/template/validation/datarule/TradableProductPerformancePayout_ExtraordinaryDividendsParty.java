package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.asset.DividendReturnTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
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
@RosettaDataRule("TradableProductPerformancePayout_ExtraordinaryDividendsParty")
@ImplementedBy(TradableProductPerformancePayout_ExtraordinaryDividendsParty.Default.class)
public interface TradableProductPerformancePayout_ExtraordinaryDividendsParty extends Validator<TradableProduct> {
	
	String NAME = "TradableProductPerformancePayout_ExtraordinaryDividendsParty";
	String DEFINITION = "if product -> economicTerms -> payout -> PerformancePayout -> returnTerms -> dividendReturnTerms -> extraordinaryDividendsParty exists then ancillaryParty -> role contains AncillaryRoleEnum -> ExtraordinaryDividendsParty and if ancillaryParty -> role contains AncillaryRoleEnum -> ExtraordinaryDividendsParty then product -> economicTerms -> payout -> PerformancePayout -> returnTerms -> dividendReturnTerms -> extraordinaryDividendsParty exists";
	
	class Default implements TradableProductPerformancePayout_ExtraordinaryDividendsParty {
	
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
				if (exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<DividendReturnTerms>map("getDividendReturnTerms", returnTerms -> returnTerms.getDividendReturnTerms()).<AncillaryRoleEnum>map("getExtraordinaryDividendsParty", dividendReturnTerms -> dividendReturnTerms.getExtraordinaryDividendsParty())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXTRAORDINARY_DIVIDENDS_PARTY)).getOrDefault(false)) {
						ifThenElseResult = exists(MapperS.of(tradableProduct).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<DividendReturnTerms>map("getDividendReturnTerms", returnTerms -> returnTerms.getDividendReturnTerms()).<AncillaryRoleEnum>map("getExtraordinaryDividendsParty", dividendReturnTerms -> dividendReturnTerms.getExtraordinaryDividendsParty()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", ancillaryParty -> ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXTRAORDINARY_DIVIDENDS_PARTY)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradableProductPerformancePayout_ExtraordinaryDividendsParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradableProduct tradableProduct) {
			return Collections.emptyList();
		}
	}
}
