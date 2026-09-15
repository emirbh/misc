package drr.enrichment.common.trade.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportingSide;
import drr.base.trade.functions.TradeForEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ReportingSideFromReportableEvent.Create_ReportingSideFromReportableEventDefault.class)
public abstract class Create_ReportingSideFromReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @param reportingPartyRole 
	* @param counterpartyRole 
	* @param partyResponsibleForReportingRole 
	* @param reportSubmittingPartyRole 
	* @return reportingSide 
	*/
	public ReportingSide evaluate(ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
		ReportingSide.ReportingSideBuilder reportingSideBuilder = doEvaluate(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole);
		
		final ReportingSide reportingSide;
		if (reportingSideBuilder == null) {
			reportingSide = null;
		} else {
			reportingSide = reportingSideBuilder.build();
			objectValidator.validate(ReportingSide.class, reportingSide);
		}
		
		return reportingSide;
	}

	protected abstract ReportingSide.ReportingSideBuilder doEvaluate(ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole);

	protected abstract MapperC<? extends Counterparty> counterparties(ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole);

	public static class Create_ReportingSideFromReportableEventDefault extends Create_ReportingSideFromReportableEvent {
		@Override
		protected ReportingSide.ReportingSideBuilder doEvaluate(ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			ReportingSide.ReportingSideBuilder reportingSide = ReportingSide.builder();
			return assignOutput(reportingSide, reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole);
		}
		
		protected ReportingSide.ReportingSideBuilder assignOutput(ReportingSide.ReportingSideBuilder reportingSide, ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(extractCounterpartyByRole.evaluate(counterparties(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).getMulti(), reportingPartyRole)).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			final Party reportingParty = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(extractCounterpartyByRole.evaluate(counterparties(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).getMulti(), partyResponsibleForReportingRole)).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			final Party partyResponsibleForReporting = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			final ReferenceWithMetaParty referenceWithMetaParty2 = MapperS.of(extractCounterpartyByRole.evaluate(counterparties(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).getMulti(), reportSubmittingPartyRole)).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			final Party reportSubmittingParty = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			final ReferenceWithMetaParty referenceWithMetaParty3 = MapperS.of(extractCounterpartyByRole.evaluate(counterparties(reportableEvent, reportingPartyRole, counterpartyRole, partyResponsibleForReportingRole, reportSubmittingPartyRole).getMulti(), counterpartyRole)).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			final Party reportingCounterparty = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			reportingSide = toBuilder(ReportingSide.builder()
				.setReportingParty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(reportingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(reportingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setPartyResponsibleForReporting(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(partyResponsibleForReporting)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(partyResponsibleForReporting)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setReportSubmittingParty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(reportSubmittingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(reportSubmittingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setReportingCounterparty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(reportingCounterparty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(reportingCounterparty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.build());
			
			return Optional.ofNullable(reportingSide)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterparties(ReportableEventBase reportableEvent, CounterpartyRoleEnum reportingPartyRole, CounterpartyRoleEnum counterpartyRole, CounterpartyRoleEnum partyResponsibleForReportingRole, CounterpartyRoleEnum reportSubmittingPartyRole) {
			return MapperS.of(tradeForEvent.evaluate(reportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty());
		}
	}
}
