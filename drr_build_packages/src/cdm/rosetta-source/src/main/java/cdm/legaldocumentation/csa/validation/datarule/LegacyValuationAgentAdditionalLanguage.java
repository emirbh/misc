package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyValuationAgent;
import cdm.legaldocumentation.csa.ValuationAgentPartyEnum;
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
@RosettaDataRule("LegacyValuationAgentAdditionalLanguage")
@ImplementedBy(LegacyValuationAgentAdditionalLanguage.Default.class)
public interface LegacyValuationAgentAdditionalLanguage extends Validator<LegacyValuationAgent> {
	
	String NAME = "LegacyValuationAgentAdditionalLanguage";
	String DEFINITION = "if party is absent then additionalLanguage exists";
	
	class Default implements LegacyValuationAgentAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationAgent legacyValuationAgent) {
			ComparisonResult result = executeDataRule(legacyValuationAgent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationAgent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationAgent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyValuationAgent legacyValuationAgent) {
			try {
				if (notExists(MapperS.of(legacyValuationAgent).<ValuationAgentPartyEnum>map("getParty", _legacyValuationAgent -> _legacyValuationAgent.getParty())).getOrDefault(false)) {
					return exists(MapperS.of(legacyValuationAgent).<String>map("getAdditionalLanguage", _legacyValuationAgent -> _legacyValuationAgent.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyValuationAgentAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationAgent legacyValuationAgent) {
			return Collections.emptyList();
		}
	}
}
