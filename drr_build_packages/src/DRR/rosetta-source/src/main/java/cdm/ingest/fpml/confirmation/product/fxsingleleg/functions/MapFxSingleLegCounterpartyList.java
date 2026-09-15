package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import cdm.ingest.fpml.confirmation.pricequantity.functions.GetFpmlExchangedCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxSingleLegCounterpartyList.MapFxSingleLegCounterpartyListDefault.class)
public abstract class MapFxSingleLegCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlExchangedCurrency getFpmlExchangedCurrency;
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlFxSingleLeg 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(FxSingleLeg fpmlFxSingleLeg) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlFxSingleLeg);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(FxSingleLeg fpmlFxSingleLeg);

	protected abstract MapperS<? extends Payment> fpmlExchangedCurrency(FxSingleLeg fpmlFxSingleLeg);

	public static class MapFxSingleLegCounterpartyListDefault extends MapFxSingleLegCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(FxSingleLeg fpmlFxSingleLeg) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlFxSingleLeg);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, FxSingleLeg fpmlFxSingleLeg) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(fpmlExchangedCurrency(fpmlFxSingleLeg).<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), fpmlExchangedCurrency(fpmlFxSingleLeg).<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Payment> fpmlExchangedCurrency(FxSingleLeg fpmlFxSingleLeg) {
			return MapperS.of(getFpmlExchangedCurrency.evaluate(MapperS.of(fpmlFxSingleLeg).<ExchangeRate>map("getExchangeRate", fxSingleLeg -> fxSingleLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency1", fxSingleLeg -> fxSingleLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency2", fxSingleLeg -> fxSingleLeg.getExchangedCurrency2()).get()));
		}
	}
}
