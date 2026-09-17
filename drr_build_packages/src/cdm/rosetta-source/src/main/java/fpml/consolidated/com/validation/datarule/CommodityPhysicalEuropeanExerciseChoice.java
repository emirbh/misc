package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityPhysicalEuropeanExerciseChoice")
@ImplementedBy(CommodityPhysicalEuropeanExerciseChoice.Default.class)
public interface CommodityPhysicalEuropeanExerciseChoice extends Validator<CommodityPhysicalEuropeanExercise> {
	
	String NAME = "CommodityPhysicalEuropeanExerciseChoice";
	String DEFINITION = "optional choice expirationDate, expirationDates, relativeExpirationDates";
	
	class Default implements CommodityPhysicalEuropeanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			ComparisonResult result = executeDataRule(commodityPhysicalEuropeanExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalEuropeanExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalEuropeanExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			try {
				return choice(MapperS.of(commodityPhysicalEuropeanExercise), Arrays.asList("expirationDate", "expirationDates", "relativeExpirationDates"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalEuropeanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			return Collections.emptyList();
		}
	}
}
