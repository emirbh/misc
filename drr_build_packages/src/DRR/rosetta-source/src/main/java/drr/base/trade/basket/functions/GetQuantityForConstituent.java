package drr.base.trade.basket.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetQuantityForConstituent.GetQuantityForConstituentDefault.class)
public abstract class GetQuantityForConstituent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param identifier 
	* @param tradeLots 
	* @return result 
	*/
	public NonNegativeQuantitySchedule evaluate(String identifier, List<? extends TradeLot> tradeLots) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder resultBuilder = doEvaluate(identifier, tradeLots);
		
		final NonNegativeQuantitySchedule result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, result);
		}
		
		return result;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(String identifier, List<? extends TradeLot> tradeLots);

	public static class GetQuantityForConstituentDefault extends GetQuantityForConstituent {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(String identifier, List<? extends TradeLot> tradeLots) {
			if (tradeLots == null) {
				tradeLots = Collections.emptyList();
			}
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result = NonNegativeQuantitySchedule.builder();
			return assignOutput(result, identifier, tradeLots);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result, String identifier, List<? extends TradeLot> tradeLots) {
			final MapperC<FieldWithMetaBasketConstituent> thenArg0 = MapperC.<TradeLot>of(tradeLots).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
				.filterItemNullSafe(item -> areEqual(item.<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue()).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of(identifier), CardinalityOperator.Any).get());
			final MapperListOfLists<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
				.mapItemToList(item -> item.<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue()).<ReferenceWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", basketConstituent -> basketConstituent.getQuantity()));
			final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = MapperS.of(thenArg1
				.flattenList().get()).get();
			if (referenceWithMetaNonNegativeQuantitySchedule == null) {
				result = null;
			} else {
				result = toBuilder(referenceWithMetaNonNegativeQuantitySchedule.getValue());
			}
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
