package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityBermudaExerciseChoice")
@ImplementedBy(EquityBermudaExerciseChoice.Default.class)
public interface EquityBermudaExerciseChoice extends Validator<EquityBermudaExercise> {
	
	String NAME = "EquityBermudaExerciseChoice";
	String DEFINITION = "expirationTimeDetermination is absent or equityExpirationTimeType is absent and equityExpirationTime is absent";
	
	class Default implements EquityBermudaExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityBermudaExercise equityBermudaExercise) {
			ComparisonResult result = executeDataRule(equityBermudaExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityBermudaExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityBermudaExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityBermudaExercise equityBermudaExercise) {
			try {
				return notExists(MapperS.of(equityBermudaExercise).<DeterminationMethod>map("getExpirationTimeDetermination", _equityBermudaExercise -> _equityBermudaExercise.getExpirationTimeDetermination())).orNullSafe(notExists(MapperS.of(equityBermudaExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", _equityBermudaExercise -> _equityBermudaExercise.getEquityExpirationTimeType())).andNullSafe(notExists(MapperS.of(equityBermudaExercise).<BusinessCenterTime>map("getEquityExpirationTime", _equityBermudaExercise -> _equityBermudaExercise.getEquityExpirationTime()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityBermudaExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityBermudaExercise equityBermudaExercise) {
			return Collections.emptyList();
		}
	}
}
