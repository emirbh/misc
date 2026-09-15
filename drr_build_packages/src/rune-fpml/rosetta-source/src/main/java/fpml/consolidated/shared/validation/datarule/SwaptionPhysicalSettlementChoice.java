package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SwaptionPhysicalSettlementChoice")
@ImplementedBy(SwaptionPhysicalSettlementChoice.Default.class)
public interface SwaptionPhysicalSettlementChoice extends Validator<SwaptionPhysicalSettlement> {
	
	String NAME = "SwaptionPhysicalSettlementChoice";
	String DEFINITION = "optional choice predeterminedClearingOrganizationPartyReference, mutuallyAgreedClearinghouse";
	
	class Default implements SwaptionPhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionPhysicalSettlement swaptionPhysicalSettlement) {
			ComparisonResult result = executeDataRule(swaptionPhysicalSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SwaptionPhysicalSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SwaptionPhysicalSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SwaptionPhysicalSettlement swaptionPhysicalSettlement) {
			try {
				return choice(MapperS.of(swaptionPhysicalSettlement), Arrays.asList("predeterminedClearingOrganizationPartyReference", "mutuallyAgreedClearinghouse"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SwaptionPhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionPhysicalSettlement swaptionPhysicalSettlement) {
			return Collections.emptyList();
		}
	}
}
