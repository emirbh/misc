package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.observable.event.TriggerEvent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.option.shared.Trigger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTriggerEvent.MapTriggerEventDefault.class)
public abstract class MapTriggerEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTrigger mapTrigger;

	/**
	* @param fpmlTriggerEvent 
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return triggerEvent 
	*/
	public TriggerEvent evaluate(fpml.consolidated.option.shared.TriggerEvent fpmlTriggerEvent, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		TriggerEvent.TriggerEventBuilder triggerEventBuilder = doEvaluate(fpmlTriggerEvent, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final TriggerEvent triggerEvent;
		if (triggerEventBuilder == null) {
			triggerEvent = null;
		} else {
			triggerEvent = triggerEventBuilder.build();
			objectValidator.validate(TriggerEvent.class, triggerEvent);
		}
		
		return triggerEvent;
	}

	protected abstract TriggerEvent.TriggerEventBuilder doEvaluate(fpml.consolidated.option.shared.TriggerEvent fpmlTriggerEvent, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapTriggerEventDefault extends MapTriggerEvent {
		@Override
		protected TriggerEvent.TriggerEventBuilder doEvaluate(fpml.consolidated.option.shared.TriggerEvent fpmlTriggerEvent, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			TriggerEvent.TriggerEventBuilder triggerEvent = TriggerEvent.builder();
			return assignOutput(triggerEvent, fpmlTriggerEvent, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected TriggerEvent.TriggerEventBuilder assignOutput(TriggerEvent.TriggerEventBuilder triggerEvent, fpml.consolidated.option.shared.TriggerEvent fpmlTriggerEvent, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			triggerEvent = toBuilder(TriggerEvent.builder()
				.setTrigger(mapTrigger.evaluate(MapperS.of(fpmlTriggerEvent).<Trigger>map("getTrigger", _triggerEvent -> _triggerEvent.getTrigger()).get(), fpmlCreditDefaultSwapOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(triggerEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
