package cdm.legaldocumentation.master.validation.datarule;

import cdm.legaldocumentation.master.MasterAgreementElections;
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
@RosettaDataRule("MasterAgreementElectionsOneOf0")
@ImplementedBy(MasterAgreementElectionsOneOf0.Default.class)
public interface MasterAgreementElectionsOneOf0 extends Validator<MasterAgreementElections> {
	
	String NAME = "MasterAgreementElectionsOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements MasterAgreementElectionsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementElections masterAgreementElections) {
			ComparisonResult result = executeDataRule(masterAgreementElections);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MasterAgreementElections", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MasterAgreementElections", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MasterAgreementElections masterAgreementElections) {
			try {
				return choice(MapperS.of(masterAgreementElections), Arrays.asList("islaGmsla", "icmaGmra", "isdaMaster"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MasterAgreementElectionsOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementElections masterAgreementElections) {
			return Collections.emptyList();
		}
	}
}
