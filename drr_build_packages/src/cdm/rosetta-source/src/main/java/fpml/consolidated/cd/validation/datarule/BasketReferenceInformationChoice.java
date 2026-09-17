package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.BasketReferenceInformation;
import fpml.consolidated.cd.Tranche;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BasketReferenceInformationChoice")
@ImplementedBy(BasketReferenceInformationChoice.Default.class)
public interface BasketReferenceInformationChoice extends Validator<BasketReferenceInformation> {
	
	String NAME = "BasketReferenceInformationChoice";
	String DEFINITION = "nthToDefault is absent and mthToDefault is absent or tranche is absent";
	
	class Default implements BasketReferenceInformationChoice {
	
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
				return notExists(MapperS.of(basketReferenceInformation).<Integer>map("getNthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getNthToDefault())).andNullSafe(notExists(MapperS.of(basketReferenceInformation).<Integer>map("getMthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getMthToDefault()))).orNullSafe(notExists(MapperS.of(basketReferenceInformation).<Tranche>map("getTranche", _basketReferenceInformation -> _basketReferenceInformation.getTranche())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketReferenceInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			return Collections.emptyList();
		}
	}
}
