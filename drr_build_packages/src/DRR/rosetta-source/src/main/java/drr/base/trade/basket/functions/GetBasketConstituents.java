package drr.base.trade.basket.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.base.math.WeatherUnitEnum;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.event.common.Trade;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.underlier.functions.FilterAssetIdentifier;
import drr.standards.iso.functions.CapacityUnitToISO20022UnitOfMeasure;
import drr.standards.iso.functions.FinancialUnitToISO20022UnitOfMeasure;
import drr.standards.iso.functions.WeatherUnitToISO20022UnitOfMeasure;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetBasketConstituents.GetBasketConstituentsDefault.class)
public abstract class GetBasketConstituents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CapacityUnitToISO20022UnitOfMeasure capacityUnitToISO20022UnitOfMeasure;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FilterAssetIdentifier filterAssetIdentifier;
	@Inject protected FinancialUnitToISO20022UnitOfMeasure financialUnitToISO20022UnitOfMeasure;
	@Inject protected GetBasket getBasket;
	@Inject protected GetQuantityForConstituent getQuantityForConstituent;
	@Inject protected GetQuantityForReferencePoolItem getQuantityForReferencePoolItem;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected WeatherUnitToISO20022UnitOfMeasure weatherUnitToISO20022UnitOfMeasure;

	/**
	* @param trade 
	* @return result Single product identifier per basket constituent.
	*/
	public List<? extends BasketConstituentsReport> evaluate(Trade trade) {
		List<BasketConstituentsReport.BasketConstituentsReportBuilder> resultBuilder = doEvaluate(trade);
		
		final List<? extends BasketConstituentsReport> result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.stream().map(BasketConstituentsReport::build).collect(Collectors.toList());
			objectValidator.validate(BasketConstituentsReport.class, result);
		}
		
		return result;
	}

	protected abstract List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(Trade trade);

	protected abstract MapperC<? extends Underlier> underliers(Trade trade);

	protected abstract MapperC<? extends TradeLot> tradeLots(Trade trade);

	protected abstract MapperC<? extends ReferencePoolItem> referencePoolItems(Trade trade);

	public static class GetBasketConstituentsDefault extends GetBasketConstituents {
		@Override
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(Trade trade) {
			List<BasketConstituentsReport.BasketConstituentsReportBuilder> result = new ArrayList<>();
			return assignOutput(result, trade);
		}
		
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> assignOutput(List<BasketConstituentsReport.BasketConstituentsReportBuilder> result, Trade trade) {
			final MapperC<Basket> thenArg0 = underliers(trade).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket());
			final MapperListOfLists<BasketConstituent> thenArg1 = thenArg0
				.mapItemToList(item -> MapperC.<BasketConstituent>of(getBasket.evaluate(item.get())));
			final MapperC<BasketConstituent> thenArg2 = thenArg1
				.flattenList();
			final MapperListOfLists<AssetIdentifier> thenArg3 = thenArg2
				.mapItemToList(item -> {
					if (exists(item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity())).getOrDefault(false)) {
						return item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan())).getOrDefault(false)) {
						return item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					if (exists(item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).getOrDefault(false)) {
						return item.<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
					}
					if (exists(item.<Index>map("getIndex", basketConstituent -> basketConstituent.getIndex())).getOrDefault(false)) {
						return item.<Index>map("getIndex", basketConstituent -> basketConstituent.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
			final MapperListOfLists<AssetIdentifier> thenArg4 = thenArg3
				.mapListToList(item -> MapperC.of(Collections.singletonList(MapperS.of(filterAssetIdentifier.evaluate(item.getMulti(), AssetIdTypeEnum.ISIN)).getOrDefault(item.get()))));
			result.addAll(toBuilder(thenArg4
				.mapListToItem(item -> {
					final FieldWithMetaString fieldWithMetaString0 = item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
					final FieldWithMetaString fieldWithMetaString1 = item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
					final FieldWithMetaString fieldWithMetaString2 = item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
					final MapperS<UnitType> thenArg = MapperS.of(getQuantityForConstituent.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), tradeLots(trade).getMulti())).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit());
					return MapperS.of(BasketConstituentsReport.builder()
						.setIdentifier((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()))
						.setSource(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()).get())
						.setNumberOfUnits(MapperS.of(getQuantityForConstituent.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), tradeLots(trade).getMulti())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.setUnitOfMeasure(thenArg
							.mapSingleToItem(_item -> {
								if (exists(_item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit())).getOrDefault(false)) {
									return MapperS.of(capacityUnitToISO20022UnitOfMeasure.evaluate(_item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()).get()));
								}
								if (exists(_item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit())).getOrDefault(false)) {
									return MapperS.of(weatherUnitToISO20022UnitOfMeasure.evaluate(_item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit()).get()));
								}
								if (exists(_item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
									return MapperS.of(financialUnitToISO20022UnitOfMeasure.evaluate(_item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get()));
								}
								return MapperS.<String>ofNull();
							}).get())
						.build());
				}).getMulti()));
			
			final MapperC<? extends ReferencePoolItem> thenArg5 = referencePoolItems(trade);
			final MapperListOfLists<AssetIdentifier> thenArg6 = thenArg5
				.mapItemToList(item -> {
					if (exists(item.<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity())).getOrDefault(false)) {
						return item.<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan())).getOrDefault(false)) {
						return item.<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
			result.addAll(toBuilder(thenArg6
				.mapListToItem(item -> {
					final FieldWithMetaString fieldWithMetaString = MapperS.of(filterAssetIdentifier.evaluate(item.getMulti(), AssetIdTypeEnum.ISIN)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).getOrDefault(item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get());
					final MapperS<UnitType> thenArg = MapperS.of(getQuantityForReferencePoolItem.evaluate(referencePoolItems(trade).get())).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit());
					return MapperS.of(BasketConstituentsReport.builder()
						.setIdentifier((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))
						.setSource(MapperS.of(filterAssetIdentifier.evaluate(item.getMulti(), AssetIdTypeEnum.ISIN)).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()).getOrDefault(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()).get()))
						.setNumberOfUnits(MapperS.of(getQuantityForReferencePoolItem.evaluate(referencePoolItems(trade).get())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.setUnitOfMeasure(thenArg
							.mapSingleToItem(_item -> {
								if (exists(_item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit())).getOrDefault(false)) {
									return MapperS.of(capacityUnitToISO20022UnitOfMeasure.evaluate(_item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()).get()));
								}
								if (exists(_item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit())).getOrDefault(false)) {
									return MapperS.of(weatherUnitToISO20022UnitOfMeasure.evaluate(_item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit()).get()));
								}
								if (exists(_item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
									return MapperS.of(financialUnitToISO20022UnitOfMeasure.evaluate(_item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get()));
								}
								return MapperS.<String>ofNull();
							}).get())
						.build());
				}).getMulti()));
			
			return Optional.ofNullable(result)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Underlier> underliers(Trade trade) {
			final MapperC<Payout> thenArg = MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(trade))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
			final MapperC<Underlier> ifThenElseResult;
			if (exists(thenArg.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).getOrDefault(false)) {
				ifThenElseResult = MapperC.of(MapperS.of(thenArg.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()));
			} else if (exists(thenArg.<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).getOrDefault(false)) {
				ifThenElseResult = MapperC.of(MapperS.of(thenArg.<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()));
			} else if (exists(thenArg.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout())).getOrDefault(false)) {
				ifThenElseResult = thenArg.<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
			} else if (exists(thenArg.<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())).getOrDefault(false)) {
				ifThenElseResult = thenArg.<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier());
			} else {
				ifThenElseResult = MapperC.<Underlier>ofNull();
			}
			return ifThenElseResult;
		}
		
		@Override
		protected MapperC<? extends TradeLot> tradeLots(Trade trade) {
			return MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot());
		}
		
		@Override
		protected MapperC<? extends ReferencePoolItem> referencePoolItems(Trade trade) {
			if (exists(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(trade))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem()).<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation())).getOrDefault(false)) {
				return MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(trade))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem());
			}
			return MapperC.<ReferencePoolItem>ofNull();
		}
	}
}
