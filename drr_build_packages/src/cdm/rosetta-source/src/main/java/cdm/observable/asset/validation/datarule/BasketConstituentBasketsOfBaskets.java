package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
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
@RosettaDataRule("BasketConstituentBasketsOfBaskets")
@ImplementedBy(BasketConstituentBasketsOfBaskets.Default.class)
public interface BasketConstituentBasketsOfBaskets extends Validator<BasketConstituent> {
	
	String NAME = "BasketConstituentBasketsOfBaskets";
	String DEFINITION = "Basket is absent";
	
	class Default implements BasketConstituentBasketsOfBaskets {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituent basketConstituent) {
			ComparisonResult result = executeDataRule(basketConstituent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketConstituent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketConstituent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BasketConstituent basketConstituent) {
			try {
				return notExists(MapperS.of(basketConstituent).<Basket>map("getBasket", _basketConstituent -> _basketConstituent.getBasket()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketConstituentBasketsOfBaskets {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituent basketConstituent) {
			return Collections.emptyList();
		}
	}
}
