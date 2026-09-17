package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDigitalExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityDigitalExerciseChoice1")
@ImplementedBy(CommodityDigitalExerciseChoice1.Default.class)
public interface CommodityDigitalExerciseChoice1 extends Validator<CommodityDigitalExercise> {
	
	String NAME = "CommodityDigitalExerciseChoice1";
	String DEFINITION = "optional choice americanExercise, europeanExercise";
	
	class Default implements CommodityDigitalExerciseChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalExercise commodityDigitalExercise) {
			ComparisonResult result = executeDataRule(commodityDigitalExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityDigitalExercise commodityDigitalExercise) {
			try {
				return choice(MapperS.of(commodityDigitalExercise), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDigitalExerciseChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalExercise commodityDigitalExercise) {
			return Collections.emptyList();
		}
	}
}
