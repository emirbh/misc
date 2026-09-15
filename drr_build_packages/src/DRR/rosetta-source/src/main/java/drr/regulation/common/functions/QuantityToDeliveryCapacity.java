package drr.regulation.common.functions;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.DeliveryCapacity;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityToDeliveryCapacity.QuantityToDeliveryCapacityDefault.class)
public abstract class QuantityToDeliveryCapacity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantity 
	* @return deliveryCapacity 
	*/
	public DeliveryCapacity evaluate(Quantity quantity) {
		DeliveryCapacity.DeliveryCapacityBuilder deliveryCapacityBuilder = doEvaluate(quantity);
		
		final DeliveryCapacity deliveryCapacity;
		if (deliveryCapacityBuilder == null) {
			deliveryCapacity = null;
		} else {
			deliveryCapacity = deliveryCapacityBuilder.build();
			objectValidator.validate(DeliveryCapacity.class, deliveryCapacity);
		}
		
		return deliveryCapacity;
	}

	protected abstract DeliveryCapacity.DeliveryCapacityBuilder doEvaluate(Quantity quantity);

	protected abstract MapperS<CapacityUnitEnum> capacityUnit(Quantity quantity);

	protected abstract MapperS<? extends Frequency> frequency(Quantity quantity);

	public static class QuantityToDeliveryCapacityDefault extends QuantityToDeliveryCapacity {
		@Override
		protected DeliveryCapacity.DeliveryCapacityBuilder doEvaluate(Quantity quantity) {
			DeliveryCapacity.DeliveryCapacityBuilder deliveryCapacity = DeliveryCapacity.builder();
			return assignOutput(deliveryCapacity, quantity);
		}
		
		protected DeliveryCapacity.DeliveryCapacityBuilder assignOutput(DeliveryCapacity.DeliveryCapacityBuilder deliveryCapacity, Quantity quantity) {
			if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.KW), CardinalityOperator.All).getOrDefault(false)) {
				deliveryCapacity = toBuilder(DeliveryCapacity.builder()
					.setAmount(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()).get())
					.setUnit(EnergyQuantityUnit2Code.KWAT)
					.build());
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.MW), CardinalityOperator.All).getOrDefault(false)) {
				deliveryCapacity = toBuilder(DeliveryCapacity.builder()
					.setAmount(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()).get())
					.setUnit(EnergyQuantityUnit2Code.MWAT)
					.build());
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.GW), CardinalityOperator.All).getOrDefault(false)) {
				deliveryCapacity = toBuilder(DeliveryCapacity.builder()
					.setAmount(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()).get())
					.setUnit(EnergyQuantityUnit2Code.GWAT)
					.build());
			} else if (areEqual(MapperC.<CapacityUnitEnum>of(MapperS.of(CapacityUnitEnum.GBBTU), MapperS.of(CapacityUnitEnum.ISOBTU), MapperS.of(CapacityUnitEnum.USBTU)), capacityUnit(quantity), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer0 -> integer0 == null ? null : BigDecimal.valueOf(integer0))).get())
						.setUnit(EnergyQuantityUnit2Code.BTUD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(MapperC.<CapacityUnitEnum>of(MapperS.of(CapacityUnitEnum.GBMBTU), MapperS.of(CapacityUnitEnum.ISOMBTU), MapperS.of(CapacityUnitEnum.USMBTU)), capacityUnit(quantity), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("1000.0")), MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue())), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer1 -> integer1 == null ? null : BigDecimal.valueOf(integer1))).get())
						.setUnit(EnergyQuantityUnit2Code.BTUD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(MapperC.<CapacityUnitEnum>of(MapperS.of(CapacityUnitEnum.GBMMBTU), MapperS.of(CapacityUnitEnum.ISOMMBTU), MapperS.of(CapacityUnitEnum.USMMBTU)), capacityUnit(quantity), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer2 -> integer2 == null ? null : BigDecimal.valueOf(integer2))).get())
						.setUnit(EnergyQuantityUnit2Code.MBTD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.CBM), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer3 -> integer3 == null ? null : BigDecimal.valueOf(integer3))).get())
						.setUnit(EnergyQuantityUnit2Code.CMPD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.L), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer4 -> integer4 == null ? null : BigDecimal.valueOf(integer4)), MapperS.of(new BigDecimal("1000.0")))).get())
						.setUnit(EnergyQuantityUnit2Code.CMPD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.HL), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer5 -> integer5 == null ? null : BigDecimal.valueOf(integer5)), MapperS.of(new BigDecimal("10.0")))).get())
						.setUnit(EnergyQuantityUnit2Code.CMPD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.KL), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer6 -> integer6 == null ? null : BigDecimal.valueOf(integer6))).get())
						.setUnit(EnergyQuantityUnit2Code.CMPD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.MJ), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer7 -> integer7 == null ? null : BigDecimal.valueOf(integer7))).get())
						.setUnit(EnergyQuantityUnit2Code.MJDD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.GJ), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer8 -> integer8 == null ? null : BigDecimal.valueOf(integer8))).get())
						.setUnit(EnergyQuantityUnit2Code.GJDD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.KWH), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.H), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer9 -> integer9 == null ? null : BigDecimal.valueOf(integer9))).get())
						.setUnit(EnergyQuantityUnit2Code.KWHH)
						.build());
				} else if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer10 -> integer10 == null ? null : BigDecimal.valueOf(integer10))).get())
						.setUnit(EnergyQuantityUnit2Code.KWHD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.MWH), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.H), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer11 -> integer11 == null ? null : BigDecimal.valueOf(integer11))).get())
						.setUnit(EnergyQuantityUnit2Code.MWHH)
						.build());
				} else if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer12 -> integer12 == null ? null : BigDecimal.valueOf(integer12))).get())
						.setUnit(EnergyQuantityUnit2Code.MWHD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(capacityUnit(quantity), MapperS.of(CapacityUnitEnum.GWH), CardinalityOperator.All).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.H), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer13 -> integer13 == null ? null : BigDecimal.valueOf(integer13))).get())
						.setUnit(EnergyQuantityUnit2Code.GWHH)
						.build());
				} else if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer14 -> integer14 == null ? null : BigDecimal.valueOf(integer14))).get())
						.setUnit(EnergyQuantityUnit2Code.GWHD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else if (areEqual(MapperC.<CapacityUnitEnum>of(MapperS.of(CapacityUnitEnum.GBTHM), MapperS.of(CapacityUnitEnum.ISOTHM), MapperS.of(CapacityUnitEnum.USTHM)), capacityUnit(quantity), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(frequency(quantity).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
					deliveryCapacity = toBuilder(DeliveryCapacity.builder()
						.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quantity).<BigDecimal>map("getValue", _quantity -> _quantity.getValue()), frequency(quantity).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()).<BigDecimal>map("Type coercion", integer15 -> integer15 == null ? null : BigDecimal.valueOf(integer15))).get())
						.setUnit(EnergyQuantityUnit2Code.THMD)
						.build());
				} else {
					deliveryCapacity = null;
				}
			} else {
				deliveryCapacity = null;
			}
			
			return Optional.ofNullable(deliveryCapacity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<CapacityUnitEnum> capacityUnit(Quantity quantity) {
			return MapperS.of(quantity).<UnitType>map("getUnit", _quantity -> _quantity.getUnit()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit());
		}
		
		@Override
		protected MapperS<? extends Frequency> frequency(Quantity quantity) {
			return MapperS.of(quantity).<Frequency>map("getFrequency", _quantity -> _quantity.getFrequency());
		}
	}
}
