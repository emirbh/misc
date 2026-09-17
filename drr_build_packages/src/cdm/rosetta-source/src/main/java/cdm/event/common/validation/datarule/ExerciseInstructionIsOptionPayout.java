package cdm.event.common.validation.datarule;

import cdm.event.common.ExerciseInstruction;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
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
@RosettaDataRule("ExerciseInstructionIsOptionPayout")
@ImplementedBy(ExerciseInstructionIsOptionPayout.Default.class)
public interface ExerciseInstructionIsOptionPayout extends Validator<ExerciseInstruction> {
	
	String NAME = "ExerciseInstructionIsOptionPayout";
	String DEFINITION = "if exerciseOption exists then exerciseOption switch OptionPayout then item exists, default False";
	
	class Default implements ExerciseInstructionIsOptionPayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseInstruction exerciseInstruction) {
			ComparisonResult result = executeDataRule(exerciseInstruction);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseInstruction", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseInstruction", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseInstruction exerciseInstruction) {
			try {
				if (exists(MapperS.of(exerciseInstruction).<ReferenceWithMetaPayout>map("getExerciseOption", _exerciseInstruction -> _exerciseInstruction.getExerciseOption())).getOrDefault(false)) {
					final MapperS<Payout> switchArgument = MapperS.of(exerciseInstruction).<ReferenceWithMetaPayout>map("getExerciseOption", _exerciseInstruction -> _exerciseInstruction.getExerciseOption()).<Payout>map("Type coercion", referenceWithMetaPayout -> referenceWithMetaPayout == null ? null : referenceWithMetaPayout.getValue());
					if (switchArgument.get() == null) {
						return ComparisonResult.ofEmpty();
					}
					if (switchArgument.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get() != null) {
						final MapperS<OptionPayout> optionPayout = switchArgument.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
						return exists(optionPayout);
					}
					return ComparisonResult.ofNullSafe(MapperS.of(false));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseInstructionIsOptionPayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseInstruction exerciseInstruction) {
			return Collections.emptyList();
		}
	}
}
