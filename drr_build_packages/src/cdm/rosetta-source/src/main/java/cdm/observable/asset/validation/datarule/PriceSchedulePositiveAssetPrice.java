package cdm.observable.asset.validation.datarule;

import cdm.base.math.ArithmeticOperationEnum;
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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PriceSchedulePositiveAssetPrice")
@ImplementedBy(PriceSchedulePositiveAssetPrice.Default.class)
public interface PriceSchedulePositiveAssetPrice extends Validator<PriceSchedule> {
	
	String NAME = "PriceSchedulePositiveAssetPrice";
	String DEFINITION = "if (priceType = PriceTypeEnum -> ExchangeRate or priceType = PriceTypeEnum -> AssetPrice) and arithmeticOperator is absent then value > 0";
	
	class Default implements PriceSchedulePositiveAssetPrice {
	
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
				if (areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(priceSchedule).<PriceTypeEnum>map("getPriceType", _priceSchedule -> _priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(priceSchedule).<ArithmeticOperationEnum>map("getArithmeticOperator", _priceSchedule -> _priceSchedule.getArithmeticOperator()))).getOrDefault(false)) {
					return greaterThan(MapperS.of(priceSchedule).<BigDecimal>map("getValue", _priceSchedule -> _priceSchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceSchedulePositiveAssetPrice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			return Collections.emptyList();
		}
	}
}
