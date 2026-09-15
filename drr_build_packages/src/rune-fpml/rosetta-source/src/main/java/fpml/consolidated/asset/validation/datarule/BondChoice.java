package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Bond;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BondChoice")
@ImplementedBy(BondChoice.Default.class)
public interface BondChoice extends Validator<Bond> {
	
	String NAME = "BondChoice";
	String DEFINITION = "optional choice issuerName, issuerPartyReference";
	
	class Default implements BondChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Bond bond) {
			ComparisonResult result = executeDataRule(bond);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Bond", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Bond", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Bond bond) {
			try {
				return choice(MapperS.of(bond), Arrays.asList("issuerName", "issuerPartyReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Bond bond) {
			return Collections.emptyList();
		}
	}
}
