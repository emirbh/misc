package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCashSettlementToSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.SwaptionTypeEnum;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwaptionPayout.MapSwaptionPayoutDefault.class)
public abstract class MapSwaptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCashSettlementToSettlementTerms mapCashSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapSwapNonTransferableProduct mapSwapNonTransferableProduct;
	@Inject protected MapSwaptionPhysicalSettlementToSettlementTerms mapSwaptionPhysicalSettlementToSettlementTerms;

	/**
	* @param fpmlSwaption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlSwaption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwaptionPayoutDefault extends MapSwaptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlSwaption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			final SettlementTerms ifThenElseResult0;
			if (exists(MapperS.of(fpmlSwaption).<CashSettlement>map("getCashSettlement", swaption -> swaption.getCashSettlement())).getOrDefault(false)) {
				ifThenElseResult0 = mapCashSettlementToSettlementTerms.evaluate(MapperS.of(fpmlSwaption).<CashSettlement>map("getCashSettlement", swaption -> swaption.getCashSettlement()).get());
			} else {
				ifThenElseResult0 = mapSwaptionPhysicalSettlementToSettlementTerms.evaluate(MapperS.of(fpmlSwaption).<SwaptionPhysicalSettlement>map("getPhysicalSettlement", swaption -> swaption.getPhysicalSettlement()).get());
			}
			final OptionTypeEnum ifThenElseResult1;
			if (areEqual(MapperS.of(fpmlSwaption).<Boolean>map("getSwaptionStraddle", swaption -> swaption.getSwaptionStraddle()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OptionTypeEnum.STRADDLE;
			} else if (areEqual(MapperS.of(fpmlSwaption).<SwaptionTypeEnum>map("getOptionType", swaption -> swaption.getOptionType()).checkedMap("to-enum", e -> SwaptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class), MapperS.of(SwaptionTypeEnum.PAYER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OptionTypeEnum.PAYER;
			} else {
				ifThenElseResult1 = null;
			}
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlSwaption).<PartyReference>map("getSellerPartyReference", swaption -> swaption.getSellerPartyReference()).get(), MapperS.of(fpmlSwaption).<PartyReference>map("getBuyerPartyReference", swaption -> swaption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setSettlementTerms(ifThenElseResult0)
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlSwaption).<PartyReference>map("getBuyerPartyReference", swaption -> swaption.getBuyerPartyReference()).get(), MapperS.of(fpmlSwaption).<PartyReference>map("getSellerPartyReference", swaption -> swaption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setProduct(Product.builder()
							.setNonTransferableProduct(mapSwapNonTransferableProduct.evaluate(MapperS.of(fpmlSwaption).<Swap>map("getSwap", swaption -> swaption.getSwap()).get(), cdmCounterpartyList))
							.build())
						.build())
					.setOptionType(ifThenElseResult1)
					.setExerciseTerms(mapExerciseTerms.evaluate(MapperS.of(fpmlSwaption).<Exercise>map("getExercise", swaption -> swaption.getExercise()).get(), MapperS.of(fpmlSwaption).<ExerciseProcedure>map("getExerciseProcedure", swaption -> swaption.getExerciseProcedure()).get(), null, MapperS.of(fpmlSwaption).<PartyReference>map("getBuyerPartyReference", swaption -> swaption.getBuyerPartyReference()).get(), MapperS.of(fpmlSwaption).<PartyReference>map("getSellerPartyReference", swaption -> swaption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
