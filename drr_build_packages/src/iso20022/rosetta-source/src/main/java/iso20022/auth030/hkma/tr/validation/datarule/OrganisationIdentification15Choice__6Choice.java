package iso20022.auth030.hkma.tr.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__6;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OrganisationIdentification15Choice__6Choice")
@ImplementedBy(OrganisationIdentification15Choice__6Choice.Default.class)
public interface OrganisationIdentification15Choice__6Choice extends Validator<OrganisationIdentification15Choice__6> {
	
	String NAME = "OrganisationIdentification15Choice__6Choice";
	String DEFINITION = "one-of";
	
	class Default implements OrganisationIdentification15Choice__6Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice__6 organisationIdentification15Choice__6) {
			ComparisonResult result = executeDataRule(organisationIdentification15Choice__6);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OrganisationIdentification15Choice__6", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OrganisationIdentification15Choice__6", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OrganisationIdentification15Choice__6 organisationIdentification15Choice__6) {
			try {
				return choice(MapperS.of(organisationIdentification15Choice__6), Arrays.asList("lei", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OrganisationIdentification15Choice__6Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice__6 organisationIdentification15Choice__6) {
			return Collections.emptyList();
		}
	}
}
