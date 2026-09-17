package cdm.product.template.validation.datarule;

import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.MandatoryEarlyTermination;
import cdm.product.template.OptionalEarlyTermination;
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
@RosettaDataRule("EarlyTerminationProvisionMandatoryEarlyTermination")
@ImplementedBy(EarlyTerminationProvisionMandatoryEarlyTermination.Default.class)
public interface EarlyTerminationProvisionMandatoryEarlyTermination extends Validator<EarlyTerminationProvision> {
	
	String NAME = "EarlyTerminationProvisionMandatoryEarlyTermination";
	String DEFINITION = "(mandatoryEarlyTermination exists or optionalEarlyTermination exists) or (mandatoryEarlyTermination exists and optionalEarlyTermination exists)";
	
	class Default implements EarlyTerminationProvisionMandatoryEarlyTermination {
	
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
				return exists(MapperS.of(earlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination())).orNullSafe(exists(MapperS.of(earlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination()))).orNullSafe(exists(MapperS.of(earlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination())).andNullSafe(exists(MapperS.of(earlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EarlyTerminationProvisionMandatoryEarlyTermination {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
			return Collections.emptyList();
		}
	}
}
