package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVarianceSwapNonTransferableProduct.MapFxVarianceSwapNonTransferableProductDefault.class)
public abstract class MapFxVarianceSwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxVarianceSwapEconomicTerms mapFxVarianceSwapEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlFxVarianceSwap 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlFxVarianceSwap, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVarianceSwapNonTransferableProductDefault extends MapFxVarianceSwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlFxVarianceSwap, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlFxVarianceSwap).<ProductId>mapC("getProductId", fxVarianceSwap -> fxVarianceSwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlFxVarianceSwap).<AssetClass>map("getPrimaryAssetClass", fxVarianceSwap -> fxVarianceSwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlFxVarianceSwap).<AssetClass>mapC("getSecondaryAssetClass", fxVarianceSwap -> fxVarianceSwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlFxVarianceSwap).<ProductType>mapC("getProductType", fxVarianceSwap -> fxVarianceSwap.getProductType()).getMulti())))
				.setEconomicTerms(mapFxVarianceSwapEconomicTerms.evaluate(fpmlFxVarianceSwap, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
