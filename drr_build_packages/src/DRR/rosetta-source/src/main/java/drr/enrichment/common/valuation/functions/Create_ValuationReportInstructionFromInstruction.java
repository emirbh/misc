package drr.enrichment.common.valuation.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.enrichment.common.trade.functions.Create_ReportableEventFromInstruction;
import drr.enrichment.common.trade.functions.Create_ReportingSideFromReportableEvent;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.ValuationReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ValuationReportInstructionFromInstruction.Create_ValuationReportInstructionFromInstructionDefault.class)
public abstract class Create_ValuationReportInstructionFromInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ReportableEventFromInstruction create_ReportableEventFromInstruction;
	@Inject protected Create_ReportingSideFromReportableEvent create_ReportingSideFromReportableEvent;
	@Inject protected Create_StandaloneValuationFromReportableEvent create_StandaloneValuationFromReportableEvent;
	@Inject protected Create_ValuationReportInstruction create_ValuationReportInstruction;

	/**
	* @param reportableEvent 
	* @param reportingPartyRole 
	* @param counterpartyRole 
	* @param partyResponsibleForReportingRole 
	* @param reportSubmittingPartyRole 
	* @param regimeNameEnum 
	* @return valuationReportInstruction 
	*/
	public ValuationReportInstruction evaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
		ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstructionBuilder = doEvaluate(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole, regimeNameEnum);
		
		final ValuationReportInstruction valuationReportInstruction;
		if (valuationReportInstructionBuilder == null) {
			valuationReportInstruction = null;
		} else {
			valuationReportInstruction = valuationReportInstructionBuilder.build();
			objectValidator.validate(ValuationReportInstruction.class, valuationReportInstruction);
		}
		
		return valuationReportInstruction;
	}

	protected abstract ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum);

	protected abstract MapperS<? extends ReportableValuation> enrichedValuation(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum);

	protected abstract MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum);

	protected abstract MapperS<? extends ReportingSide> enrichedReportingSide(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum);

	public static class Create_ValuationReportInstructionFromInstructionDefault extends Create_ValuationReportInstructionFromInstruction {
		@Override
		protected ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
			ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction = ValuationReportInstruction.builder();
			return assignOutput(valuationReportInstruction, reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole, regimeNameEnum);
		}
		
		protected ValuationReportInstruction.ValuationReportInstructionBuilder assignOutput(ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction, ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
			valuationReportInstruction = toBuilder(create_ValuationReportInstruction.evaluate(enrichedValuation(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole, regimeNameEnum).get(), enrichedReportingSide(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole, regimeNameEnum).get()));
			
			return Optional.ofNullable(valuationReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportableValuation> enrichedValuation(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
			return MapperS.of(create_StandaloneValuationFromReportableEvent.evaluate(reportableEvent, regimeNameEnum));
		}
		
		@Override
		protected MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
			return MapperS.of(create_ReportableEventFromInstruction.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends ReportingSide> enrichedReportingSide(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole, RegimeNameEnum regimeNameEnum) {
			return MapperS.of(create_ReportingSideFromReportableEvent.evaluate(enrichedReportableEvent(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole, regimeNameEnum).get(), reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole));
		}
	}
}
