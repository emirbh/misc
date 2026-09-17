package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapCounterpartyList.MapCreditDefaultSwapCounterpartyListDefault.class)
public abstract class MapCreditDefaultSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterparty mapCounterparty;

	/**
	* @param fpmlCreditDefaultSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(CreditDefaultSwap fpmlCreditDefaultSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlCreditDefaultSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap);

	public static class MapCreditDefaultSwapCounterpartyListDefault extends MapCreditDefaultSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlCreditDefaultSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, CreditDefaultSwap fpmlCreditDefaultSwap) {
			final Counterparty counterparty0 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_1, MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<PartyReference>map("getSellerPartyReference", generalTerms -> generalTerms.getSellerPartyReference()).get());
			if (counterparty0 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty0)));
			}
			
			final Counterparty counterparty1 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_2, MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<PartyReference>map("getBuyerPartyReference", generalTerms -> generalTerms.getBuyerPartyReference()).get());
			if (counterparty1 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty1)));
			}
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
