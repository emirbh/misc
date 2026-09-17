package cdm.base.math.validation.datarule;

import cdm.base.math.DatedValue;
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
@RosettaDataRule("NonNegativeQuantityScheduleNonNegativeQuantity_datedValue")
@ImplementedBy(NonNegativeQuantityScheduleNonNegativeQuantity_datedValue.Default.class)
public interface NonNegativeQuantityScheduleNonNegativeQuantity_datedValue extends Validator<NonNegativeQuantitySchedule> {
	
	String NAME = "NonNegativeQuantityScheduleNonNegativeQuantity_datedValue";
	String DEFINITION = "if datedValue exists then datedValue -> value all >= 0.0";
	
	class Default implements NonNegativeQuantityScheduleNonNegativeQuantity_datedValue {
	
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
				if (exists(MapperS.of(nonNegativeQuantitySchedule).<DatedValue>mapC("getDatedValue", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getDatedValue())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(nonNegativeQuantitySchedule).<DatedValue>mapC("getDatedValue", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonNegativeQuantityScheduleNonNegativeQuantity_datedValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
			return Collections.emptyList();
		}
	}
}
