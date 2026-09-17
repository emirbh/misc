package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPriceQuantity.MapPriceQuantityDefault.class)
public abstract class MapPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapMoneyToNonNegativeQuantitySchedule mapMoneyToNonNegativeQuantitySchedule;
	@Inject protected MapNonNegativeMoneyNonNegativeQuantitySchedule mapNonNegativeMoneyNonNegativeQuantitySchedule;

	/**
	* @param fpmlTradeNotionalChange 
	* @param fpmlNovation 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlTradeNotionalChange, fpmlNovation);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> outstandingTradeNotional(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> outstandingSizeChange(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> novatedAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> changeInNotionalAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> outstandingNotionalAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> remainingAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> q(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation);

	public static class MapPriceQuantityDefault extends MapPriceQuantity {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlTradeNotionalChange, fpmlNovation);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			priceQuantityList.addAll(toBuilder(q(fpmlTradeNotionalChange, fpmlNovation)
				.mapItem(item -> MapperS.of(PriceQuantity.builder()
					.setQuantity(item.getMulti())
					.build())).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> outstandingTradeNotional(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlTradeNotionalChange).<NonNegativeMoney>mapC("getOutstandingNotionalAmount", tradeNotionalChange -> tradeNotionalChange.getOutstandingNotionalAmount())
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> outstandingSizeChange(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlTradeNotionalChange).<TradeLegSizeChange>mapC("getSizeChange", tradeNotionalChange -> tradeNotionalChange.getSizeChange()).<NonNegativeMoney>map("getOutstandingNotionalAmount", tradeLegSizeChange -> tradeLegSizeChange.getOutstandingNotionalAmount())
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> novatedAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<Money>mapC("getNovatedAmount", tradeNovationContent -> tradeNovationContent.getNovatedAmount())
				.mapItem(item -> MapperS.of(mapMoneyToNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> changeInNotionalAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<TradeLegSizeChange>mapC("getNovationAmount", tradeNovationContent -> tradeNovationContent.getNovationAmount()).<NonNegativeMoney>map("getChangeInNotionalAmount", tradeLegSizeChange -> tradeLegSizeChange.getChangeInNotionalAmount())
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> outstandingNotionalAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<TradeLegSizeChange>mapC("getNovationAmount", tradeNovationContent -> tradeNovationContent.getNovationAmount()).<NonNegativeMoney>map("getOutstandingNotionalAmount", tradeLegSizeChange -> tradeLegSizeChange.getOutstandingNotionalAmount())
				.mapItem(item -> MapperS.of(mapNonNegativeMoneyNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> remainingAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperS.of(fpmlNovation).<Money>mapC("getRemainingAmount", tradeNovationContent -> tradeNovationContent.getRemainingAmount())
				.mapItem(item -> MapperS.of(mapMoneyToNonNegativeQuantitySchedule.evaluate(item.get())));
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> q(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation) {
			return MapperC.<NonNegativeQuantitySchedule>of(outstandingTradeNotional(fpmlTradeNotionalChange, fpmlNovation), outstandingSizeChange(fpmlTradeNotionalChange, fpmlNovation), novatedAmount(fpmlTradeNotionalChange, fpmlNovation), changeInNotionalAmount(fpmlTradeNotionalChange, fpmlNovation), outstandingNotionalAmount(fpmlTradeNotionalChange, fpmlNovation), remainingAmount(fpmlTradeNotionalChange, fpmlNovation))
				.mapItem(item -> MapperS.of(createQuantityWithLocation.evaluate(item.get(), createQuantityKey.evaluate(null, null))));
		}
	}
}
