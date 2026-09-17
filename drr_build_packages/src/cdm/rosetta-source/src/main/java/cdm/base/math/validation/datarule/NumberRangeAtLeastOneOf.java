package cdm.base.math.validation.datarule;

import cdm.base.math.NumberBound;
import cdm.base.math.NumberRange;
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
@RosettaDataRule("NumberRangeAtLeastOneOf")
@ImplementedBy(NumberRangeAtLeastOneOf.Default.class)
public interface NumberRangeAtLeastOneOf extends Validator<NumberRange> {
	
	String NAME = "NumberRangeAtLeastOneOf";
	String DEFINITION = "lowerBound exists or upperBound exists";
	
	class Default implements NumberRangeAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberRange numberRange) {
			ComparisonResult result = executeDataRule(numberRange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NumberRange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NumberRange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NumberRange numberRange) {
			try {
				return exists(MapperS.of(numberRange).<NumberBound>map("getLowerBound", _numberRange -> _numberRange.getLowerBound())).orNullSafe(exists(MapperS.of(numberRange).<NumberBound>map("getUpperBound", _numberRange -> _numberRange.getUpperBound())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NumberRangeAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberRange numberRange) {
			return Collections.emptyList();
		}
	}
}
