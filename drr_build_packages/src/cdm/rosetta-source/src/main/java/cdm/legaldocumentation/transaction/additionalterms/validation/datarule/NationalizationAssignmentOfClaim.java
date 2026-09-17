package cdm.legaldocumentation.transaction.additionalterms.validation.datarule;

import cdm.legaldocumentation.transaction.additionalterms.Nationalization;
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
@RosettaDataRule("NationalizationAssignmentOfClaim")
@ImplementedBy(NationalizationAssignmentOfClaim.Default.class)
public interface NationalizationAssignmentOfClaim extends Validator<Nationalization> {
	
	String NAME = "NationalizationAssignmentOfClaim";
	String DEFINITION = "if nationalizationIsApplicable = False then assignmentOfClaim is absent";
	
	class Default implements NationalizationAssignmentOfClaim {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Nationalization nationalization) {
			ComparisonResult result = executeDataRule(nationalization);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Nationalization", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Nationalization", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Nationalization nationalization) {
			try {
				if (areEqual(MapperS.of(nationalization).<Boolean>map("getNationalizationIsApplicable", _nationalization -> _nationalization.getNationalizationIsApplicable()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(nationalization).<Boolean>map("getAssignmentOfClaim", _nationalization -> _nationalization.getAssignmentOfClaim()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NationalizationAssignmentOfClaim {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Nationalization nationalization) {
			return Collections.emptyList();
		}
	}
}
