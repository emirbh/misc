package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AdditionalRightsEvent;
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
@RosettaDataRule("AdditionalRightsEventQualification")
@ImplementedBy(AdditionalRightsEventQualification.Default.class)
public interface AdditionalRightsEventQualification extends Validator<AdditionalRightsEvent> {
	
	String NAME = "AdditionalRightsEventQualification";
	String DEFINITION = "if qualification exists then isApplicable = True";
	
	class Default implements AdditionalRightsEventQualification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRightsEvent additionalRightsEvent) {
			ComparisonResult result = executeDataRule(additionalRightsEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalRightsEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalRightsEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdditionalRightsEvent additionalRightsEvent) {
			try {
				if (exists(MapperS.of(additionalRightsEvent).<String>map("getQualification", _additionalRightsEvent -> _additionalRightsEvent.getQualification())).getOrDefault(false)) {
					return areEqual(MapperS.of(additionalRightsEvent).<Boolean>map("getIsApplicable", _additionalRightsEvent -> _additionalRightsEvent.getIsApplicable()), MapperS.of(true), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdditionalRightsEventQualification {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRightsEvent additionalRightsEvent) {
			return Collections.emptyList();
		}
	}
}
