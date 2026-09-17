package cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionTransactionSupplementNonTransferableProduct.MapEquityOptionTransactionSupplementNonTransferableProductDefault.class)
public abstract class MapEquityOptionTransactionSupplementNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityOptionTransactionSupplementEconomicTerms mapEquityOptionTransactionSupplementEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlEquityOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityOptionTransactionSupplementNonTransferableProductDefault extends MapEquityOptionTransactionSupplementNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<ProductId>mapC("getProductId", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<AssetClass>map("getPrimaryAssetClass", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getPrimaryAssetClass()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<AssetClass>mapC("getSecondaryAssetClass", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlEquityOptionTransactionSupplement).<ProductType>mapC("getProductType", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getProductType()).getMulti())))
				.setEconomicTerms(mapEquityOptionTransactionSupplementEconomicTerms.evaluate(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
