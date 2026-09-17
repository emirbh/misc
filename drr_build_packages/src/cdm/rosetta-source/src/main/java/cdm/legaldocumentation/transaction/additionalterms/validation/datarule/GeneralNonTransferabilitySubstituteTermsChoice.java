package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
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
@RosettaDataRule("GeneralNonTransferabilitySubstituteTermsChoice")
@ImplementedBy(GeneralNonTransferabilitySubstituteTermsChoice.Default.class)
public interface GeneralNonTransferabilitySubstituteTermsChoice extends Validator<GeneralNonTransferability> {
	
	String NAME = "GeneralNonTransferabilitySubstituteTermsChoice";
	String DEFINITION = "if localSubstituteProvisionType exists then nonDeliverableSubstitute is absent or if nonDeliverableSubstitute exists then localSubstituteProvisionType is absent";
	
	class Default implements GeneralNonTransferabilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralNonTransferability generalNonTransferability) {
			ComparisonResult result = executeDataRule(generalNonTransferability);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralNonTransferability", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralNonTransferability", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GeneralNonTransferability generalNonTransferability) {
			try {
				if (exists(MapperS.of(generalNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalNonTransferability -> _generalNonTransferability.getLocalSubstituteProvisionType())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(generalNonTransferability).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _generalNonTransferability -> _generalNonTransferability.getNonDeliverableSubstitute())).getOrDefault(false)) {
						ifThenElseResult = notExists(MapperS.of(generalNonTransferability).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalNonTransferability -> _generalNonTransferability.getLocalSubstituteProvisionType()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return notExists(MapperS.of(generalNonTransferability).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _generalNonTransferability -> _generalNonTransferability.getNonDeliverableSubstitute())).orNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralNonTransferabilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralNonTransferability generalNonTransferability) {
			return Collections.emptyList();
		}
	}
}
