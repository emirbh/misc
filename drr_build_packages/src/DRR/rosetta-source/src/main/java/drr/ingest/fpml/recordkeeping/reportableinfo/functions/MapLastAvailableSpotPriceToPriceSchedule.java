package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.UnitType;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapLastAvailableSpotPriceToPriceSchedule.MapLastAvailableSpotPriceToPriceScheduleDefault.class)
public abstract class MapLastAvailableSpotPriceToPriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlQuote 
	* @return cdmUnderlyingAssetLastAvailableSpotPrice 
	*/
	public PriceSchedule evaluate(List<? extends BasicQuotation> fpmlQuote) {
		PriceSchedule.PriceScheduleBuilder cdmUnderlyingAssetLastAvailableSpotPriceBuilder = doEvaluate(fpmlQuote);
		
		final PriceSchedule cdmUnderlyingAssetLastAvailableSpotPrice;
		if (cdmUnderlyingAssetLastAvailableSpotPriceBuilder == null) {
			cdmUnderlyingAssetLastAvailableSpotPrice = null;
		} else {
			cdmUnderlyingAssetLastAvailableSpotPrice = cdmUnderlyingAssetLastAvailableSpotPriceBuilder.build();
			objectValidator.validate(PriceSchedule.class, cdmUnderlyingAssetLastAvailableSpotPrice);
		}
		
		return cdmUnderlyingAssetLastAvailableSpotPrice;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(List<? extends BasicQuotation> fpmlQuote);

	protected abstract MapperS<? extends BasicQuotation> lastAvailableSpotPrice(List<? extends BasicQuotation> fpmlQuote);

	public static class MapLastAvailableSpotPriceToPriceScheduleDefault extends MapLastAvailableSpotPriceToPriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(List<? extends BasicQuotation> fpmlQuote) {
			if (fpmlQuote == null) {
				fpmlQuote = Collections.emptyList();
			}
			PriceSchedule.PriceScheduleBuilder cdmUnderlyingAssetLastAvailableSpotPrice = PriceSchedule.builder();
			return assignOutput(cdmUnderlyingAssetLastAvailableSpotPrice, fpmlQuote);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder cdmUnderlyingAssetLastAvailableSpotPrice, List<? extends BasicQuotation> fpmlQuote) {
			final MapperS<? extends BasicQuotation> thenArg0 = lastAvailableSpotPrice(fpmlQuote);
			final MapperS<? extends BasicQuotation> thenArg1 = lastAvailableSpotPrice(fpmlQuote);
			PriceTypeEnum ifThenElseResult = null;
			if (exists(lastAvailableSpotPrice(fpmlQuote)).getOrDefault(false)) {
				ifThenElseResult = PriceTypeEnum.ASSET_PRICE;
			}
			final MapperS<? extends BasicQuotation> thenArg2 = lastAvailableSpotPrice(fpmlQuote);
			cdmUnderlyingAssetLastAvailableSpotPrice = toBuilder(PriceSchedule.builder()
				.setValue(thenArg0.<BigDecimal>map("getValue", basicQuotation -> basicQuotation.getValue()).get())
				.setPerUnitOf(UnitType.builder()
					.setCapacityUnit(thenArg1.<PriceQuoteUnits>map("getQuoteUnits", basicQuotation -> basicQuotation.getQuoteUnits()).<String>map("getValue", priceQuoteUnits -> priceQuoteUnits.getValue()).checkedMap("to-enum", CapacityUnitEnum::fromDisplayName, IllegalArgumentException.class).get())
					.build())
				.setPriceType(ifThenElseResult)
				.setUnit(UnitType.builder()
					.setCurrencyValue(thenArg2.<Currency>map("getCurrency", basicQuotation -> basicQuotation.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
					.build())
				.build());
			
			return Optional.ofNullable(cdmUnderlyingAssetLastAvailableSpotPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BasicQuotation> lastAvailableSpotPrice(List<? extends BasicQuotation> fpmlQuote) {
			final MapperC<BasicQuotation> thenArg = MapperC.<BasicQuotation>of(fpmlQuote)
				.filterItemNullSafe(item -> areEqual(item.<AssetMeasureType>map("getMeasureType", basicQuotation -> basicQuotation.getMeasureType()).<String>map("getValue", assetMeasureType -> assetMeasureType.getValue()), MapperS.of("LastAvailableSpotPrice"), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
	}
}
