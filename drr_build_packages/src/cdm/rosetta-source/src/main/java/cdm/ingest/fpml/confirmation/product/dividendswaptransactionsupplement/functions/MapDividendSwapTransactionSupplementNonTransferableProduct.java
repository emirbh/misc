package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementNonTransferableProduct.MapDividendSwapTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapDividendSwapTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendSwapTransactionSupplementEconomicTerms mapDividendSwapTransactionSupplementEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapTransactionSupplementNonTransferableProductDefault extends MapDividendSwapTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<ProductId>mapC("getProductId", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlDividendSwapTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlDividendSwapTransactionSupplement).<ProductType>mapC("getProductType", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapDividendSwapTransactionSupplementEconomicTerms.evaluate(fpmlDividendSwapTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
