package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExercisePeriod;
import fpml.consolidated.ird.MandatoryEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.shared.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EarlyTerminationProvisionChoice")
@ImplementedBy(EarlyTerminationProvisionChoice.Default.class)
public interface EarlyTerminationProvisionChoice extends Validator<EarlyTerminationProvision> {
	
	String NAME = "EarlyTerminationProvisionChoice";
	String DEFINITION = "if mandatoryEarlyTerminationDateTenor exists then True else if mandatoryEarlyTermination exists then True else optionalEarlyTerminationParameters exists or optionalEarlyTermination exists";
	
	class Default implements EarlyTerminationProvisionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
			ComparisonResult result = executeDataRule(earlyTerminationProvision);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EarlyTerminationProvision earlyTerminationProvision) {
			try {
				if (exists(MapperS.of(earlyTerminationProvision).<Period>map("getMandatoryEarlyTerminationDateTenor", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTerminationDateTenor())).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				if (exists(MapperS.of(earlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination())).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return exists(MapperS.of(earlyTerminationProvision).<ExercisePeriod>map("getOptionalEarlyTerminationParameters", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTerminationParameters())).orNullSafe(exists(MapperS.of(earlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EarlyTerminationProvisionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
			return Collections.emptyList();
		}
	}
}
