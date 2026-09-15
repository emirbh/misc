package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVolatilitySwapNonTransferableProduct.MapFxVolatilitySwapNonTransferableProductDefault.class)
public abstract class MapFxVolatilitySwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxVolatilitySwapEconomicTerms mapFxVolatilitySwapEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlFxVolatilitySwap 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlFxVolatilitySwap, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVolatilitySwapNonTransferableProductDefault extends MapFxVolatilitySwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlFxVolatilitySwap, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlFxVolatilitySwap).<ProductId>mapC("getProductId", fxVolatilitySwap -> fxVolatilitySwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlFxVolatilitySwap).<AssetClass>map("getPrimaryAssetClass", fxVolatilitySwap -> fxVolatilitySwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlFxVolatilitySwap).<AssetClass>mapC("getSecondaryAssetClass", fxVolatilitySwap -> fxVolatilitySwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlFxVolatilitySwap).<ProductType>mapC("getProductType", fxVolatilitySwap -> fxVolatilitySwap.getProductType()).getMulti())))
				.setEconomicTerms(mapFxVolatilitySwapEconomicTerms.evaluate(fpmlFxVolatilitySwap, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
