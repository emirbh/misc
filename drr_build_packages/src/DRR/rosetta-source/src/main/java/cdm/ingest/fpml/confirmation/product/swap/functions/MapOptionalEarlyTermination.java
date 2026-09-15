package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCashSettlementToSettlementTerms;
import cdm.product.template.OptionalEarlyTermination;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionalEarlyTermination.MapOptionalEarlyTerminationDefault.class)
public abstract class MapOptionalEarlyTermination implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashSettlementToSettlementTerms mapCashSettlementToSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;

	/**
	* @param fpmlOptionalEarlyTermination 
	* @param cdmCounterpartyList 
	* @return optionalEarlyTermination 
	*/
	public OptionalEarlyTermination evaluate(fpml.consolidated.ird.OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTerminationBuilder = doEvaluate(fpmlOptionalEarlyTermination, cdmCounterpartyList);
		
		final OptionalEarlyTermination optionalEarlyTermination;
		if (optionalEarlyTerminationBuilder == null) {
			optionalEarlyTermination = null;
		} else {
			optionalEarlyTermination = optionalEarlyTerminationBuilder.build();
			objectValidator.validate(OptionalEarlyTermination.class, optionalEarlyTermination);
		}
		
		return optionalEarlyTermination;
	}

	protected abstract OptionalEarlyTermination.OptionalEarlyTerminationBuilder doEvaluate(fpml.consolidated.ird.OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapOptionalEarlyTerminationDefault extends MapOptionalEarlyTermination {
		@Override
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder doEvaluate(fpml.consolidated.ird.OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination = OptionalEarlyTermination.builder();
			return assignOutput(optionalEarlyTermination, fpmlOptionalEarlyTermination, cdmCounterpartyList);
		}
		
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder assignOutput(OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination, fpml.consolidated.ird.OptionalEarlyTermination fpmlOptionalEarlyTermination, List<? extends Counterparty> cdmCounterpartyList) {
			optionalEarlyTermination = toBuilder(OptionalEarlyTermination.builder()
				.setExerciseNotice(MapperS.of(fpmlOptionalEarlyTermination).<ExerciseNotice>mapC("getExerciseNotice", _optionalEarlyTermination -> _optionalEarlyTermination.getExerciseNotice())
					.mapItem(item -> MapperS.of(cdm.product.template.ExerciseNotice.builder()
						.setBusinessCenterValue(item.<BusinessCenter>map("getBusinessCenter", exerciseNotice -> exerciseNotice.getBusinessCenter()).<String>map("getValue", businessCenter -> businessCenter.getValue()).checkedMap("to-enum", BusinessCenterEnum::fromDisplayName, IllegalArgumentException.class).get())
						.setExerciseNoticeGiver(null)
						.build())).getMulti())
				.setFollowUpConfirmation(MapperS.of(fpmlOptionalEarlyTermination).<Boolean>map("getFollowUpConfirmation", _optionalEarlyTermination -> _optionalEarlyTermination.getFollowUpConfirmation()).get())
				.setCalculationAgent(null)
				.setCashSettlement(mapCashSettlementToSettlementTerms.evaluate(MapperS.of(fpmlOptionalEarlyTermination).<CashSettlement>map("getCashSettlement", _optionalEarlyTermination -> _optionalEarlyTermination.getCashSettlement()).get()))
				.setExerciseTerms(mapExerciseTerms.evaluate(MapperS.of(fpmlOptionalEarlyTermination).<Exercise>map("getExercise", _optionalEarlyTermination -> _optionalEarlyTermination.getExercise()).get(), null, null, null, null, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(optionalEarlyTermination)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
