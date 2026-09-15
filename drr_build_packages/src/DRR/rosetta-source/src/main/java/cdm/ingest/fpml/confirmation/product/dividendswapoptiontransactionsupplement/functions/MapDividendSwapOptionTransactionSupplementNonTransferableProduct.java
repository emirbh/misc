package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementNonTransferableProduct.MapDividendSwapOptionTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendSwapOptionTransactionSupplementEconomicTerms mapDividendSwapOptionTransactionSupplementEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapOptionTransactionSupplementNonTransferableProductDefault extends MapDividendSwapOptionTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<ProductId>mapC("getProductId", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<ProductType>mapC("getProductType", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapDividendSwapOptionTransactionSupplementEconomicTerms.evaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
