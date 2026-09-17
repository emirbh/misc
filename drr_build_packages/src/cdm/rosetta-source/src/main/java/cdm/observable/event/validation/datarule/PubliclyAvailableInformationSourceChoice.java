package cdm.observable.event.validation.datarule;

import cdm.observable.event.PubliclyAvailableInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PubliclyAvailableInformationSourceChoice")
@ImplementedBy(PubliclyAvailableInformationSourceChoice.Default.class)
public interface PubliclyAvailableInformationSourceChoice extends Validator<PubliclyAvailableInformation> {
	
	String NAME = "PubliclyAvailableInformationSourceChoice";
	String DEFINITION = "required choice standardPublicSources, publicSource";
	
	class Default implements PubliclyAvailableInformationSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation publiclyAvailableInformation) {
			ComparisonResult result = executeDataRule(publiclyAvailableInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PubliclyAvailableInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PubliclyAvailableInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PubliclyAvailableInformation publiclyAvailableInformation) {
			try {
				return choice(MapperS.of(publiclyAvailableInformation), Arrays.asList("standardPublicSources", "publicSource"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PubliclyAvailableInformationSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation publiclyAvailableInformation) {
			return Collections.emptyList();
		}
	}
}
