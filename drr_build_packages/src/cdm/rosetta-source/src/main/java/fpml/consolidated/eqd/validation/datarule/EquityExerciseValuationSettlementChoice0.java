package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityExerciseValuationSettlementChoice0")
@ImplementedBy(EquityExerciseValuationSettlementChoice0.Default.class)
public interface EquityExerciseValuationSettlementChoice0 extends Validator<EquityExerciseValuationSettlement> {
	
	String NAME = "EquityExerciseValuationSettlementChoice0";
	String DEFINITION = "optional choice equityEuropeanExercise, equityAmericanExercise, equityBermudaExercise";
	
	class Default implements EquityExerciseValuationSettlementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			ComparisonResult result = executeDataRule(equityExerciseValuationSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			try {
				return choice(MapperS.of(equityExerciseValuationSettlement), Arrays.asList("equityEuropeanExercise", "equityAmericanExercise", "equityBermudaExercise"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityExerciseValuationSettlementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			return Collections.emptyList();
		}
	}
}
