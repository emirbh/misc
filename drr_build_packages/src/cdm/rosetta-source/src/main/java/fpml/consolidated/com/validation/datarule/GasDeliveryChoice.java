package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.GasDelivery;
import fpml.consolidated.com.GasDeliveryPoint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("GasDeliveryChoice")
@ImplementedBy(GasDeliveryChoice.Default.class)
public interface GasDeliveryChoice extends Validator<GasDelivery> {
	
	String NAME = "GasDeliveryChoice";
	String DEFINITION = "deliveryPoint is absent or entryPoint is absent and withdrawalPoint is absent";
	
	class Default implements GasDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDelivery gasDelivery) {
			ComparisonResult result = executeDataRule(gasDelivery);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GasDelivery", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GasDelivery", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(GasDelivery gasDelivery) {
			try {
				return notExists(MapperS.of(gasDelivery).<GasDeliveryPoint>map("getDeliveryPoint", _gasDelivery -> _gasDelivery.getDeliveryPoint())).orNullSafe(notExists(MapperS.of(gasDelivery).<CommodityDeliveryPoint>map("getEntryPoint", _gasDelivery -> _gasDelivery.getEntryPoint())).andNullSafe(notExists(MapperS.of(gasDelivery).<CommodityDeliveryPoint>map("getWithdrawalPoint", _gasDelivery -> _gasDelivery.getWithdrawalPoint()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GasDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDelivery gasDelivery) {
			return Collections.emptyList();
		}
	}
}
