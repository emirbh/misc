package drr.base.trade.basket.functions;

import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetBasket.GetBasketDefault.class)
public abstract class GetBasket implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param basket 
	* @return basketConstituent 
	*/
	public List<? extends BasketConstituent> evaluate(Basket basket) {
		List<BasketConstituent.BasketConstituentBuilder> basketConstituentBuilder = doEvaluate(basket);
		
		final List<? extends BasketConstituent> basketConstituent;
		if (basketConstituentBuilder == null) {
			basketConstituent = null;
		} else {
			basketConstituent = basketConstituentBuilder.stream().map(BasketConstituent::build).collect(Collectors.toList());
			objectValidator.validate(BasketConstituent.class, basketConstituent);
		}
		
		return basketConstituent;
	}

	protected abstract List<BasketConstituent.BasketConstituentBuilder> doEvaluate(Basket basket);

	public static class GetBasketDefault extends GetBasket {
		@Override
		protected List<BasketConstituent.BasketConstituentBuilder> doEvaluate(Basket basket) {
			List<BasketConstituent.BasketConstituentBuilder> basketConstituent = new ArrayList<>();
			return assignOutput(basketConstituent, basket);
		}
		
		protected List<BasketConstituent.BasketConstituentBuilder> assignOutput(List<BasketConstituent.BasketConstituentBuilder> basketConstituent, Basket basket) {
			if (exists(MapperS.of(basket).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", _basket -> _basket.getBasketConstituent())).getOrDefault(false)) {
				basketConstituent = toBuilder(MapperS.of(basket).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", _basket -> _basket.getBasketConstituent()).<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent.getValue()).getMulti());
			} else {
				basketConstituent = toBuilder(Collections.<BasketConstituent>emptyList());
			}
			
			return Optional.ofNullable(basketConstituent)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
