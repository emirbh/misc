package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityPhysicalAmericanExerciseChoice")
@ImplementedBy(CommodityPhysicalAmericanExerciseChoice.Default.class)
public interface CommodityPhysicalAmericanExerciseChoice extends Validator<CommodityPhysicalAmericanExercise> {
	
	String NAME = "CommodityPhysicalAmericanExerciseChoice";
	String DEFINITION = "relativeCommencementDates is absent and relativeExpirationDates is absent or commencementDates is absent and expirationDates is absent";
	
	class Default implements CommodityPhysicalAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			ComparisonResult result = executeDataRule(commodityPhysicalAmericanExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalAmericanExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalAmericanExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			try {
				return notExists(MapperS.of(commodityPhysicalAmericanExercise).<CommodityRelativeExpirationDates>map("getRelativeCommencementDates", _commodityPhysicalAmericanExercise -> _commodityPhysicalAmericanExercise.getRelativeCommencementDates())).andNullSafe(notExists(MapperS.of(commodityPhysicalAmericanExercise).<CommodityRelativeExpirationDates>map("getRelativeExpirationDates", _commodityPhysicalAmericanExercise -> _commodityPhysicalAmericanExercise.getRelativeExpirationDates()))).orNullSafe(notExists(MapperS.of(commodityPhysicalAmericanExercise).<AdjustableOrRelativeDates>map("getCommencementDates", _commodityPhysicalAmericanExercise -> _commodityPhysicalAmericanExercise.getCommencementDates())).andNullSafe(notExists(MapperS.of(commodityPhysicalAmericanExercise).<AdjustableOrRelativeDates>map("getExpirationDates", _commodityPhysicalAmericanExercise -> _commodityPhysicalAmericanExercise.getExpirationDates()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			return Collections.emptyList();
		}
	}
}
