package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapProductIdentifierList;
import cdm.ingest.fpml.confirmation.common.functions.MapProductTaxonomyList;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionNonTransferableProduct.MapCreditDefaultSwapOptionNonTransferableProductDefault.class)
public abstract class MapCreditDefaultSwapOptionNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditDefaultSwapOptionEconomicTerms mapCreditDefaultSwapOptionEconomicTerms;
	@Inject protected MapProductIdentifierList mapProductIdentifierList;
	@Inject protected MapProductTaxonomyList mapProductTaxonomyList;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @param fpmlTradeHeader 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader);

	public static class MapCreditDefaultSwapOptionNonTransferableProductDefault extends MapCreditDefaultSwapOptionNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setIdentifier(new ArrayList(mapProductIdentifierList.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<ProductId>mapC("getProductId", creditDefaultSwapOption -> creditDefaultSwapOption.getProductId()).getMulti())))
				.setTaxonomy(new ArrayList(mapProductTaxonomyList.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<AssetClass>map("getPrimaryAssetClass", creditDefaultSwapOption -> creditDefaultSwapOption.getPrimaryAssetClass()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<AssetClass>mapC("getSecondaryAssetClass", creditDefaultSwapOption -> creditDefaultSwapOption.getSecondaryAssetClass()).getMulti(), MapperS.of(fpmlCreditDefaultSwapOption).<ProductType>mapC("getProductType", creditDefaultSwapOption -> creditDefaultSwapOption.getProductType()).getMulti())))
				.setEconomicTerms(mapCreditDefaultSwapOptionEconomicTerms.evaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
