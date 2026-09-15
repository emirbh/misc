package drr.base.trade.quantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
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

@ImplementedBy(ETDNotionalFuture.ETDNotionalFutureDefault.class)
public abstract class ETDNotionalFuture implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeLot 
	* @return notional 
	*/
	public Measure evaluate(List<? extends TradeLot> tradeLot) {
		Measure.MeasureBuilder notionalBuilder = doEvaluate(tradeLot);
		
		final Measure notional;
		if (notionalBuilder == null) {
			notional = null;
		} else {
			notional = notionalBuilder.build();
			objectValidator.validate(Measure.class, notional);
		}
		
		return notional;
	}

	protected abstract Measure.MeasureBuilder doEvaluate(List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> quantityCurrency(List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> quantityFinancial(List<? extends TradeLot> tradeLot);

	protected abstract MapperS<? extends FieldWithMetaPriceSchedule> price(List<? extends TradeLot> tradeLot);

	protected abstract MapperS<BigDecimal> amount(List<? extends TradeLot> tradeLot);

	protected abstract MapperS<? extends UnitType> amountUnit(List<? extends TradeLot> tradeLot);

	public static class ETDNotionalFutureDefault extends ETDNotionalFuture {
		@Override
		protected Measure.MeasureBuilder doEvaluate(List<? extends TradeLot> tradeLot) {
			if (tradeLot == null) {
				tradeLot = Collections.emptyList();
			}
			Measure.MeasureBuilder notional = Measure.builder();
			return assignOutput(notional, tradeLot);
		}
		
		protected Measure.MeasureBuilder assignOutput(Measure.MeasureBuilder notional, List<? extends TradeLot> tradeLot) {
			notional = toBuilder(Measure.builder()
				.setValue(amount(tradeLot).get())
				.setUnit(amountUnit(tradeLot).get())
				.build());
			
			return Optional.ofNullable(notional)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> quantityCurrency(List<? extends TradeLot> tradeLot) {
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<BigDecimal> quantityFinancial(List<? extends TradeLot> tradeLot) {
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).get());
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()));
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaPriceSchedule> price(List<? extends TradeLot> tradeLot) {
			return MapperS.of(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).get());
		}
		
		@Override
		protected MapperS<BigDecimal> amount(List<? extends TradeLot> tradeLot) {
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				return quantityCurrency(tradeLot);
			}
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(quantityFinancial(tradeLot), price(tradeLot).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<? extends UnitType> amountUnit(List<? extends TradeLot> tradeLot) {
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
				final MapperS<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = MapperS.of(thenArg1.get());
				return thenArg2
					.mapSingleToItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()));
			}
			if (exists(MapperS.of(MapperC.of(tradeLot).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				return price(tradeLot).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit());
			}
			return MapperS.<UnitType>ofNull();
		}
	}
}
