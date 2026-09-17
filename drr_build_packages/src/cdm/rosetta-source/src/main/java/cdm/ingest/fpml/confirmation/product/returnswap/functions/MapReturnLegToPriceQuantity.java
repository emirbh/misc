package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNetPriceToPriceListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountWithIdToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnLegValuation;
import fpml.consolidated.eq.shared.ReturnLegValuationPrice;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnLegToPriceQuantity.MapReturnLegToPriceQuantityDefault.class)
public abstract class MapReturnLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNetPriceToPriceListWithLocation mapNetPriceToPriceListWithLocation;
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;
	@Inject protected MapNotionalAmountWithIdToQuantityWithLocation mapNotionalAmountWithIdToQuantityWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlReturnLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(ReturnLeg fpmlReturnLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlReturnLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(ReturnLeg fpmlReturnLeg);

	protected abstract MapperS<? extends NotionalAmount> notionalAmount(ReturnLeg fpmlReturnLeg);

	public static class MapReturnLegToPriceQuantityDefault extends MapReturnLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(ReturnLeg fpmlReturnLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlReturnLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, ReturnLeg fpmlReturnLeg) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice(new ArrayList(mapNetPriceToPriceListWithLocation.evaluate(MapperS.of(fpmlReturnLeg).<ReturnLegValuation>map("getRateOfReturn", returnLeg -> returnLeg.getRateOfReturn()).<ReturnLegValuationPrice>map("getInitialPrice", returnLegValuation -> returnLegValuation.getInitialPrice()).get(), fpmlReturnLeg)))
				.setQuantity(MapperC.<FieldWithMetaNonNegativeQuantitySchedule>of(MapperS.of(mapNotionalAmountWithIdToQuantityWithLocation.evaluate(MapperS.of(fpmlReturnLeg).<Underlyer>map("getUnderlyer", returnLeg -> returnLeg.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<BigDecimal>map("getOpenUnits", singleUnderlyer -> singleUnderlyer.getOpenUnits()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<Currency>map("getCurrency", _notionalAmount -> _notionalAmount.getCurrency()).get(), "openUnits", fpmlReturnLeg)), MapperS.of(mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", _notionalAmount -> _notionalAmount.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<Currency>map("getCurrency", _notionalAmount -> _notionalAmount.getCurrency()).get(), fpmlReturnLeg))).getMulti())
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlReturnLeg).<Underlyer>map("getUnderlyer", returnLeg -> returnLeg.getUnderlyer()).get()))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NotionalAmount> notionalAmount(ReturnLeg fpmlReturnLeg) {
			return MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount());
		}
	}
}
