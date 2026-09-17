package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
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
@RosettaDataRule("DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole")
@ImplementedBy(DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole.Default.class)
public interface DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole extends Validator<DeterminationRolesAndTerms> {
	
	String NAME = "DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole";
	String DEFINITION = "whoToDetermine all <> disputingParty";
	
	class Default implements DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeterminationRolesAndTerms determinationRolesAndTerms) {
			ComparisonResult result = executeDataRule(determinationRolesAndTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeterminationRolesAndTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DeterminationRolesAndTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DeterminationRolesAndTerms determinationRolesAndTerms) {
			try {
				return notEqual(MapperS.of(determinationRolesAndTerms).<CounterpartyRoleEnum>mapC("getWhoToDetermine", _determinationRolesAndTerms -> _determinationRolesAndTerms.getWhoToDetermine()), MapperS.of(determinationRolesAndTerms).<CounterpartyRoleEnum>map("getDisputingParty", _determinationRolesAndTerms -> _determinationRolesAndTerms.getDisputingParty()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeterminationRolesAndTerms determinationRolesAndTerms) {
			return Collections.emptyList();
		}
	}
}
