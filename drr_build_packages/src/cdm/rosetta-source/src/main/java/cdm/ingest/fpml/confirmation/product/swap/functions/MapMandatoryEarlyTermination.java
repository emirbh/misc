package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDate;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCashSettlementToSettlementTerms;
import cdm.product.template.MandatoryEarlyTermination;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.shared.AdjustableDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMandatoryEarlyTermination.MapMandatoryEarlyTerminationDefault.class)
public abstract class MapMandatoryEarlyTermination implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapCashSettlementToSettlementTerms mapCashSettlementToSettlementTerms;

	/**
	* @param fpmlMandatoryEarlyTermination 
	* @param cdmCounterpartyList 
	* @return mandatoryEarlyTermination 
	*/
	public MandatoryEarlyTermination evaluate(fpml.consolidated.ird.MandatoryEarlyTermination fpmlMandatoryEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTerminationBuilder = doEvaluate(fpmlMandatoryEarlyTermination, cdmCounterpartyList);
		
		final MandatoryEarlyTermination mandatoryEarlyTermination;
		if (mandatoryEarlyTerminationBuilder == null) {
			mandatoryEarlyTermination = null;
		} else {
			mandatoryEarlyTermination = mandatoryEarlyTerminationBuilder.build();
			objectValidator.validate(MandatoryEarlyTermination.class, mandatoryEarlyTermination);
		}
		
		return mandatoryEarlyTermination;
	}

	protected abstract MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder doEvaluate(fpml.consolidated.ird.MandatoryEarlyTermination fpmlMandatoryEarlyTermination, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapMandatoryEarlyTerminationDefault extends MapMandatoryEarlyTermination {
		@Override
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder doEvaluate(fpml.consolidated.ird.MandatoryEarlyTermination fpmlMandatoryEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination = MandatoryEarlyTermination.builder();
			return assignOutput(mandatoryEarlyTermination, fpmlMandatoryEarlyTermination, cdmCounterpartyList);
		}
		
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder assignOutput(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination, fpml.consolidated.ird.MandatoryEarlyTermination fpmlMandatoryEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			mandatoryEarlyTermination = toBuilder(MandatoryEarlyTermination.builder()
				.setMandatoryEarlyTerminationDate(mapAdjustableDate.evaluate(MapperS.of(fpmlMandatoryEarlyTermination).<AdjustableDate>map("getMandatoryEarlyTerminationDate", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getMandatoryEarlyTerminationDate()).get()))
				.setCalculationAgent(null)
				.setCashSettlement(mapCashSettlementToSettlementTerms.evaluate(MapperS.of(fpmlMandatoryEarlyTermination).<CashSettlement>map("getCashSettlement", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getCashSettlement()).get()))
				.build());
			
			return Optional.ofNullable(mandatoryEarlyTermination)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
