package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
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
@RosettaDataRule("AppropriatedCollateralValuationSpecified")
@ImplementedBy(AppropriatedCollateralValuationSpecified.Default.class)
public interface AppropriatedCollateralValuationSpecified extends Validator<AppropriatedCollateralValuation> {
	
	String NAME = "AppropriatedCollateralValuationSpecified";
	String DEFINITION = "if isSpecified = True then election exists";
	
	class Default implements AppropriatedCollateralValuationSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AppropriatedCollateralValuation appropriatedCollateralValuation) {
			ComparisonResult result = executeDataRule(appropriatedCollateralValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AppropriatedCollateralValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AppropriatedCollateralValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AppropriatedCollateralValuation appropriatedCollateralValuation) {
			try {
				if (areEqual(MapperS.of(appropriatedCollateralValuation).<Boolean>map("getIsSpecified", _appropriatedCollateralValuation -> _appropriatedCollateralValuation.getIsSpecified()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(appropriatedCollateralValuation).<String>map("getElection", _appropriatedCollateralValuation -> _appropriatedCollateralValuation.getElection()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AppropriatedCollateralValuationSpecified {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AppropriatedCollateralValuation appropriatedCollateralValuation) {
			return Collections.emptyList();
		}
	}
}
