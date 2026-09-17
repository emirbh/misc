package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDeliveryPoint;
import fpml.consolidated.com.ElectricityDelivery;
import fpml.consolidated.com.ElectricityDeliveryPoint;
import fpml.consolidated.com.ElectricityDeliveryType;
import fpml.consolidated.com.ElectricityTransmissionContingency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.shared.PartyReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ElectricityDeliveryChoice")
@ImplementedBy(ElectricityDeliveryChoice.Default.class)
public interface ElectricityDeliveryChoice extends Validator<ElectricityDelivery> {
	
	String NAME = "ElectricityDeliveryChoice";
	String DEFINITION = "if deliveryPoint exists then deliveryZone is absent and electingPartyReference is absent else deliveryPoint is absent and deliveryType is absent and transmissionContingency is absent and interconnectionPoint is absent";
	
	class Default implements ElectricityDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDelivery electricityDelivery) {
			ComparisonResult result = executeDataRule(electricityDelivery);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityDelivery", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityDelivery", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ElectricityDelivery electricityDelivery) {
			try {
				if (exists(MapperS.of(electricityDelivery).<ElectricityDeliveryPoint>map("getDeliveryPoint", _electricityDelivery -> _electricityDelivery.getDeliveryPoint())).getOrDefault(false)) {
					return notExists(MapperS.of(electricityDelivery).<CommodityDeliveryPoint>map("getDeliveryZone", _electricityDelivery -> _electricityDelivery.getDeliveryZone())).andNullSafe(notExists(MapperS.of(electricityDelivery).<PartyReference>map("getElectingPartyReference", _electricityDelivery -> _electricityDelivery.getElectingPartyReference())));
				}
				return notExists(MapperS.of(electricityDelivery).<ElectricityDeliveryPoint>map("getDeliveryPoint", _electricityDelivery -> _electricityDelivery.getDeliveryPoint())).andNullSafe(notExists(MapperS.of(electricityDelivery).<ElectricityDeliveryType>map("getDeliveryType", _electricityDelivery -> _electricityDelivery.getDeliveryType()))).andNullSafe(notExists(MapperS.of(electricityDelivery).<ElectricityTransmissionContingency>map("getTransmissionContingency", _electricityDelivery -> _electricityDelivery.getTransmissionContingency()))).andNullSafe(notExists(MapperS.of(electricityDelivery).<InterconnectionPoint>map("getInterconnectionPoint", _electricityDelivery -> _electricityDelivery.getInterconnectionPoint())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ElectricityDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDelivery electricityDelivery) {
			return Collections.emptyList();
		}
	}
}
