package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.FixedPriceLeg;
import fpml.consolidated.com.QuantityReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FixedPriceLegChoice4")
@ImplementedBy(FixedPriceLegChoice4.Default.class)
public interface FixedPriceLegChoice4 extends Validator<FixedPriceLeg> {
	
	String NAME = "FixedPriceLegChoice4";
	String DEFINITION = "if quantityReference exists then totalNotionalQuantity is absent";
	
	class Default implements FixedPriceLegChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			ComparisonResult result = executeDataRule(fixedPriceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPriceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPriceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FixedPriceLeg fixedPriceLeg) {
			try {
				if (exists(MapperS.of(fixedPriceLeg).<QuantityReference>map("getQuantityReference", _fixedPriceLeg -> _fixedPriceLeg.getQuantityReference())).getOrDefault(false)) {
					return notExists(MapperS.of(fixedPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getTotalNotionalQuantity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedPriceLegChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			return Collections.emptyList();
		}
	}
}
