package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EarlyTerminationProvision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.MandatoryEarlyTermination;
import fpml.consolidated.ird.OptionalEarlyTermination;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEarlyTerminationProvision.MapEarlyTerminationProvisionDefault.class)
public abstract class MapEarlyTerminationProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMandatoryEarlyTermination mapMandatoryEarlyTermination;
	@Inject protected MapOptionalEarlyTermination mapOptionalEarlyTermination;

	/**
	* @param fpmlEarlyTerminationProvision 
	* @param cdmCounterpartyList 
	* @return earlyTerminationProvision 
	*/
	public EarlyTerminationProvision evaluate(fpml.consolidated.ird.EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvisionBuilder = doEvaluate(fpmlEarlyTerminationProvision, cdmCounterpartyList);
		
		final EarlyTerminationProvision earlyTerminationProvision;
		if (earlyTerminationProvisionBuilder == null) {
			earlyTerminationProvision = null;
		} else {
			earlyTerminationProvision = earlyTerminationProvisionBuilder.build();
			objectValidator.validate(EarlyTerminationProvision.class, earlyTerminationProvision);
		}
		
		return earlyTerminationProvision;
	}

	protected abstract EarlyTerminationProvision.EarlyTerminationProvisionBuilder doEvaluate(fpml.consolidated.ird.EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEarlyTerminationProvisionDefault extends MapEarlyTerminationProvision {
		@Override
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder doEvaluate(fpml.consolidated.ird.EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision = EarlyTerminationProvision.builder();
			return assignOutput(earlyTerminationProvision, fpmlEarlyTerminationProvision, cdmCounterpartyList);
		}
		
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder assignOutput(EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision, fpml.consolidated.ird.EarlyTerminationProvision fpmlEarlyTerminationProvision, List<? extends Counterparty> cdmCounterpartyList) {
			earlyTerminationProvision = toBuilder(EarlyTerminationProvision.builder()
				.setOptionalEarlyTermination(mapOptionalEarlyTermination.evaluate(MapperS.of(fpmlEarlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination()).get(), cdmCounterpartyList))
				.setMandatoryEarlyTermination(mapMandatoryEarlyTermination.evaluate(MapperS.of(fpmlEarlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(earlyTerminationProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
