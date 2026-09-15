package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.observable.event.Trigger;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.option.shared.CreditEventsReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTrigger.MapTriggerDefault.class)
public abstract class MapTrigger implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEventsReferenceWithReference mapCreditEventsReferenceWithReference;

	/**
	* @param fpmlTrigger 
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return trigger 
	*/
	public Trigger evaluate(fpml.consolidated.option.shared.Trigger fpmlTrigger, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		Trigger.TriggerBuilder triggerBuilder = doEvaluate(fpmlTrigger, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final Trigger trigger;
		if (triggerBuilder == null) {
			trigger = null;
		} else {
			trigger = triggerBuilder.build();
			objectValidator.validate(Trigger.class, trigger);
		}
		
		return trigger;
	}

	protected abstract Trigger.TriggerBuilder doEvaluate(fpml.consolidated.option.shared.Trigger fpmlTrigger, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapTriggerDefault extends MapTrigger {
		@Override
		protected Trigger.TriggerBuilder doEvaluate(fpml.consolidated.option.shared.Trigger fpmlTrigger, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Trigger.TriggerBuilder trigger = Trigger.builder();
			return assignOutput(trigger, fpmlTrigger, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected Trigger.TriggerBuilder assignOutput(Trigger.TriggerBuilder trigger, fpml.consolidated.option.shared.Trigger fpmlTrigger, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			trigger = toBuilder(Trigger.builder()
				.setCreditEventsReference(mapCreditEventsReferenceWithReference.evaluate(MapperS.of(fpmlTrigger).<CreditEventsReference>map("getCreditEventsReference", _trigger -> _trigger.getCreditEventsReference()).get(), fpmlCreditDefaultSwapOption, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(trigger)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
