package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityEuropeanExercise;
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
@RosettaDataRule("EquityEuropeanExerciseChoice")
@ImplementedBy(EquityEuropeanExerciseChoice.Default.class)
public interface EquityEuropeanExerciseChoice extends Validator<EquityEuropeanExercise> {
	
	String NAME = "EquityEuropeanExerciseChoice";
	String DEFINITION = "expirationTimeDetermination is absent or equityExpirationTimeType is absent and equityExpirationTime is absent";
	
	class Default implements EquityEuropeanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityEuropeanExercise equityEuropeanExercise) {
			ComparisonResult result = executeDataRule(equityEuropeanExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityEuropeanExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityEuropeanExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityEuropeanExercise equityEuropeanExercise) {
			try {
				return notExists(MapperS.of(equityEuropeanExercise).<DeterminationMethod>map("getExpirationTimeDetermination", _equityEuropeanExercise -> _equityEuropeanExercise.getExpirationTimeDetermination())).orNullSafe(notExists(MapperS.of(equityEuropeanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", _equityEuropeanExercise -> _equityEuropeanExercise.getEquityExpirationTimeType())).andNullSafe(notExists(MapperS.of(equityEuropeanExercise).<BusinessCenterTime>map("getEquityExpirationTime", _equityEuropeanExercise -> _equityEuropeanExercise.getEquityExpirationTime()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityEuropeanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityEuropeanExercise equityEuropeanExercise) {
			return Collections.emptyList();
		}
	}
}
