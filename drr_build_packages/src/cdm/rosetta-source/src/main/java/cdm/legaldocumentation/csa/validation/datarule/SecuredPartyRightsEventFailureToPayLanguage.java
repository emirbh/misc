package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("SecuredPartyRightsEventFailureToPayLanguage")
@ImplementedBy(SecuredPartyRightsEventFailureToPayLanguage.Default.class)
public interface SecuredPartyRightsEventFailureToPayLanguage extends Validator<SecuredPartyRightsEvent> {
	
	String NAME = "SecuredPartyRightsEventFailureToPayLanguage";
	String DEFINITION = "if earlyTerminationDateOptionalLanguage = False then failureToPayEarlyTermination is absent";
	
	class Default implements SecuredPartyRightsEventFailureToPayLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuredPartyRightsEvent securedPartyRightsEvent) {
			ComparisonResult result = executeDataRule(securedPartyRightsEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecuredPartyRightsEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecuredPartyRightsEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecuredPartyRightsEvent securedPartyRightsEvent) {
			try {
				if (areEqual(MapperS.of(securedPartyRightsEvent).<Boolean>map("getEarlyTerminationDateOptionalLanguage", _securedPartyRightsEvent -> _securedPartyRightsEvent.getEarlyTerminationDateOptionalLanguage()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(securedPartyRightsEvent).<Boolean>map("getFailureToPayEarlyTermination", _securedPartyRightsEvent -> _securedPartyRightsEvent.getFailureToPayEarlyTermination()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecuredPartyRightsEventFailureToPayLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuredPartyRightsEvent securedPartyRightsEvent) {
			return Collections.emptyList();
		}
	}
}
