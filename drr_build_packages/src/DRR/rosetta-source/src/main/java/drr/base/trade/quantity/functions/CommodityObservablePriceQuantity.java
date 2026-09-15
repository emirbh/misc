package drr.base.trade.quantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.GetQuantityKeys;
import drr.base.trade.functions.GetQuantityReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityObservablePriceQuantity.CommodityObservablePriceQuantityDefault.class)
public abstract class CommodityObservablePriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetQuantityKeys getQuantityKeys;
	@Inject protected GetQuantityReference getQuantityReference;

	/**
	* @param tradeLot 
	* @param commodityPayout 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(TradeLot tradeLot, CommodityPayout commodityPayout) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(tradeLot, commodityPayout);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(TradeLot tradeLot, CommodityPayout commodityPayout);

	protected abstract MapperS<? extends PriceQuantity> priceQuantityWithMatchingObservable(TradeLot tradeLot, CommodityPayout commodityPayout);

	protected abstract MapperS<? extends PriceQuantity> priceQuantityWithMatchingKey(TradeLot tradeLot, CommodityPayout commodityPayout);

	public static class CommodityObservablePriceQuantityDefault extends CommodityObservablePriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(TradeLot tradeLot, CommodityPayout commodityPayout) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, tradeLot, commodityPayout);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, TradeLot tradeLot, CommodityPayout commodityPayout) {
			if (exists(priceQuantityWithMatchingObservable(tradeLot, commodityPayout)).getOrDefault(false)) {
				priceQuantity = toBuilder(priceQuantityWithMatchingObservable(tradeLot, commodityPayout).get());
			} else {
				priceQuantity = toBuilder(priceQuantityWithMatchingKey(tradeLot, commodityPayout).get());
			}
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> priceQuantityWithMatchingObservable(TradeLot tradeLot, CommodityPayout commodityPayout) {
			final MapperC<PriceQuantity> thenArg0 = MapperS.of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity());
			final MapperC<PriceQuantity> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable == null ? null : fieldWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()), MapperS.of(commodityPayout).<Underlier>map("getUnderlier", _commodityPayout -> _commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()), CardinalityOperator.All).get());
			return MapperS.of(thenArg1.get());
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> priceQuantityWithMatchingKey(TradeLot tradeLot, CommodityPayout commodityPayout) {
			final MapperC<PriceQuantity> thenArg = MapperS.of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity())
				.filterItemNullSafe(item -> contains(MapperC.<String>of(getQuantityKeys.evaluate(item.get())), MapperS.of(getQuantityReference.evaluate(MapperS.of(commodityPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _commodityPayout -> _commodityPayout.getPriceQuantity()).get()))).get());
			return MapperS.of(thenArg.get());
		}
	}
}
