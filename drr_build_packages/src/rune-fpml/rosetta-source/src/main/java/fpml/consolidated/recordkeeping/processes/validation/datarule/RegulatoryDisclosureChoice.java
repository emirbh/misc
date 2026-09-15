package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryDisclosure;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RegulatoryDisclosureChoice")
@ImplementedBy(RegulatoryDisclosureChoice.Default.class)
public interface RegulatoryDisclosureChoice extends Validator<RegulatoryDisclosure> {
	
	String NAME = "RegulatoryDisclosureChoice";
	String DEFINITION = "optional choice changeInNotional, changeInNumberOfOptions, changeInQuantity";
	
	class Default implements RegulatoryDisclosureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryDisclosure regulatoryDisclosure) {
			ComparisonResult result = executeDataRule(regulatoryDisclosure);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryDisclosure", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryDisclosure", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RegulatoryDisclosure regulatoryDisclosure) {
			try {
				return choice(MapperS.of(regulatoryDisclosure), Arrays.asList("changeInNotional", "changeInNumberOfOptions", "changeInQuantity"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RegulatoryDisclosureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryDisclosure regulatoryDisclosure) {
			return Collections.emptyList();
		}
	}
}
