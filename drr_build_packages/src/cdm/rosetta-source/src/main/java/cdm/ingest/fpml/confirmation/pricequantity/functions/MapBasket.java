package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.Basket;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasketConstituent;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasket.MapBasketDefault.class)
public abstract class MapBasket implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBasketConstituentWithLocation mapBasketConstituentWithLocation;

	/**
	* @param fpmlBasket 
	* @return basket 
	*/
	public Basket evaluate(fpml.consolidated.asset.Basket fpmlBasket) {
		Basket.BasketBuilder basketBuilder = doEvaluate(fpmlBasket);
		
		final Basket basket;
		if (basketBuilder == null) {
			basket = null;
		} else {
			basket = basketBuilder.build();
			objectValidator.validate(Basket.class, basket);
		}
		
		return basket;
	}

	protected abstract Basket.BasketBuilder doEvaluate(fpml.consolidated.asset.Basket fpmlBasket);

	public static class MapBasketDefault extends MapBasket {
		@Override
		protected Basket.BasketBuilder doEvaluate(fpml.consolidated.asset.Basket fpmlBasket) {
			Basket.BasketBuilder basket = Basket.builder();
			return assignOutput(basket, fpmlBasket);
		}
		
		protected Basket.BasketBuilder assignOutput(Basket.BasketBuilder basket, fpml.consolidated.asset.Basket fpmlBasket) {
			basket = toBuilder(Basket.builder()
				.setIdentifier(Collections.<AssetIdentifier>emptyList())
				.setBasketConstituent(MapperS.of(fpmlBasket).<BasketConstituent>mapC("getBasketConstituent", _basket -> _basket.getBasketConstituent())
					.mapItem(item -> MapperS.of(mapBasketConstituentWithLocation.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(basket)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
