package drr.enrichment.common.trade.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TransactionReportInstructionFromInstruction.Create_TransactionReportInstructionFromInstructionDefault.class)
public abstract class Create_TransactionReportInstructionFromInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ReportableEventFromInstruction create_ReportableEventFromInstruction;
	@Inject protected Create_ReportingSideFromReportableEvent create_ReportingSideFromReportableEvent;
	@Inject protected Create_TransactionReportInstruction create_TransactionReportInstruction;

	/**
	* @param reportableEvent 
	* @param reportingPartyRole 
	* @param counterpartyRole 
	* @param partyResponsibleForReportingRole 
	* @param reportSubmittingPartyRole 
	* @return transactionReportInstruction 
	*/
	public TransactionReportInstruction evaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
		TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstructionBuilder = doEvaluate(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole);
		
		final TransactionReportInstruction transactionReportInstruction;
		if (transactionReportInstructionBuilder == null) {
			transactionReportInstruction = null;
		} else {
			transactionReportInstruction = transactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, transactionReportInstruction);
		}
		
		return transactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole);

	protected abstract MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole);

	protected abstract MapperS<? extends ReportingSide> enrichedReportingSide(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole);

	public static class Create_TransactionReportInstructionFromInstructionDefault extends Create_TransactionReportInstructionFromInstruction {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(transactionReportInstruction, reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction, ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			transactionReportInstruction = toBuilder(create_TransactionReportInstruction.evaluate(enrichedReportableEvent(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).get(), enrichedReportingSide(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).get()));
			
			return Optional.ofNullable(transactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			return MapperS.of(create_ReportableEventFromInstruction.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends ReportingSide> enrichedReportingSide(ReportableEvent reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			return MapperS.of(create_ReportingSideFromReportableEvent.evaluate(enrichedReportableEvent(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).get(), reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole));
		}
	}
}
