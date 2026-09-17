package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.Price;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PriceChoice")
@ImplementedBy(PriceChoice.Default.class)
public interface PriceChoice extends Validator<Price> {
	
	String NAME = "PriceChoice";
	String DEFINITION = "amountRelativeTo is absent or determinationMethod is absent and grossPrice is absent and netPrice is absent and accruedInterestPrice is absent and fxConversion is absent";
	
	class Default implements PriceChoice {
	
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
				return notExists(MapperS.of(price).<AmountReference>map("getAmountRelativeTo", _price -> _price.getAmountRelativeTo())).orNullSafe(notExists(MapperS.of(price).<DeterminationMethod>map("getDeterminationMethod", _price -> _price.getDeterminationMethod())).andNullSafe(notExists(MapperS.of(price).<ActualPrice>map("getGrossPrice", _price -> _price.getGrossPrice()))).andNullSafe(notExists(MapperS.of(price).<ActualPrice>map("getNetPrice", _price -> _price.getNetPrice()))).andNullSafe(notExists(MapperS.of(price).<BigDecimal>map("getAccruedInterestPrice", _price -> _price.getAccruedInterestPrice()))).andNullSafe(notExists(MapperS.of(price).<FxConversion>map("getFxConversion", _price -> _price.getFxConversion()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Price price) {
			return Collections.emptyList();
		}
	}
}
