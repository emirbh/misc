package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
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
@RosettaDataRule("SpecificNonTransferabilitySubstituteTermsChoice")
@ImplementedBy(SpecificNonTransferabilitySubstituteTermsChoice.Default.class)
public interface SpecificNonTransferabilitySubstituteTermsChoice extends Validator<SpecificNonTransferability> {
	
	String NAME = "SpecificNonTransferabilitySubstituteTermsChoice";
	String DEFINITION = "if localSubstituteProvisionType exists then nonDeliverableSubstitute is absent or if nonDeliverableSubstitute exists then localSubstituteProvisionType is absent";
	
	class Default implements SpecificNonTransferabilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificNonTransferability specificNonTransferability) {
			ComparisonResult result = executeDataRule(specificNonTransferability);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificNonTransferability", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecificNonTransferability", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SpecificNonTransferability specificNonTransferability) {
			try {
				if (exists(MapperS.of(specificNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _specificNonTransferability -> _specificNonTransferability.getLocalSubstituteProvisionType())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(specificNonTransferability).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _specificNonTransferability -> _specificNonTransferability.getNonDeliverableSubstitute())).getOrDefault(false)) {
						ifThenElseResult = notExists(MapperS.of(specificNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _specificNonTransferability -> _specificNonTransferability.getLocalSubstituteProvisionType()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return notExists(MapperS.of(specificNonTransferability).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _specificNonTransferability -> _specificNonTransferability.getNonDeliverableSubstitute())).orNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SpecificNonTransferabilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificNonTransferability specificNonTransferability) {
			return Collections.emptyList();
		}
	}
}
