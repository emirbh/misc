package cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions;

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
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapTransactionSupplementNonTransferableProduct.MapVarianceSwapTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapVarianceSwapTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;
	@Inject protected MapVarianceSwapTransactionSupplementEconomicTerms mapVarianceSwapTransactionSupplementEconomicTerms;

	/**
	* @param fpmlVarianceSwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlVarianceSwapTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceSwapTransactionSupplementNonTransferableProductDefault extends MapVarianceSwapTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlVarianceSwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlVarianceSwapTransactionSupplement).<ProductId>mapC("getProductId", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlVarianceSwapTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlVarianceSwapTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlVarianceSwapTransactionSupplement).<ProductType>mapC("getProductType", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapVarianceSwapTransactionSupplementEconomicTerms.evaluate(fpmlVarianceSwapTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
