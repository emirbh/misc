package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapNonTransferableProduct.MapVolatilitySwapNonTransferableProductDefault.class)
public abstract class MapVolatilitySwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;
	@Inject protected MapVolatilitySwapEconomicTerms mapVolatilitySwapEconomicTerms;

	/**
	* @param fpmlVolatilitySwap 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlVolatilitySwap, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVolatilitySwapNonTransferableProductDefault extends MapVolatilitySwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlVolatilitySwap, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlVolatilitySwap).<ProductId>mapC("getProductId", volatilitySwap -> volatilitySwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlVolatilitySwap).<AssetClass>map("getPrimaryAssetClass", volatilitySwap -> volatilitySwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlVolatilitySwap).<AssetClass>mapC("getSecondaryAssetClass", volatilitySwap -> volatilitySwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlVolatilitySwap).<ProductType>mapC("getProductType", volatilitySwap -> volatilitySwap.getProductType()).getMulti())))
				.setEconomicTerms(mapVolatilitySwapEconomicTerms.evaluate(fpmlVolatilitySwap, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
