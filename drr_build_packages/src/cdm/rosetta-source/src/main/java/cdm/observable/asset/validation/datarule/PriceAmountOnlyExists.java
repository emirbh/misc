package cdm.observable.asset.validation.datarule;

import cdm.base.math.DatedValue;
import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PriceAmountOnlyExists")
@ImplementedBy(PriceAmountOnlyExists.Default.class)
public interface PriceAmountOnlyExists extends Validator<Price> {
	
	String NAME = "PriceAmountOnlyExists";
	String DEFINITION = "value exists and datedValue is absent";
	
	class Default implements PriceAmountOnlyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Price price) {
			ComparisonResult result = executeDataRule(price);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Price", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Price", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Price price) {
			try {
				return exists(MapperS.of(price).<BigDecimal>map("getValue", _price -> _price.getValue())).andNullSafe(notExists(MapperS.of(price).<DatedValue>mapC("getDatedValue", _price -> _price.getDatedValue())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceAmountOnlyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Price price) {
			return Collections.emptyList();
		}
	}
}
