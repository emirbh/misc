package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.OneWayProvisions;
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
@RosettaDataRule("OneWayProvisionsPostingPartyExists")
@ImplementedBy(OneWayProvisionsPostingPartyExists.Default.class)
public interface OneWayProvisionsPostingPartyExists extends Validator<OneWayProvisions> {
	
	String NAME = "OneWayProvisionsPostingPartyExists";
	String DEFINITION = "if isApplicable = True then postingParty exists";
	
	class Default implements OneWayProvisionsPostingPartyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OneWayProvisions oneWayProvisions) {
			ComparisonResult result = executeDataRule(oneWayProvisions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OneWayProvisions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OneWayProvisions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OneWayProvisions oneWayProvisions) {
			try {
				if (areEqual(MapperS.of(oneWayProvisions).<Boolean>map("getIsApplicable", _oneWayProvisions -> _oneWayProvisions.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(oneWayProvisions).<CounterpartyRoleEnum>map("getPostingParty", _oneWayProvisions -> _oneWayProvisions.getPostingParty()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OneWayProvisionsPostingPartyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OneWayProvisions oneWayProvisions) {
			return Collections.emptyList();
		}
	}
}
