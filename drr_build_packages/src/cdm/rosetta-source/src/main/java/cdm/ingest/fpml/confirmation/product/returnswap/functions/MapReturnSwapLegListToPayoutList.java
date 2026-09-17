package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.shared.DirectionalLeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapLegListToPayoutList.MapReturnSwapLegListToPayoutListDefault.class)
public abstract class MapReturnSwapLegListToPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInterestLegToInterestRatePayout mapInterestLegToInterestRatePayout;
	@Inject protected MapReturnLegToPerformancePayout mapReturnLegToPerformancePayout;

	/**
	* @param fpmlReturnSwapLegList 
	* @param cdmCounterpartyList 
	* @return payoutList 
	*/
	public List<? extends Payout> evaluate(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutListBuilder = doEvaluate(fpmlReturnSwapLegList, cdmCounterpartyList);
		
		final List<? extends Payout> payoutList;
		if (payoutListBuilder == null) {
			payoutList = null;
		} else {
			payoutList = payoutListBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payoutList);
		}
		
		return payoutList;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends ReturnLeg> fpmlReturnLeg(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends InterestLeg> fpmlInterestLeg(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapReturnSwapLegListToPayoutListDefault extends MapReturnSwapLegListToPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlReturnSwapLegList == null) {
				fpmlReturnSwapLegList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payoutList = new ArrayList<>();
			return assignOutput(payoutList, fpmlReturnSwapLegList, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payoutList, List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList) {
			payoutList.addAll(toBuilder(MapperC.<DirectionalLeg>of(fpmlReturnSwapLegList)
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<Payout>ofNull();
					}
					if (switchArgument instanceof InterestLeg) {
						final InterestLeg interestLeg = (InterestLeg) switchArgument;
						return MapperS.of(mapInterestLegToInterestRatePayout.evaluate(interestLeg, cdmCounterpartyList, fpmlReturnLeg(fpmlReturnSwapLegList, cdmCounterpartyList).get()));
					}
					if (switchArgument instanceof ReturnLeg) {
						final ReturnLeg returnLeg = (ReturnLeg) switchArgument;
						return MapperS.of(mapReturnLegToPerformancePayout.evaluate(returnLeg, cdmCounterpartyList, fpmlInterestLeg(fpmlReturnSwapLegList, cdmCounterpartyList).get()));
					}
					return MapperS.<Payout>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(payoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReturnLeg> fpmlReturnLeg(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList) {
			final MapperC<ReturnLeg> thenArg = MapperC.<DirectionalLeg>of(fpmlReturnSwapLegList)
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<ReturnLeg>ofNull();
					}
					if (switchArgument instanceof ReturnLeg) {
						final ReturnLeg returnLeg = (ReturnLeg) switchArgument;
						return MapperS.of(returnLeg);
					}
					return MapperS.<ReturnLeg>ofNull();
				});
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends InterestLeg> fpmlInterestLeg(List<? extends DirectionalLeg> fpmlReturnSwapLegList, List<? extends Counterparty> cdmCounterpartyList) {
			final MapperC<InterestLeg> thenArg = MapperC.<DirectionalLeg>of(fpmlReturnSwapLegList)
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<InterestLeg>ofNull();
					}
					if (switchArgument instanceof InterestLeg) {
						final InterestLeg interestLeg = (InterestLeg) switchArgument;
						return MapperS.of(interestLeg);
					}
					return MapperS.<InterestLeg>ofNull();
				});
			return MapperS.of(thenArg.get());
		}
	}
}
