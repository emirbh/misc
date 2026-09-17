package fpml.consolidated.eqd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityAmericanExercise;
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
@RosettaDataRule("EquityAmericanExerciseChoice")
@ImplementedBy(EquityAmericanExerciseChoice.Default.class)
public interface EquityAmericanExerciseChoice extends Validator<EquityAmericanExercise> {
	
	String NAME = "EquityAmericanExerciseChoice";
	String DEFINITION = "expirationTimeDetermination is absent or equityExpirationTimeType is absent and equityExpirationTime is absent";
	
	class Default implements EquityAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAmericanExercise equityAmericanExercise) {
			ComparisonResult result = executeDataRule(equityAmericanExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityAmericanExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityAmericanExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityAmericanExercise equityAmericanExercise) {
			try {
				return notExists(MapperS.of(equityAmericanExercise).<DeterminationMethod>map("getExpirationTimeDetermination", _equityAmericanExercise -> _equityAmericanExercise.getExpirationTimeDetermination())).orNullSafe(notExists(MapperS.of(equityAmericanExercise).<TimeTypeEnum>map("getEquityExpirationTimeType", _equityAmericanExercise -> _equityAmericanExercise.getEquityExpirationTimeType())).andNullSafe(notExists(MapperS.of(equityAmericanExercise).<BusinessCenterTime>map("getEquityExpirationTime", _equityAmericanExercise -> _equityAmericanExercise.getEquityExpirationTime()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityAmericanExerciseChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityAmericanExercise equityAmericanExercise) {
			return Collections.emptyList();
		}
	}
}
