package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.Index;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasketConstituentWithLocation.MapBasketConstituentWithLocationDefault.class)
public abstract class MapBasketConstituentWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BasketConstituentKeyValue basketConstituentKeyValue;
	@Inject protected CreateBasketConstituentWithLocation createBasketConstituentWithLocation;
	@Inject protected MapAsset mapAsset;
	@Inject protected MapBasketConstituentQuantity mapBasketConstituentQuantity;
	@Inject protected MapEquityIndex mapEquityIndex;

	/**
	* @param fpmlBasketConstituent 
	* @return basketConstituent 
	*/
	public FieldWithMetaBasketConstituent evaluate(BasketConstituent fpmlBasketConstituent) {
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituentBuilder = doEvaluate(fpmlBasketConstituent);
		
		final FieldWithMetaBasketConstituent basketConstituent;
		if (basketConstituentBuilder == null) {
			basketConstituent = null;
		} else {
			basketConstituent = basketConstituentBuilder.build();
			objectValidator.validate(FieldWithMetaBasketConstituent.class, basketConstituent);
		}
		
		return basketConstituent;
	}

	protected abstract FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent fpmlBasketConstituent);

	protected abstract MapperS<? extends Asset> fpmlUnderlyingAsset(BasketConstituent fpmlBasketConstituent);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> basketConstituentQuantity(BasketConstituent fpmlBasketConstituent);

	protected abstract MapperS<? extends cdm.observable.asset.BasketConstituent> basketConstituentWithoutLocation(BasketConstituent fpmlBasketConstituent);

	public static class MapBasketConstituentWithLocationDefault extends MapBasketConstituentWithLocation {
		@Override
		protected FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent fpmlBasketConstituent) {
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituent = FieldWithMetaBasketConstituent.builder();
			return assignOutput(basketConstituent, fpmlBasketConstituent);
		}
		
		protected FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder assignOutput(FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituent, BasketConstituent fpmlBasketConstituent) {
			basketConstituent = toBuilder(createBasketConstituentWithLocation.evaluate(basketConstituentWithoutLocation(fpmlBasketConstituent).get(), basketConstituentKeyValue.evaluate(fpmlBasketConstituent)));
			
			return Optional.ofNullable(basketConstituent)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Asset> fpmlUnderlyingAsset(BasketConstituent fpmlBasketConstituent) {
			return MapperS.of(fpmlBasketConstituent).<Asset>map("getUnderlyingAsset", basketConstituent -> basketConstituent.getUnderlyingAsset());
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> basketConstituentQuantity(BasketConstituent fpmlBasketConstituent) {
			return MapperC.<NonNegativeQuantitySchedule>of(mapBasketConstituentQuantity.evaluate(fpmlBasketConstituent));
		}
		
		@Override
		protected MapperS<? extends cdm.observable.asset.BasketConstituent> basketConstituentWithoutLocation(BasketConstituent fpmlBasketConstituent) {
			final Asset switchArgument = fpmlUnderlyingAsset(fpmlBasketConstituent).get();
			if (switchArgument == null) {
				return MapperS.<cdm.observable.asset.BasketConstituent>ofNull();
			}
			if (switchArgument instanceof Index) {
				final Index index = (Index) switchArgument;
				return MapperS.of(cdm.observable.asset.BasketConstituent.builder()
					.setIndex(mapEquityIndex.evaluate(index))
					.setQuantityValue(new ArrayList<>(basketConstituentQuantity(fpmlBasketConstituent).getMulti()))
					.build());
			}
			return MapperS.of(cdm.observable.asset.BasketConstituent.builder()
				.setAsset(mapAsset.evaluate(fpmlUnderlyingAsset(fpmlBasketConstituent).get()))
				.setQuantityValue(new ArrayList<>(basketConstituentQuantity(fpmlBasketConstituent).getMulti()))
				.build());
		}
	}
}
