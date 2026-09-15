package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.EventIntentEnum;
import cdm.event.workflow.EventInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.PartyTradeInformation;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNextEvent.MapNextEventDefault.class)
public abstract class MapNextEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPartyTradeInformationList 
	* @return nextEvent 
	*/
	public EventInstruction evaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
		EventInstruction.EventInstructionBuilder nextEventBuilder = doEvaluate(fpmlPartyTradeInformationList);
		
		final EventInstruction nextEvent;
		if (nextEventBuilder == null) {
			nextEvent = null;
		} else {
			nextEvent = nextEventBuilder.build();
			objectValidator.validate(EventInstruction.class, nextEvent);
		}
		
		return nextEvent;
	}

	protected abstract EventInstruction.EventInstructionBuilder doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	public static class MapNextEventDefault extends MapNextEvent {
		@Override
		protected EventInstruction.EventInstructionBuilder doEvaluate(List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			EventInstruction.EventInstructionBuilder nextEvent = EventInstruction.builder();
			return assignOutput(nextEvent, fpmlPartyTradeInformationList);
		}
		
		protected EventInstruction.EventInstructionBuilder assignOutput(EventInstruction.EventInstructionBuilder nextEvent, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			final EventIntentEnum ifThenElseResult;
			if (areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<ClearingStatusValue>map("getClearingStatus", partyTradeInformation -> partyTradeInformation.getClearingStatus()).<String>map("getValue", clearingStatusValue -> clearingStatusValue.getValue()), MapperS.of("Uncleared"), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<Boolean>map("getIntentToClear", partyTradeInformation -> partyTradeInformation.getIntentToClear()), MapperS.of(true), CardinalityOperator.Any)).getOrDefault(false)) {
				ifThenElseResult = EventIntentEnum.CLEARING;
			} else if (areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<AllocationReportingStatus>map("getAllocationStatus", partyTradeInformation -> partyTradeInformation.getAllocationStatus()).<String>map("getValue", allocationReportingStatus -> allocationReportingStatus.getValue()), MapperS.of("PreAllocation"), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<Boolean>map("getIntentToAllocate", partyTradeInformation -> partyTradeInformation.getIntentToAllocate()), MapperS.of(true), CardinalityOperator.Any)).getOrDefault(false)) {
				ifThenElseResult = EventIntentEnum.ALLOCATION;
			} else if (areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<Boolean>map("getIntentToClear", partyTradeInformation -> partyTradeInformation.getIntentToClear()), MapperS.of(true), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult = EventIntentEnum.CLEARING;
			} else if (areEqual(MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList).<Boolean>map("getIntentToAllocate", partyTradeInformation -> partyTradeInformation.getIntentToAllocate()), MapperS.of(true), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult = EventIntentEnum.ALLOCATION;
			} else {
				ifThenElseResult = null;
			}
			nextEvent = toBuilder(EventInstruction.builder()
				.setIntent(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(nextEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
