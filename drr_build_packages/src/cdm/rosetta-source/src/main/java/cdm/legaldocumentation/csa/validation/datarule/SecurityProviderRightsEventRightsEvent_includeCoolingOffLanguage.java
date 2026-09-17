package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.SecurityProviderRightsEvent;
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
@RosettaDataRule("SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage")
@ImplementedBy(SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage.Default.class)
public interface SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage extends Validator<SecurityProviderRightsEvent> {
	
	String NAME = "SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage";
	String DEFINITION = "if includeCoolingOffLanguage = True then customElection is absent";
	
	class Default implements SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityProviderRightsEvent securityProviderRightsEvent) {
			ComparisonResult result = executeDataRule(securityProviderRightsEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityProviderRightsEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityProviderRightsEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SecurityProviderRightsEvent securityProviderRightsEvent) {
			try {
				if (areEqual(MapperS.of(securityProviderRightsEvent).<Boolean>map("getIncludeCoolingOffLanguage", _securityProviderRightsEvent -> _securityProviderRightsEvent.getIncludeCoolingOffLanguage()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(securityProviderRightsEvent).<String>map("getCustomElection", _securityProviderRightsEvent -> _securityProviderRightsEvent.getCustomElection()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityProviderRightsEvent securityProviderRightsEvent) {
			return Collections.emptyList();
		}
	}
}
