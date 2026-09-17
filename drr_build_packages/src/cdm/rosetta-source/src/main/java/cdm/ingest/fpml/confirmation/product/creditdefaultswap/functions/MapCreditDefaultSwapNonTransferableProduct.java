package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapNonTransferableProduct.MapCreditDefaultSwapNonTransferableProductDefault.class)
public abstract class MapCreditDefaultSwapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditDefaultSwapEconomicTerms mapCreditDefaultSwapEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCreditDefaultSwap 
	* @param fpmlTradeHeader 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCreditDefaultSwap, fpmlTradeHeader, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditDefaultSwapNonTransferableProductDefault extends MapCreditDefaultSwapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCreditDefaultSwap, fpmlTradeHeader, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCreditDefaultSwap).<ProductId>mapC("getProductId", creditDefaultSwap -> creditDefaultSwap.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCreditDefaultSwap).<AssetClass>map("getPrimaryAssetClass", creditDefaultSwap -> creditDefaultSwap.getPrimaryAssetClass()).get(), MapperS.of(fpmlCreditDefaultSwap).<AssetClass>mapC("getSecondaryAssetClass", creditDefaultSwap -> creditDefaultSwap.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCreditDefaultSwap).<ProductType>mapC("getProductType", creditDefaultSwap -> creditDefaultSwap.getProductType()).getMulti())))
				.setEconomicTerms(mapCreditDefaultSwapEconomicTerms.evaluate(fpmlCreditDefaultSwap, fpmlTradeHeader, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
