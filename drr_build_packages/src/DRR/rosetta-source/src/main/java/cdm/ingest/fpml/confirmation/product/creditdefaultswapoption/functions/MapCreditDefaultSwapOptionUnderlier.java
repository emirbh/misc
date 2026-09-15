package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapEconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.doc.TradeHeader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionUnderlier.MapCreditDefaultSwapOptionUnderlierDefault.class)
public abstract class MapCreditDefaultSwapOptionUnderlier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditDefaultSwapEconomicTerms mapCreditDefaultSwapEconomicTerms;

	/**
	* @param fpmlCreditDefaultSwapOptionDetailsModel 
	* @param cdmCounterpartyList 
	* @param fpmlTradeHeader 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(CreditDefaultSwap fpmlCreditDefaultSwapOptionDetailsModel, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlCreditDefaultSwapOptionDetailsModel, cdmCounterpartyList, fpmlTradeHeader);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwapOptionDetailsModel, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader);

	public static class MapCreditDefaultSwapOptionUnderlierDefault extends MapCreditDefaultSwapOptionUnderlier {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwapOptionDetailsModel, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlCreditDefaultSwapOptionDetailsModel, cdmCounterpartyList, fpmlTradeHeader);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, CreditDefaultSwap fpmlCreditDefaultSwapOptionDetailsModel, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
				.setEconomicTerms(mapCreditDefaultSwapEconomicTerms.evaluate(fpmlCreditDefaultSwapOptionDetailsModel, fpmlTradeHeader, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
