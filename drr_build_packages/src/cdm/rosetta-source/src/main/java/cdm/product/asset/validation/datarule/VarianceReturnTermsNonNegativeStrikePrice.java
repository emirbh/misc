package cdm.product.asset.validation.datarule;

import cdm.observable.asset.Price;
import cdm.product.asset.VarianceReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("VarianceReturnTermsNonNegativeStrikePrice")
@ImplementedBy(VarianceReturnTermsNonNegativeStrikePrice.Default.class)
public interface VarianceReturnTermsNonNegativeStrikePrice extends Validator<VarianceReturnTerms> {
	
	String NAME = "VarianceReturnTermsNonNegativeStrikePrice";
	String DEFINITION = "if volatilityStrikePrice -> value exists then volatilityStrikePrice -> value >= 0 and if varianceStrikePrice -> value exists then varianceStrikePrice -> value >= 0";
	
	class Default implements VarianceReturnTermsNonNegativeStrikePrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			ComparisonResult result = executeDataRule(varianceReturnTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceReturnTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceReturnTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VarianceReturnTerms varianceReturnTerms) {
			try {
				if (exists(MapperS.of(varianceReturnTerms).<Price>map("getVolatilityStrikePrice", _varianceReturnTerms -> _varianceReturnTerms.getVolatilityStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(varianceReturnTerms).<Price>map("getVarianceStrikePrice", _varianceReturnTerms -> _varianceReturnTerms.getVarianceStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue())).getOrDefault(false)) {
						ifThenElseResult = greaterThanEquals(MapperS.of(varianceReturnTerms).<Price>map("getVarianceStrikePrice", _varianceReturnTerms -> _varianceReturnTerms.getVarianceStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return greaterThanEquals(MapperS.of(varianceReturnTerms).<Price>map("getVolatilityStrikePrice", _varianceReturnTerms -> _varianceReturnTerms.getVolatilityStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceReturnTermsNonNegativeStrikePrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			return Collections.emptyList();
		}
	}
}
