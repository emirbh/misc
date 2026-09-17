package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
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
@RosettaDataRule("FixedPriceLegChoice5")
@ImplementedBy(FixedPriceLegChoice5.Default.class)
public interface FixedPriceLegChoice5 extends Validator<FixedPriceLeg> {
	
	String NAME = "FixedPriceLegChoice5";
	String DEFINITION = "if notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and quantityReference is absent then totalNotionalQuantity exists";
	
	class Default implements FixedPriceLegChoice5 {
	
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
				if (notExists(MapperS.of(fixedPriceLeg).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _fixedPriceLeg -> _fixedPriceLeg.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(fixedPriceLeg).<CommodityNotionalQuantity>map("getNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(fixedPriceLeg).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getSettlementPeriodsNotionalQuantity()))).andNullSafe(notExists(MapperS.of(fixedPriceLeg).<QuantityReference>map("getQuantityReference", _fixedPriceLeg -> _fixedPriceLeg.getQuantityReference()))).getOrDefault(false)) {
					return exists(MapperS.of(fixedPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getTotalNotionalQuantity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedPriceLegChoice5 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			return Collections.emptyList();
		}
	}
}
