package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlEquityExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions.MapDividendSwapTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.settlement.functions.MapEquityExerciseValuationSettlementToSettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementPayout.MapDividendSwapOptionTransactionSupplementPayoutDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlEquityExercise getFpmlEquityExercise;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapDividendSwapTransactionSupplementNonTransferableProduct mapDividendSwapTransactionSupplementNonTransferableProduct;
	@Inject protected MapEquityExerciseValuationSettlementToSettlementTerms mapEquityExerciseValuationSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapOptionTransactionSupplementPayoutDefault extends MapDividendSwapOptionTransactionSupplementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSellerPartyReference()).get(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setSettlementTerms(mapEquityExerciseValuationSettlementToSettlementTerms.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getEquityExercise()).get(), null))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setProduct(Product.builder()
							.setNonTransferableProduct(mapDividendSwapTransactionSupplementNonTransferableProduct.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<DividendSwapTransactionSupplement>map("getDividendSwapTransactionSupplement", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getDividendSwapTransactionSupplement()).get(), cdmCounterpartyList))
							.build())
						.build())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlEquityExercise.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getEquityExercise()).get()), null, null, MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
