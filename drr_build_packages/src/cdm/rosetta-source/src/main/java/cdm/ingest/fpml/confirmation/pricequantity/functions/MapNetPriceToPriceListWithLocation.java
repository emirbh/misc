package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.Price;
import fpml.consolidated.fpmlenum.PriceExpressionEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNetPriceToPriceListWithLocation.MapNetPriceToPriceListWithLocationDefault.class)
public abstract class MapNetPriceToPriceListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlPrice 
	* @param fpmlLeg 
	* @return priceSchedules 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(Price fpmlPrice, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedulesBuilder = doEvaluate(fpmlPrice, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceSchedules;
		if (priceSchedulesBuilder == null) {
			priceSchedules = null;
		} else {
			priceSchedules = priceSchedulesBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedules);
		}
		
		return priceSchedules;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(Price fpmlPrice, Leg fpmlLeg);

	protected abstract MapperS<? extends ActualPrice> fpmlNetPrice(Price fpmlPrice, Leg fpmlLeg);

	public static class MapNetPriceToPriceListWithLocationDefault extends MapNetPriceToPriceListWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(Price fpmlPrice, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules = new ArrayList<>();
			return assignOutput(priceSchedules, fpmlPrice, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules, Price fpmlPrice, Leg fpmlLeg) {
			if (exists(fpmlNetPrice(fpmlPrice, fpmlLeg)).getOrDefault(false)) {
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = createPriceWithLocation.evaluate(PriceSchedule.builder()
					.setValue(fpmlNetPrice(fpmlPrice, fpmlLeg).<BigDecimal>map("getAmount", actualPrice -> actualPrice.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(fpmlNetPrice(fpmlPrice, fpmlLeg).<Currency>map("getCurrency", actualPrice -> actualPrice.getCurrency()).get()))
						.build())
					.setPerUnitOf(UnitType.builder()
						.setFinancialUnit(FinancialUnitEnum.SHARE)
						.build())
					.setPriceExpression(fpmlNetPrice(fpmlPrice, fpmlLeg).<PriceExpressionEnum>map("getPriceExpression", actualPrice -> actualPrice.getPriceExpression()).checkedMap("to-enum", e -> cdm.observable.asset.PriceExpressionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setPriceType(PriceTypeEnum.ASSET_PRICE)
					.build(), createPriceKey.evaluate("netPrice", fpmlLeg));
				if (fieldWithMetaPriceSchedule == null) {
					priceSchedules.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
				} else {
					priceSchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaPriceSchedule)));
				}
			} else {
				priceSchedules.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
			}
			
			return Optional.ofNullable(priceSchedules)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ActualPrice> fpmlNetPrice(Price fpmlPrice, Leg fpmlLeg) {
			return MapperS.of(fpmlPrice).<ActualPrice>map("getNetPrice", price -> price.getNetPrice());
		}
	}
}
