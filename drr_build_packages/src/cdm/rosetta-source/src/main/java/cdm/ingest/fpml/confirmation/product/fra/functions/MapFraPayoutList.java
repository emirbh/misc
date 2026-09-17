package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDate;
import cdm.ingest.fpml.confirmation.other.functions.MapDayCountFractionEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.product.asset.DiscountingMethod;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.FraDiscountingEnum;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFraPayoutList.MapFraPayoutListDefault.class)
public abstract class MapFraPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapDayCountFractionEnum mapDayCountFractionEnum;
	@Inject protected MapFraCalculationPeriodDates mapFraCalculationPeriodDates;
	@Inject protected MapFraDiscountingMethod mapFraDiscountingMethod;
	@Inject protected MapFraToFixedInterestRatePayout mapFraToFixedInterestRatePayout;
	@Inject protected MapFraToFloatingInterestRatePayout mapFraToFloatingInterestRatePayout;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlFra 
	* @param cdmCounterpartyList 
	* @return payoutList 
	*/
	public List<? extends Payout> evaluate(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutListBuilder = doEvaluate(fpmlFra, cdmCounterpartyList);
		
		final List<? extends Payout> payoutList;
		if (payoutListBuilder == null) {
			payoutList = null;
		} else {
			payoutList = payoutListBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payoutList);
		}
		
		return payoutList;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends PayerReceiver> floatingPayerReceiver(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<DayCountFractionEnum> dayCountFraction(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends CalculationPeriodDates> calculationPeriodDates(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends AdjustableDate> paymentDate(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends DiscountingMethod> discountingMethod(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFraPayoutListDefault extends MapFraPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payoutList = new ArrayList<>();
			return assignOutput(payoutList, fpmlFra, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payoutList, Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout0 = mapFraToFixedInterestRatePayout.evaluate(fpmlFra, floatingPayerReceiver(fpmlFra, cdmCounterpartyList).get(), dayCountFraction(fpmlFra, cdmCounterpartyList).get(), calculationPeriodDates(fpmlFra, cdmCounterpartyList).get(), paymentDate(fpmlFra, cdmCounterpartyList).get(), discountingMethod(fpmlFra, cdmCounterpartyList).get());
			if (payout0 == null) {
				payoutList.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payoutList.addAll(toBuilder(Collections.singletonList(payout0)));
			}
			
			final Payout payout1 = mapFraToFloatingInterestRatePayout.evaluate(fpmlFra, floatingPayerReceiver(fpmlFra, cdmCounterpartyList).get(), dayCountFraction(fpmlFra, cdmCounterpartyList).get(), calculationPeriodDates(fpmlFra, cdmCounterpartyList).get(), paymentDate(fpmlFra, cdmCounterpartyList).get(), discountingMethod(fpmlFra, cdmCounterpartyList).get());
			if (payout1 == null) {
				payoutList.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payoutList.addAll(toBuilder(Collections.singletonList(payout1)));
			}
			
			return Optional.ofNullable(payoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PayerReceiver> floatingPayerReceiver(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlFra).<PartyReference>map("getSellerPartyReference", fra -> fra.getSellerPartyReference()).get(), MapperS.of(fpmlFra).<PartyReference>map("getBuyerPartyReference", fra -> fra.getBuyerPartyReference()).get(), cdmCounterpartyList));
		}
		
		@Override
		protected MapperS<DayCountFractionEnum> dayCountFraction(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapDayCountFractionEnum.evaluate(MapperS.of(fpmlFra).<DayCountFraction>map("getDayCountFraction", fra -> fra.getDayCountFraction()).<String>map("getValue", _dayCountFraction -> _dayCountFraction.getValue()).get()));
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodDates> calculationPeriodDates(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapFraCalculationPeriodDates.evaluate(fpmlFra));
		}
		
		@Override
		protected MapperS<? extends AdjustableDate> paymentDate(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapAdjustableDate.evaluate(MapperS.of(fpmlFra).<fpml.consolidated.shared.AdjustableDate>map("getPaymentDate", fra -> fra.getPaymentDate()).get()));
		}
		
		@Override
		protected MapperS<? extends DiscountingMethod> discountingMethod(Fra fpmlFra, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapFraDiscountingMethod.evaluate(MapperS.of(fpmlFra).<FraDiscountingEnum>map("getFraDiscounting", fra -> fra.getFraDiscounting()).get()));
		}
	}
}
