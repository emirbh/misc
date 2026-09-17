package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.TerminationProvision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExtendibleProvision;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTerminationProvision.MapTerminationProvisionDefault.class)
public abstract class MapTerminationProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCancelableProvision mapCancelableProvision;
	@Inject protected MapEarlyTerminationProvision mapEarlyTerminationProvision;

	/**
	* @param fpmlEarlyTerminationProvision 
	* @param fpmlCancelableProvision 
	* @param fpmlExtendibleProvision 
	* @param cdmCounterpartyList 
	* @return terminationProvision 
	*/
	public TerminationProvision evaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, CancelableProvision fpmlCancelableProvision, ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
		TerminationProvision.TerminationProvisionBuilder terminationProvisionBuilder = doEvaluate(fpmlEarlyTerminationProvision, fpmlCancelableProvision, fpmlExtendibleProvision, cdmCounterpartyList);
		
		final TerminationProvision terminationProvision;
		if (terminationProvisionBuilder == null) {
			terminationProvision = null;
		} else {
			terminationProvision = terminationProvisionBuilder.build();
			objectValidator.validate(TerminationProvision.class, terminationProvision);
		}
		
		return terminationProvision;
	}

	protected abstract TerminationProvision.TerminationProvisionBuilder doEvaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, CancelableProvision fpmlCancelableProvision, ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapTerminationProvisionDefault extends MapTerminationProvision {
		@Override
		protected TerminationProvision.TerminationProvisionBuilder doEvaluate(EarlyTerminationProvision fpmlEarlyTerminationProvision, CancelableProvision fpmlCancelableProvision, ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			TerminationProvision.TerminationProvisionBuilder terminationProvision = TerminationProvision.builder();
			return assignOutput(terminationProvision, fpmlEarlyTerminationProvision, fpmlCancelableProvision, fpmlExtendibleProvision, cdmCounterpartyList);
		}
		
		protected TerminationProvision.TerminationProvisionBuilder assignOutput(TerminationProvision.TerminationProvisionBuilder terminationProvision, EarlyTerminationProvision fpmlEarlyTerminationProvision, CancelableProvision fpmlCancelableProvision, ExtendibleProvision fpmlExtendibleProvision, List<? extends Counterparty> cdmCounterpartyList) {
			terminationProvision = toBuilder(TerminationProvision.builder()
				.setEarlyTerminationProvision(mapEarlyTerminationProvision.evaluate(fpmlEarlyTerminationProvision, cdmCounterpartyList))
				.setCancelableProvision(mapCancelableProvision.evaluate(fpmlCancelableProvision, cdmCounterpartyList))
				.setExtendibleProvision(null)
				.build());
			
			return Optional.ofNullable(terminationProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
