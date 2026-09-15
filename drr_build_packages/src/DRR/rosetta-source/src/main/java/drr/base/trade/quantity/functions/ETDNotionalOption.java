package drr.base.trade.quantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ETDNotionalOption.ETDNotionalOptionDefault.class)
public abstract class ETDNotionalOption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param optionPayout 
	* @param tradeLot 
	* @return notional 
	*/
	public Measure evaluate(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
		Measure.MeasureBuilder notionalBuilder = doEvaluate(optionPayout, tradeLot);
		
		final Measure notional;
		if (notionalBuilder == null) {
			notional = null;
		} else {
			notional = notionalBuilder.build();
			objectValidator.validate(Measure.class, notional);
		}
		
		return notional;
	}

	protected abstract Measure.MeasureBuilder doEvaluate(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> quantityCurrency(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> quantityFinancial(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	protected abstract MapperS<? extends Price> strikePrice(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> amount(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	protected abstract MapperS<? extends UnitType> amountUnit(OptionPayout optionPayout, List<? extends TradeLot> tradeLot);

	public static class ETDNotionalOptionDefault extends ETDNotionalOption {
		@Override
		protected Measure.MeasureBuilder doEvaluate(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			if (tradeLot == null) {
				tradeLot = Collections.emptyList();
			}
			Measure.MeasureBuilder notional = Measure.builder();
			return assignOutput(notional, optionPayout, tradeLot);
		}
		
		protected Measure.MeasureBuilder assignOutput(Measure.MeasureBuilder notional, OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			notional = toBuilder(Measure.builder()
				.setValue(amount(optionPayout, tradeLot).get())
				.setUnit(amountUnit(optionPayout, tradeLot).get())
				.build());
			
			return Optional.ofNullable(notional)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> quantityCurrency(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<BigDecimal> quantityFinancial(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<? extends Price> strikePrice(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			return MapperS.of(optionPayout).<OptionStrike>map("getStrike", _optionPayout -> _optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice());
		}
		
		@Override
		protected MapperS<BigDecimal> amount(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				return quantityCurrency(optionPayout, tradeLot);
			}
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(quantityFinancial(optionPayout, tradeLot), strikePrice(optionPayout, tradeLot).<BigDecimal>map("getValue", price -> price.getValue()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<? extends UnitType> amountUnit(OptionPayout optionPayout, List<? extends TradeLot> tradeLot) {
			if (exists(MapperC.<TradeLot>of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
				final MapperS<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = MapperS.of(thenArg1.get());
				return thenArg2
					.mapSingleToItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()));
			}
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				return strikePrice(optionPayout, tradeLot).<UnitType>map("getUnit", price -> price.getUnit());
			}
			return MapperS.<UnitType>ofNull();
		}
	}
}
