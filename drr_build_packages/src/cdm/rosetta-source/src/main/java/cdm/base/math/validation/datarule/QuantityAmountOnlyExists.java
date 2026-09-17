package cdm.base.math.validation.datarule;

import cdm.base.math.DatedValue;
import cdm.base.math.Quantity;
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
@RosettaDataRule("QuantityAmountOnlyExists")
@ImplementedBy(QuantityAmountOnlyExists.Default.class)
public interface QuantityAmountOnlyExists extends Validator<Quantity> {
	
	String NAME = "QuantityAmountOnlyExists";
	String DEFINITION = "value exists and datedValue is absent";
	
	class Default implements QuantityAmountOnlyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quantity quantity) {
			ComparisonResult result = executeDataRule(quantity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Quantity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Quantity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Quantity quantity) {
			try {
				return exists(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue())).andNullSafe(notExists(MapperS.of(quantity).<DatedValue>mapC("getDatedValue", _quantity -> _quantity.getDatedValue())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuantityAmountOnlyExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quantity quantity) {
			return Collections.emptyList();
		}
	}
}
