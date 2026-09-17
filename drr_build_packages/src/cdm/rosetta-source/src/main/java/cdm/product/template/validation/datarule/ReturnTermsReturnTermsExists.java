package cdm.product.template.validation.datarule;

import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
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
@RosettaDataRule("ReturnTermsReturnTermsExists")
@ImplementedBy(ReturnTermsReturnTermsExists.Default.class)
public interface ReturnTermsReturnTermsExists extends Validator<ReturnTerms> {
	
	String NAME = "ReturnTermsReturnTermsExists";
	String DEFINITION = "if priceReturnTerms -> returnType = ReturnTypeEnum -> Total then (priceReturnTerms, dividendReturnTerms) only exists else if priceReturnTerms -> returnType = ReturnTypeEnum -> Price then priceReturnTerms only exists else priceReturnTerms only exists or dividendReturnTerms only exists or varianceReturnTerms only exists or volatilityReturnTerms only exists or correlationReturnTerms only exists";
	
	class Default implements ReturnTermsReturnTermsExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnTerms returnTerms) {
			ComparisonResult result = executeDataRule(returnTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReturnTerms returnTerms) {
			try {
				if (areEqual(MapperS.of(returnTerms).<PriceReturnTerms>map("getPriceReturnTerms", _returnTerms -> _returnTerms.getPriceReturnTerms()).<ReturnTypeEnum>map("getReturnType", priceReturnTerms -> priceReturnTerms.getReturnType()), MapperS.of(ReturnTypeEnum.TOTAL), CardinalityOperator.All).getOrDefault(false)) {
					return onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("priceReturnTerms", "dividendReturnTerms"));
				}
				if (areEqual(MapperS.of(returnTerms).<PriceReturnTerms>map("getPriceReturnTerms", _returnTerms -> _returnTerms.getPriceReturnTerms()).<ReturnTypeEnum>map("getReturnType", priceReturnTerms -> priceReturnTerms.getReturnType()), MapperS.of(ReturnTypeEnum.PRICE), CardinalityOperator.All).getOrDefault(false)) {
					return onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("priceReturnTerms"));
				}
				return onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("priceReturnTerms")).orNullSafe(onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("dividendReturnTerms"))).orNullSafe(onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("varianceReturnTerms"))).orNullSafe(onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("volatilityReturnTerms"))).orNullSafe(onlyExists(MapperS.of(returnTerms), Arrays.asList("priceReturnTerms", "dividendReturnTerms", "varianceReturnTerms", "volatilityReturnTerms", "correlationReturnTerms"), Arrays.asList("correlationReturnTerms")));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnTermsReturnTermsExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnTerms returnTerms) {
			return Collections.emptyList();
		}
	}
}
