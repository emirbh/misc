package cdm.product.asset.validation.datarule;

import cdm.base.math.Quantity;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.AssetDeliveryProfileBlock;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SchedulePeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("CommodityPayoutDeliveryCapacity")
@ImplementedBy(CommodityPayoutDeliveryCapacity.Default.class)
public interface CommodityPayoutDeliveryCapacity extends Validator<CommodityPayout> {
	
	String NAME = "CommodityPayoutDeliveryCapacity";
	String DEFINITION = "if delivery -> deliveryCapacity exists then schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity exists then delivery -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if delivery -> periods -> profile -> block -> deliveryCapacity exists then schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity exists then delivery -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent";
	
	class Default implements CommodityPayoutDeliveryCapacity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPayout commodityPayout) {
			ComparisonResult result = executeDataRule(commodityPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPayout commodityPayout) {
			try {
				if (exists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).andNullSafe(notExists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()))).andNullSafe(notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).andNullSafe(notExists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()))).andNullSafe(notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).andNullSafe(notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).andNullSafe(notExists(MapperS.of(commodityPayout).<CalculationSchedule>map("getSchedule", _commodityPayout -> _commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity()))).andNullSafe(notExists(MapperS.of(commodityPayout).<AssetDeliveryInformation>map("getDelivery", _commodityPayout -> _commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPayoutDeliveryCapacity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPayout commodityPayout) {
			return Collections.emptyList();
		}
	}
}
