package cdm.product.template.validation.datarule;

import cdm.product.asset.DividendReturnTerms;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.ReturnTerms;
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
@RosettaDataRule("EconomicTermsReturnType_Total_Requires_Dividends")
@ImplementedBy(EconomicTermsReturnType_Total_Requires_Dividends.Default.class)
public interface EconomicTermsReturnType_Total_Requires_Dividends extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsReturnType_Total_Requires_Dividends";
	String DEFINITION = "if payout -> PerformancePayout -> returnTerms -> priceReturnTerms -> returnType all = ReturnTypeEnum -> Total then payout -> PerformancePayout -> returnTerms -> dividendReturnTerms exists";
	
	class Default implements EconomicTermsReturnType_Total_Requires_Dividends {
	
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
				if (areEqual(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<PriceReturnTerms>map("getPriceReturnTerms", returnTerms -> returnTerms.getPriceReturnTerms()).<ReturnTypeEnum>map("getReturnType", priceReturnTerms -> priceReturnTerms.getReturnType()), MapperS.of(ReturnTypeEnum.TOTAL), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<DividendReturnTerms>map("getDividendReturnTerms", returnTerms -> returnTerms.getDividendReturnTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsReturnType_Total_Requires_Dividends {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
