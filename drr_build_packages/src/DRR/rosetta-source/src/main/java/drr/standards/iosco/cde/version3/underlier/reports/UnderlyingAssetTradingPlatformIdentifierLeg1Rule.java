package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.functions.PayoutFromProductLeg1;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetTradingPlatformIdentifierLeg1Rule.UnderlyingAssetTradingPlatformIdentifierLeg1RuleDefault.class)
public abstract class UnderlyingAssetTradingPlatformIdentifierLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutFromProductLeg1 payoutFromProductLeg1;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TradableProductForEvent tradableProductForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingAssetTradingPlatformIdentifierLeg1RuleDefault extends UnderlyingAssetTradingPlatformIdentifierLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<PayoutLegWithAuxiliary> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (lessThanEquals(MapperS.of(MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(item.get()))).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(payoutFromProductLeg1.evaluate(MapperS.of(tradableProductForEvent.evaluate(item.get())).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get(), MapperS.of(tradableProductForEvent.evaluate(item.get())).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get(), item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()));
					}
					return MapperS.<PayoutLegWithAuxiliary>ofNull();
				});
			final MapperS<Underlier> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (exists(item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier())).getOrDefault(false)) {
						return item.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier());
					}
					if (exists(item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier())).getOrDefault(false)) {
						return item.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier());
					}
					if (exists(item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier())).getOrDefault(false)) {
						return item.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
					}
					if (exists(item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier())).getOrDefault(false)) {
						return item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier());
					}
					return MapperS.<Underlier>ofNull();
				});
			final MapperS<LegalEntity> thenArg2 = thenArg1
				.mapSingleToItem(item -> {
					if (exists(item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<LegalEntity>map("getExchange", commodity -> commodity.getExchange())).getOrDefault(false)) {
						return item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<LegalEntity>map("getExchange", commodity -> commodity.getExchange());
					}
					if (exists(item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<LegalEntity>map("getExchange", security -> security.getExchange())).getOrDefault(false)) {
						return item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<LegalEntity>map("getExchange", security -> security.getExchange());
					}
					if (exists(MapperS.of(item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent.getValue()).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<LegalEntity>map("getExchange", security -> security.getExchange()).get())).getOrDefault(false)) {
						return MapperS.of(item.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable5 -> referenceWithMetaObservable5 == null ? null : referenceWithMetaObservable5.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent.getValue()).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<LegalEntity>map("getExchange", security -> security.getExchange()).get());
					}
					return MapperS.<LegalEntity>ofNull();
				});
			final MapperC<EntityIdentifier> thenArg3 = thenArg2
				.mapSingleToList(item -> item.<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier()));
			final MapperC<EntityIdentifier> thenArg4 = thenArg3
				.filterItemNullSafe(item -> areEqual(item.<EntityIdentifierTypeEnum>map("getIdentifierType", entityIdentifier -> entityIdentifier.getIdentifierType()), MapperS.of(EntityIdentifierTypeEnum.MIC), CardinalityOperator.All).get());
			final MapperC<FieldWithMetaString> thenArg5 = thenArg4
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", entityIdentifier -> entityIdentifier.getIdentifier()));
			final FieldWithMetaString fieldWithMetaString = thenArg5
				.first().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
