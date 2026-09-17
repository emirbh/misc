package cdm.base.math.validation.datarule;

import cdm.base.math.NonNegativeQuantitySchedule;
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
@RosettaDataRule("NonNegativeQuantityScheduleNonNegativeQuantity_value")
@ImplementedBy(NonNegativeQuantityScheduleNonNegativeQuantity_value.Default.class)
public interface NonNegativeQuantityScheduleNonNegativeQuantity_value extends Validator<NonNegativeQuantitySchedule> {
	
	String NAME = "NonNegativeQuantityScheduleNonNegativeQuantity_value";
	String DEFINITION = "if value exists then value >= 0.0";
	
	class Default implements NonNegativeQuantityScheduleNonNegativeQuantity_value {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
			ComparisonResult result = executeDataRule(nonNegativeQuantitySchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantitySchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantitySchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
			try {
				if (exists(MapperS.of(nonNegativeQuantitySchedule).<BigDecimal>map("getValue", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getValue())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(nonNegativeQuantitySchedule).<BigDecimal>map("getValue", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getValue()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonNegativeQuantityScheduleNonNegativeQuantity_value {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
			return Collections.emptyList();
		}
	}
}
