package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CashPrice;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
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
@RosettaDataRule("PriceScheduleCashPrice")
@ImplementedBy(PriceScheduleCashPrice.Default.class)
public interface PriceScheduleCashPrice extends Validator<PriceSchedule> {
	
	String NAME = "PriceScheduleCashPrice";
	String DEFINITION = "if cashPrice exists then priceType = PriceTypeEnum -> CashPrice";
	
	class Default implements PriceScheduleCashPrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			ComparisonResult result = executeDataRule(priceSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PriceSchedule priceSchedule) {
			try {
				if (exists(MapperS.of(priceSchedule).<CashPrice>map("getCashPrice", _priceSchedule -> _priceSchedule.getCashPrice())).getOrDefault(false)) {
					return areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceScheduleCashPrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			return Collections.emptyList();
		}
	}
}
