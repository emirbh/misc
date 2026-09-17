package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

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
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementNonTransferableProduct.MapVarianceOptionTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapVarianceOptionTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;
	@Inject protected MapVarianceOptionTransactionSupplementEconomicTerms mapVarianceOptionTransactionSupplementEconomicTerms;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceOptionTransactionSupplementNonTransferableProductDefault extends MapVarianceOptionTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<ProductId>mapC("getProductId", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<ProductType>mapC("getProductType", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapVarianceOptionTransactionSupplementEconomicTerms.evaluate(fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
