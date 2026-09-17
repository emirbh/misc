package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.FixedPriceLeg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.SettlementPeriodsFixedPrice;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FixedPriceLegChoice7")
@ImplementedBy(FixedPriceLegChoice7.Default.class)
public interface FixedPriceLegChoice7 extends Validator<FixedPriceLeg> {
	
	String NAME = "FixedPriceLegChoice7";
	String DEFINITION = "if quantityReference is absent and totalNotionalQuantity is absent and required choice notionalQuantitySchedule, notionalQuantity, settlementPeriodsNotionalQuantity then fixedPrice exists or fixedPriceSchedule exists or worldscaleRate exists or contractRate exists or settlementPeriodsPrice exists";
	
	class Default implements FixedPriceLegChoice7 {
	
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
				if (notExists(MapperS.of(fixedPriceLeg).<QuantityReference>map("getQuantityReference", _fixedPriceLeg -> _fixedPriceLeg.getQuantityReference())).andNullSafe(notExists(MapperS.of(fixedPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getTotalNotionalQuantity()))).andNullSafe(choice(MapperS.of(fixedPriceLeg), Arrays.asList("notionalQuantitySchedule", "notionalQuantity", "settlementPeriodsNotionalQuantity"), ChoiceRuleValidationMethod.REQUIRED)).getOrDefault(false)) {
					return exists(MapperS.of(fixedPriceLeg).<CommodityFixedPrice>map("getFixedPrice", _fixedPriceLeg -> _fixedPriceLeg.getFixedPrice())).orNullSafe(exists(MapperS.of(fixedPriceLeg).<CommodityFixedPriceSchedule>map("getFixedPriceSchedule", _fixedPriceLeg -> _fixedPriceLeg.getFixedPriceSchedule()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<BigDecimal>map("getWorldscaleRate", _fixedPriceLeg -> _fixedPriceLeg.getWorldscaleRate()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<NonNegativeMoney>map("getContractRate", _fixedPriceLeg -> _fixedPriceLeg.getContractRate()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<SettlementPeriodsFixedPrice>mapC("getSettlementPeriodsPrice", _fixedPriceLeg -> _fixedPriceLeg.getSettlementPeriodsPrice())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedPriceLegChoice7 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			return Collections.emptyList();
		}
	}
}
