package cdm.base.math.validation.datarule;

import cdm.base.math.NonNegativeQuantity;
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
@RosettaDataRule("NonNegativeQuantityNonNegativeQuantity_amount")
@ImplementedBy(NonNegativeQuantityNonNegativeQuantity_amount.Default.class)
public interface NonNegativeQuantityNonNegativeQuantity_amount extends Validator<NonNegativeQuantity> {
	
	String NAME = "NonNegativeQuantityNonNegativeQuantity_amount";
	String DEFINITION = "value >= 0.0";
	
	class Default implements NonNegativeQuantityNonNegativeQuantity_amount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantity nonNegativeQuantity) {
			ComparisonResult result = executeDataRule(nonNegativeQuantity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NonNegativeQuantity nonNegativeQuantity) {
			try {
				return greaterThanEquals(MapperS.of(nonNegativeQuantity).<BigDecimal>map("getValue", _nonNegativeQuantity -> _nonNegativeQuantity.getValue()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonNegativeQuantityNonNegativeQuantity_amount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantity nonNegativeQuantity) {
			return Collections.emptyList();
		}
	}
}
