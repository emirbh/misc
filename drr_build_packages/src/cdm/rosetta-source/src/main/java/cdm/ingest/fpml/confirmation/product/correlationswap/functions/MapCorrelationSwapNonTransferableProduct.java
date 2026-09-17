package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationSwapNonTransferableProduct.MapCorrelationSwapNonTransferableProductDefault.class)
public abstract class MapCorrelationSwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorrelationSwapEconomicTerms mapCorrelationSwapEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCorrelationSwap 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCorrelationSwap, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCorrelationSwapNonTransferableProductDefault extends MapCorrelationSwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCorrelationSwap, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CorrelationSwap fpmlCorrelationSwap, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCorrelationSwap).<ProductId>mapC("getProductId", correlationSwap -> correlationSwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCorrelationSwap).<AssetClass>map("getPrimaryAssetClass", correlationSwap -> correlationSwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlCorrelationSwap).<AssetClass>mapC("getSecondaryAssetClass", correlationSwap -> correlationSwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCorrelationSwap).<ProductType>mapC("getProductType", correlationSwap -> correlationSwap.getProductType()).getMulti())))
				.setEconomicTerms(mapCorrelationSwapEconomicTerms.evaluate(fpmlCorrelationSwap, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
