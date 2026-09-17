package cdm.ingest.fpml.confirmation.product.fxswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.fxsingleleg.functions.MapFxCoreDetailsModelToSettlementPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Payment;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxSwapPayoutList.MapFxSwapPayoutListDefault.class)
public abstract class MapFxSwapPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxCoreDetailsModelToSettlementPayout mapFxCoreDetailsModelToSettlementPayout;

	/**
	* @param fpmlFxSwap 
	* @param cdmCounterpartyList 
	* @return payoutList 
	*/
	public List<? extends Payout> evaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutListBuilder = doEvaluate(fpmlFxSwap, cdmCounterpartyList);
		
		final List<? extends Payout> payoutList;
		if (payoutListBuilder == null) {
			payoutList = null;
		} else {
			payoutList = payoutListBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payoutList);
		}
		
		return payoutList;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxSwapPayoutListDefault extends MapFxSwapPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payoutList = new ArrayList<>();
			return assignOutput(payoutList, fpmlFxSwap, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payoutList, FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout0 = mapFxCoreDetailsModelToSettlementPayout.evaluate(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<ExchangeRate>map("getExchangeRate", fxSwapLeg -> fxSwapLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<FxCashSettlement>map("getNonDeliverableSettlement", fxSwapLeg -> fxSwapLeg.getNonDeliverableSettlement()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<ZonedDateTime>map("getValueDate", fxSwapLeg -> fxSwapLeg.getValueDate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).get(), cdmCounterpartyList);
			if (payout0 == null) {
				payoutList.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payoutList.addAll(toBuilder(Collections.singletonList(payout0)));
			}
			
			final Payout payout1 = mapFxCoreDetailsModelToSettlementPayout.evaluate(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<ExchangeRate>map("getExchangeRate", fxSwapLeg -> fxSwapLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<FxCashSettlement>map("getNonDeliverableSettlement", fxSwapLeg -> fxSwapLeg.getNonDeliverableSettlement()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<ZonedDateTime>map("getValueDate", fxSwapLeg -> fxSwapLeg.getValueDate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).get(), cdmCounterpartyList);
			if (payout1 == null) {
				payoutList.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payoutList.addAll(toBuilder(Collections.singletonList(payout1)));
			}
			
			return Optional.ofNullable(payoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
