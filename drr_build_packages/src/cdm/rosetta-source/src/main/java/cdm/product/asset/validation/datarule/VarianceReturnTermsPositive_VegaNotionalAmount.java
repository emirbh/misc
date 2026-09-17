package cdm.product.asset.validation.datarule;

import cdm.base.math.NonNegativeQuantitySchedule;
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
@RosettaDataRule("VarianceReturnTermsPositive_VegaNotionalAmount")
@ImplementedBy(VarianceReturnTermsPositive_VegaNotionalAmount.Default.class)
public interface VarianceReturnTermsPositive_VegaNotionalAmount extends Validator<VarianceReturnTerms> {
	
	String NAME = "VarianceReturnTermsPositive_VegaNotionalAmount";
	String DEFINITION = "if vegaNotionalAmount -> value exists then vegaNotionalAmount -> value > 0";
	
	class Default implements VarianceReturnTermsPositive_VegaNotionalAmount {
	
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
				if (exists(MapperS.of(varianceReturnTerms).<NonNegativeQuantitySchedule>map("getVegaNotionalAmount", _varianceReturnTerms -> _varianceReturnTerms.getVegaNotionalAmount()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).getOrDefault(false)) {
					return greaterThan(MapperS.of(varianceReturnTerms).<NonNegativeQuantitySchedule>map("getVegaNotionalAmount", _varianceReturnTerms -> _varianceReturnTerms.getVegaNotionalAmount()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceReturnTermsPositive_VegaNotionalAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			return Collections.emptyList();
		}
	}
}
