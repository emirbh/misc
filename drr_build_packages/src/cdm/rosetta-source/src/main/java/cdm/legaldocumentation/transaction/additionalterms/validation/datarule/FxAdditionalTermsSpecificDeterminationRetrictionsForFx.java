package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.DeterminationRoleEnum;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
import cdm.legaldocumentation.transaction.additionalterms.FxAdditionalTerms;
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
@RosettaDataRule("FxAdditionalTermsSpecificDeterminationRetrictionsForFx")
@ImplementedBy(FxAdditionalTermsSpecificDeterminationRetrictionsForFx.Default.class)
public interface FxAdditionalTermsSpecificDeterminationRetrictionsForFx extends Validator<FxAdditionalTerms> {
	
	String NAME = "FxAdditionalTermsSpecificDeterminationRetrictionsForFx";
	String DEFINITION = "determinationTerms -> determinationRole = DeterminationRoleEnum -> CalculationAgent";
	
	class Default implements FxAdditionalTermsSpecificDeterminationRetrictionsForFx {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdditionalTerms fxAdditionalTerms) {
			ComparisonResult result = executeDataRule(fxAdditionalTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAdditionalTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAdditionalTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAdditionalTerms fxAdditionalTerms) {
			try {
				return areEqual(MapperS.of(fxAdditionalTerms).<DeterminationRolesAndTerms>map("getDeterminationTerms", _fxAdditionalTerms -> _fxAdditionalTerms.getDeterminationTerms()).<DeterminationRoleEnum>map("getDeterminationRole", determinationRolesAndTerms -> determinationRolesAndTerms.getDeterminationRole()), MapperS.of(DeterminationRoleEnum.CALCULATION_AGENT), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAdditionalTermsSpecificDeterminationRetrictionsForFx {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdditionalTerms fxAdditionalTerms) {
			return Collections.emptyList();
		}
	}
}
