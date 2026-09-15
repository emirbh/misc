package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OrganisationIdentification15ChoiceChoice")
@ImplementedBy(OrganisationIdentification15ChoiceChoice.Default.class)
public interface OrganisationIdentification15ChoiceChoice extends Validator<OrganisationIdentification15Choice> {
	
	String NAME = "OrganisationIdentification15ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements OrganisationIdentification15ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice organisationIdentification15Choice) {
			ComparisonResult result = executeDataRule(organisationIdentification15Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OrganisationIdentification15Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OrganisationIdentification15Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OrganisationIdentification15Choice organisationIdentification15Choice) {
			try {
				return choice(MapperS.of(organisationIdentification15Choice), Arrays.asList("lei", "othr", "anyBIC"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OrganisationIdentification15ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice organisationIdentification15Choice) {
			return Collections.emptyList();
		}
	}
}
