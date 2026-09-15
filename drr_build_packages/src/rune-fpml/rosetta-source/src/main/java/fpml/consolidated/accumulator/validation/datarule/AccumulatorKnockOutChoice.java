package fpml.consolidated.accumulator.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.AccumulatorKnockOut;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AccumulatorKnockOutChoice")
@ImplementedBy(AccumulatorKnockOutChoice.Default.class)
public interface AccumulatorKnockOutChoice extends Validator<AccumulatorKnockOut> {
	
	String NAME = "AccumulatorKnockOutChoice";
	String DEFINITION = "targetPerformance exists or level exists";
	
	class Default implements AccumulatorKnockOutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccumulatorKnockOut accumulatorKnockOut) {
			ComparisonResult result = executeDataRule(accumulatorKnockOut);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccumulatorKnockOut", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AccumulatorKnockOut", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AccumulatorKnockOut accumulatorKnockOut) {
			try {
				return exists(MapperS.of(accumulatorKnockOut).<BigDecimal>map("getTargetPerformance", _accumulatorKnockOut -> _accumulatorKnockOut.getTargetPerformance())).orNullSafe(exists(MapperS.of(accumulatorKnockOut).<BigDecimal>map("getLevel", _accumulatorKnockOut -> _accumulatorKnockOut.getLevel())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AccumulatorKnockOutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccumulatorKnockOut accumulatorKnockOut) {
			return Collections.emptyList();
		}
	}
}
