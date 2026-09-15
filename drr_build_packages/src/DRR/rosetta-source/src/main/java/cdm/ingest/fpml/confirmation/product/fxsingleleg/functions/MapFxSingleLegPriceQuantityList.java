package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxCoreDetailsModelPriceQuantityList;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxSingleLegPriceQuantityList.MapFxSingleLegPriceQuantityListDefault.class)
public abstract class MapFxSingleLegPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxCoreDetailsModelPriceQuantityList mapFxCoreDetailsModelPriceQuantityList;

	/**
	* @param fpmlFxSingleLeg 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(FxSingleLeg fpmlFxSingleLeg) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlFxSingleLeg);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxSingleLeg fpmlFxSingleLeg);

	public static class MapFxSingleLegPriceQuantityListDefault extends MapFxSingleLegPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxSingleLeg fpmlFxSingleLeg) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlFxSingleLeg);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, FxSingleLeg fpmlFxSingleLeg) {
			priceQuantityList.addAll(toBuilder(mapFxCoreDetailsModelPriceQuantityList.evaluate(MapperS.of(fpmlFxSingleLeg).<ExchangeRate>map("getExchangeRate", fxSingleLeg -> fxSingleLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency1", fxSingleLeg -> fxSingleLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency2", fxSingleLeg -> fxSingleLeg.getExchangedCurrency2()).get(), null)));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
