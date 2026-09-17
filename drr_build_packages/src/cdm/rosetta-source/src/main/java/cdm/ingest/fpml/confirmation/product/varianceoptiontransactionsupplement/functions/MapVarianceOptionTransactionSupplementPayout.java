package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlEquityExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.settlement.functions.MapEquityExerciseValuationSettlementToSettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementPayout.MapVarianceOptionTransactionSupplementPayoutDefault.class)
public abstract class MapVarianceOptionTransactionSupplementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlEquityExercise getFpmlEquityExercise;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapEquityExerciseValuationSettlementToSettlementTerms mapEquityExerciseValuationSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapVarianceSwapTransactionSupplementNonTransferableProduct mapVarianceSwapTransactionSupplementNonTransferableProduct;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceOptionTransactionSupplementPayoutDefault extends MapVarianceOptionTransactionSupplementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSellerPartyReference()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setSettlementTerms(mapEquityExerciseValuationSettlementToSettlementTerms.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getEquityExercise()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<SwaptionPhysicalSettlement>map("getClearingInstructions", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getClearingInstructions()).get()))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setProduct(Product.builder()
							.setNonTransferableProduct(mapVarianceSwapTransactionSupplementNonTransferableProduct.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<VarianceSwapTransactionSupplement>map("getVarianceSwapTransactionSupplement", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getVarianceSwapTransactionSupplement()).get(), cdmCounterpartyList))
							.build())
						.build())
					.setOptionType(MapperS.of(fpmlVarianceOptionTransactionSupplement).<OptionTypeEnum>map("getOptionType", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getOptionType()).checkedMap("to-enum", e -> cdm.product.template.OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlEquityExercise.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<EquityExerciseValuationSettlement>map("getEquityExercise", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getEquityExercise()).get()), null, null, MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSellerPartyReference()).get(), cdmCounterpartyList))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
