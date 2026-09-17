package cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions;

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
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapTransactionSupplementNonTransferableProduct.MapVolatilitySwapTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapVolatilitySwapTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;
	@Inject protected MapVolatilitySwapTransactionSupplementEconomicTerms mapVolatilitySwapTransactionSupplementEconomicTerms;

	/**
	* @param fpmlVolatilitySwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlVolatilitySwapTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVolatilitySwapTransactionSupplementNonTransferableProductDefault extends MapVolatilitySwapTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlVolatilitySwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlVolatilitySwapTransactionSupplement).<ProductId>mapC("getProductId", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlVolatilitySwapTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlVolatilitySwapTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlVolatilitySwapTransactionSupplement).<ProductType>mapC("getProductType", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapVolatilitySwapTransactionSupplementEconomicTerms.evaluate(fpmlVolatilitySwapTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
