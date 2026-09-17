package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralInconvertibility;
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
@RosettaDataRule("GeneralInconvertibilitySubstituteTermsChoice")
@ImplementedBy(GeneralInconvertibilitySubstituteTermsChoice.Default.class)
public interface GeneralInconvertibilitySubstituteTermsChoice extends Validator<GeneralInconvertibility> {
	
	String NAME = "GeneralInconvertibilitySubstituteTermsChoice";
	String DEFINITION = "if localSubstituteProvisionType exists then nonDeliverableSubstitute is absent or if nonDeliverableSubstitute exists then localSubstituteProvisionType is absent";
	
	class Default implements GeneralInconvertibilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralInconvertibility generalInconvertibility) {
			ComparisonResult result = executeDataRule(generalInconvertibility);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralInconvertibility", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralInconvertibility", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GeneralInconvertibility generalInconvertibility) {
			try {
				if (exists(MapperS.of(generalInconvertibility).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalInconvertibility -> _generalInconvertibility.getLocalSubstituteProvisionType())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (exists(MapperS.of(generalInconvertibility).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _generalInconvertibility -> _generalInconvertibility.getNonDeliverableSubstitute())).getOrDefault(false)) {
						ifThenElseResult = notExists(MapperS.of(generalInconvertibility).<FxSubstitutionProvisionTypeEnum>map("getLocalSubstituteProvisionType", _generalInconvertibility -> _generalInconvertibility.getLocalSubstituteProvisionType()));
					} else {
						ifThenElseResult = ComparisonResult.ofEmpty();
					}
					return notExists(MapperS.of(generalInconvertibility).<NonDeliverableSubstitute>map("getNonDeliverableSubstitute", _generalInconvertibility -> _generalInconvertibility.getNonDeliverableSubstitute())).orNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GeneralInconvertibilitySubstituteTermsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralInconvertibility generalInconvertibility) {
			return Collections.emptyList();
		}
	}
}
