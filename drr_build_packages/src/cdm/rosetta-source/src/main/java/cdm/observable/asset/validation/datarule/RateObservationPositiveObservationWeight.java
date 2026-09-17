package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.RateObservation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("RateObservationPositiveObservationWeight")
@ImplementedBy(RateObservationPositiveObservationWeight.Default.class)
public interface RateObservationPositiveObservationWeight extends Validator<RateObservation> {
	
	String NAME = "RateObservationPositiveObservationWeight";
	String DEFINITION = "if observationWeight exists then observationWeight >= 0";
	
	class Default implements RateObservationPositiveObservationWeight {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateObservation rateObservation) {
			ComparisonResult result = executeDataRule(rateObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RateObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RateObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RateObservation rateObservation) {
			try {
				if (exists(MapperS.of(rateObservation).<Integer>map("getObservationWeight", _rateObservation -> _rateObservation.getObservationWeight())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(rateObservation).<Integer>map("getObservationWeight", _rateObservation -> _rateObservation.getObservationWeight()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RateObservationPositiveObservationWeight {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateObservation rateObservation) {
			return Collections.emptyList();
		}
	}
}
