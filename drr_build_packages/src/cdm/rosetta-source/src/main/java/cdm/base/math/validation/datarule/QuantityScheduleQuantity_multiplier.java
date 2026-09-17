package cdm.base.math.validation.datarule;

import cdm.base.math.Measure;
import cdm.base.math.QuantitySchedule;
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
@RosettaDataRule("QuantityScheduleQuantity_multiplier")
@ImplementedBy(QuantityScheduleQuantity_multiplier.Default.class)
public interface QuantityScheduleQuantity_multiplier extends Validator<QuantitySchedule> {
	
	String NAME = "QuantityScheduleQuantity_multiplier";
	String DEFINITION = "if multiplier exists then multiplier -> value >= 0.0";
	
	class Default implements QuantityScheduleQuantity_multiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantitySchedule quantitySchedule) {
			ComparisonResult result = executeDataRule(quantitySchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "QuantitySchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "QuantitySchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(QuantitySchedule quantitySchedule) {
			try {
				if (exists(MapperS.of(quantitySchedule).<Measure>map("getMultiplier", _quantitySchedule -> _quantitySchedule.getMultiplier())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(quantitySchedule).<Measure>map("getMultiplier", _quantitySchedule -> _quantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuantityScheduleQuantity_multiplier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantitySchedule quantitySchedule) {
			return Collections.emptyList();
		}
	}
}
