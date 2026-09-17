package cdm.base.math.validation.datarule;

import cdm.base.math.Measure;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("MeasureValueExists")
@ImplementedBy(MeasureValueExists.Default.class)
public interface MeasureValueExists extends Validator<Measure> {
	
	String NAME = "MeasureValueExists";
	String DEFINITION = "value exists";
	
	class Default implements MeasureValueExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Measure measure) {
			ComparisonResult result = executeDataRule(measure);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Measure", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Measure", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Measure measure) {
			try {
				return exists(MapperS.of(measure).<BigDecimal>map("getValue", _measure -> _measure.getValue()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MeasureValueExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Measure measure) {
			return Collections.emptyList();
		}
	}
}
