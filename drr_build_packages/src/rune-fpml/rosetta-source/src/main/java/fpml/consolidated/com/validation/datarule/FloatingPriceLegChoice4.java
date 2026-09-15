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
import fpml.consolidated.com.FloatingPriceLeg;
import fpml.consolidated.com.QuantityReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FloatingPriceLegChoice4")
@ImplementedBy(FloatingPriceLegChoice4.Default.class)
public interface FloatingPriceLegChoice4 extends Validator<FloatingPriceLeg> {
	
	String NAME = "FloatingPriceLegChoice4";
	String DEFINITION = "if notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and quantityReference is absent then totalNotionalQuantity exists";
	
	class Default implements FloatingPriceLegChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			ComparisonResult result = executeDataRule(floatingPriceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingPriceLeg floatingPriceLeg) {
			try {
				if (notExists(MapperS.of(floatingPriceLeg).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _floatingPriceLeg -> _floatingPriceLeg.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(floatingPriceLeg).<CommodityNotionalQuantity>map("getNotionalQuantity", _floatingPriceLeg -> _floatingPriceLeg.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(floatingPriceLeg).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _floatingPriceLeg -> _floatingPriceLeg.getSettlementPeriodsNotionalQuantity()))).andNullSafe(notExists(MapperS.of(floatingPriceLeg).<QuantityReference>map("getQuantityReference", _floatingPriceLeg -> _floatingPriceLeg.getQuantityReference()))).getOrDefault(false)) {
					return exists(MapperS.of(floatingPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _floatingPriceLeg -> _floatingPriceLeg.getTotalNotionalQuantity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingPriceLegChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			return Collections.emptyList();
		}
	}
}
