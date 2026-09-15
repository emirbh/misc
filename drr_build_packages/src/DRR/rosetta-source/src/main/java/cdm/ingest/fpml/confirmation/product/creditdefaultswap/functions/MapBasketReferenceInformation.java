package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.ReferencePool;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasketId;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.cd.ReferencePoolItem;
import fpml.consolidated.cd.Tranche;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBasketReferenceInformation.MapBasketReferenceInformationDefault.class)
public abstract class MapBasketReferenceInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReferencePoolItem mapReferencePoolItem;
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapTranche mapTranche;

	/**
	* @param fpmlBasketReferenceInformation 
	* @return basketReferenceInformation 
	*/
	public BasketReferenceInformation evaluate(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation) {
		BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformationBuilder = doEvaluate(fpmlBasketReferenceInformation);
		
		final BasketReferenceInformation basketReferenceInformation;
		if (basketReferenceInformationBuilder == null) {
			basketReferenceInformation = null;
		} else {
			basketReferenceInformation = basketReferenceInformationBuilder.build();
			objectValidator.validate(BasketReferenceInformation.class, basketReferenceInformation);
		}
		
		return basketReferenceInformation;
	}

	protected abstract BasketReferenceInformation.BasketReferenceInformationBuilder doEvaluate(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation);

	protected abstract MapperS<? extends BasketName> basketName(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation);

	protected abstract MapperC<? extends BasketId> basketIdList(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation);

	public static class MapBasketReferenceInformationDefault extends MapBasketReferenceInformation {
		@Override
		protected BasketReferenceInformation.BasketReferenceInformationBuilder doEvaluate(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation) {
			BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation = BasketReferenceInformation.builder();
			return assignOutput(basketReferenceInformation, fpmlBasketReferenceInformation);
		}
		
		protected BasketReferenceInformation.BasketReferenceInformationBuilder assignOutput(BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation, fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation) {
			if (exists(MapperS.of(fpmlBasketReferenceInformation)).getOrDefault(false)) {
				basketReferenceInformation = toBuilder(BasketReferenceInformation.builder()
					.setBasketName(mapStringWithScheme.evaluate(basketName(fpmlBasketReferenceInformation).<String>map("getValue", _basketName -> _basketName.getValue()).get(), basketName(fpmlBasketReferenceInformation).<String>map("getBasketNameScheme", _basketName -> _basketName.getBasketNameScheme()).get()))
					.setBasketId(basketIdList(fpmlBasketReferenceInformation)
						.mapItem(item -> MapperS.of(mapStringWithScheme.evaluate(item.<String>map("getValue", basketId -> basketId.getValue()).get(), item.<String>map("getBasketIdScheme", basketId -> basketId.getBasketIdScheme()).get()))).getMulti())
					.setReferencePool(ReferencePool.builder()
						.setReferencePoolItem(MapperS.of(fpmlBasketReferenceInformation).<fpml.consolidated.cd.ReferencePool>map("getReferencePool", _basketReferenceInformation -> _basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem())
							.mapItem(item -> MapperS.of(mapReferencePoolItem.evaluate(item.get()))).getMulti())
						.build())
					.setNthToDefault(MapperS.of(fpmlBasketReferenceInformation).<Integer>map("getNthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getNthToDefault()).get())
					.setMthToDefault(MapperS.of(fpmlBasketReferenceInformation).<Integer>map("getMthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getMthToDefault()).get())
					.setTranche(mapTranche.evaluate(MapperS.of(fpmlBasketReferenceInformation).<Tranche>map("getTranche", _basketReferenceInformation -> _basketReferenceInformation.getTranche()).get()))
					.build());
			} else {
				basketReferenceInformation = null;
			}
			
			return Optional.ofNullable(basketReferenceInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BasketName> basketName(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation) {
			return MapperS.of(fpmlBasketReferenceInformation).<BasketName>map("getBasketName", basketReferenceInformation -> basketReferenceInformation.getBasketName());
		}
		
		@Override
		protected MapperC<? extends BasketId> basketIdList(fpml.consolidated.cd.BasketReferenceInformation fpmlBasketReferenceInformation) {
			return MapperS.of(fpmlBasketReferenceInformation).<BasketId>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId());
		}
	}
}
