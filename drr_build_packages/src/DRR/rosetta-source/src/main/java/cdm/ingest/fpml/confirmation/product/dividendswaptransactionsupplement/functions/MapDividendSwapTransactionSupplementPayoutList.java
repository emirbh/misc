package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementPayoutList.MapDividendSwapTransactionSupplementPayoutListDefault.class)
public abstract class MapDividendSwapTransactionSupplementPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendLegToPerformancePayout mapDividendLegToPerformancePayout;
	@Inject protected MapFixedPaymentLegToFixedPricePayout mapFixedPaymentLegToFixedPricePayout;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return payoutList 
	*/
	public List<? extends Payout> evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutListBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		
		final List<? extends Payout> payoutList;
		if (payoutListBuilder == null) {
			payoutList = null;
		} else {
			payoutList = payoutListBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payoutList);
		}
		
		return payoutList;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapTransactionSupplementPayoutListDefault extends MapDividendSwapTransactionSupplementPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payoutList = new ArrayList<>();
			return assignOutput(payoutList, fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payoutList, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout0 = mapDividendLegToPerformancePayout.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).get(), cdmCounterpartyList);
			if (payout0 == null) {
				payoutList.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payoutList.addAll(toBuilder(Collections.singletonList(payout0)));
			}
			
			final Payout payout1 = mapFixedPaymentLegToFixedPricePayout.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<FixedPaymentLeg>map("getFixedLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getFixedLeg()).get(), MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).get(), cdmCounterpartyList);
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
