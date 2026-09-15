package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.observable.event.TriggerEvent;
import cdm.product.template.Knock;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapKnock.MapKnockDefault.class)
public abstract class MapKnock implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTriggerEvent mapTriggerEvent;

	/**
	* @param fpmlKnock 
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return knock 
	*/
	public Knock evaluate(fpml.consolidated.option.shared.Knock fpmlKnock, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		Knock.KnockBuilder knockBuilder = doEvaluate(fpmlKnock, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final Knock knock;
		if (knockBuilder == null) {
			knock = null;
		} else {
			knock = knockBuilder.build();
			objectValidator.validate(Knock.class, knock);
		}
		
		return knock;
	}

	protected abstract Knock.KnockBuilder doEvaluate(fpml.consolidated.option.shared.Knock fpmlKnock, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapKnockDefault extends MapKnock {
		@Override
		protected Knock.KnockBuilder doEvaluate(fpml.consolidated.option.shared.Knock fpmlKnock, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Knock.KnockBuilder knock = Knock.builder();
			return assignOutput(knock, fpmlKnock, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected Knock.KnockBuilder assignOutput(Knock.KnockBuilder knock, fpml.consolidated.option.shared.Knock fpmlKnock, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			final List<TriggerEvent> ifThenElseResult0;
			if (exists(MapperS.of(fpmlKnock).<fpml.consolidated.option.shared.TriggerEvent>map("getKnockIn", _knock -> _knock.getKnockIn())).getOrDefault(false)) {
				final TriggerEvent triggerEvent0 = mapTriggerEvent.evaluate(MapperS.of(fpmlKnock).<fpml.consolidated.option.shared.TriggerEvent>map("getKnockIn", _knock -> _knock.getKnockIn()).get(), fpmlCreditDefaultSwapOption, cdmCounterpartyList);
				ifThenElseResult0 = triggerEvent0 == null ? Collections.<TriggerEvent>emptyList() : Collections.singletonList(triggerEvent0);
			} else {
				ifThenElseResult0 = Collections.<TriggerEvent>emptyList();
			}
			final List<TriggerEvent> ifThenElseResult1;
			if (exists(MapperS.of(fpmlKnock).<fpml.consolidated.option.shared.TriggerEvent>map("getKnockOut", _knock -> _knock.getKnockOut())).getOrDefault(false)) {
				final TriggerEvent triggerEvent1 = mapTriggerEvent.evaluate(MapperS.of(fpmlKnock).<fpml.consolidated.option.shared.TriggerEvent>map("getKnockOut", _knock -> _knock.getKnockOut()).get(), fpmlCreditDefaultSwapOption, cdmCounterpartyList);
				ifThenElseResult1 = triggerEvent1 == null ? Collections.<TriggerEvent>emptyList() : Collections.singletonList(triggerEvent1);
			} else {
				ifThenElseResult1 = Collections.<TriggerEvent>emptyList();
			}
			knock = toBuilder(Knock.builder()
				.setKnockIn(ifThenElseResult0)
				.setKnockOut(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(knock)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
