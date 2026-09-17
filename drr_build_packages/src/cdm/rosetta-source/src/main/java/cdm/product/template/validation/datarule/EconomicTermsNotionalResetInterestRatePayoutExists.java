package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
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
@RosettaDataRule("EconomicTermsNotionalResetInterestRatePayoutExists")
@ImplementedBy(EconomicTermsNotionalResetInterestRatePayoutExists.Default.class)
public interface EconomicTermsNotionalResetInterestRatePayoutExists extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsNotionalResetInterestRatePayoutExists";
	String DEFINITION = "if payout -> PerformancePayout -> priceQuantity -> reset contains True then payout -> InterestRatePayout exists";
	
	class Default implements EconomicTermsNotionalResetInterestRatePayoutExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				if (contains(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()), MapperS.of(true)).getOrDefault(false)) {
					return exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsNotionalResetInterestRatePayoutExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
