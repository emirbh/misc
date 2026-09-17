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
@RosettaDataRule("SecurityProviderRightsEventRightsEvent_customElection")
@ImplementedBy(SecurityProviderRightsEventRightsEvent_customElection.Default.class)
public interface SecurityProviderRightsEventRightsEvent_customElection extends Validator<SecurityProviderRightsEvent> {
	
	String NAME = "SecurityProviderRightsEventRightsEvent_customElection";
	String DEFINITION = "if customElection exists then includeCoolingOffLanguage = False";
	
	class Default implements SecurityProviderRightsEventRightsEvent_customElection {
	
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
				if (exists(MapperS.of(securityProviderRightsEvent).<String>map("getCustomElection", _securityProviderRightsEvent -> _securityProviderRightsEvent.getCustomElection())).getOrDefault(false)) {
					return areEqual(MapperS.of(securityProviderRightsEvent).<Boolean>map("getIncludeCoolingOffLanguage", _securityProviderRightsEvent -> _securityProviderRightsEvent.getIncludeCoolingOffLanguage()), MapperS.of(false), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SecurityProviderRightsEventRightsEvent_customElection {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityProviderRightsEvent securityProviderRightsEvent) {
			return Collections.emptyList();
		}
	}
}
