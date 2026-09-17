package cdm.product.asset.validation.datarule;

import cdm.product.asset.BasketReferenceInformation;
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
@RosettaDataRule("BasketReferenceInformationMthToDefault")
@ImplementedBy(BasketReferenceInformationMthToDefault.Default.class)
public interface BasketReferenceInformationMthToDefault extends Validator<BasketReferenceInformation> {
	
	String NAME = "BasketReferenceInformationMthToDefault";
	String DEFINITION = "if (nthToDefault exists and mthToDefault exists) then nthToDefault < mthToDefault";
	
	class Default implements BasketReferenceInformationMthToDefault {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			ComparisonResult result = executeDataRule(basketReferenceInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BasketReferenceInformation basketReferenceInformation) {
			try {
				if (exists(MapperS.of(basketReferenceInformation).<Integer>map("getNthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getNthToDefault())).andNullSafe(exists(MapperS.of(basketReferenceInformation).<Integer>map("getMthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getMthToDefault()))).getOrDefault(false)) {
					return lessThan(MapperS.of(basketReferenceInformation).<Integer>map("getNthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getNthToDefault()), MapperS.of(basketReferenceInformation).<Integer>map("getMthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getMthToDefault()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketReferenceInformationMthToDefault {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			return Collections.emptyList();
		}
	}
}
