package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.template.AssetPayout;
import cdm.product.template.DividendTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
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
@RosettaDataRule("EconomicTermsAssetPayoutDividendTermsValidation")
@ImplementedBy(EconomicTermsAssetPayoutDividendTermsValidation.Default.class)
public interface EconomicTermsAssetPayoutDividendTermsValidation extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsAssetPayoutDividendTermsValidation";
	String DEFINITION = "if payout -> AssetPayout -> dividendTerms exists then terminationDate exists";
	
	class Default implements EconomicTermsAssetPayoutDividendTermsValidation {
	
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
				if (exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<AssetPayout>map("getAssetPayout", payout -> payout.getAssetPayout()).<DividendTerms>map("getDividendTerms", assetPayout -> assetPayout.getDividendTerms())).getOrDefault(false)) {
					return exists(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsAssetPayoutDividendTermsValidation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
