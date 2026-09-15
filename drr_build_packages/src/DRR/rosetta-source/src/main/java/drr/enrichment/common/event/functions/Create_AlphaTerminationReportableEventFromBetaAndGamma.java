package drr.enrichment.common.event.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.base.trade.PartyInformation;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AlphaTerminationReportableEventFromBetaAndGamma.Create_AlphaTerminationReportableEventFromBetaAndGammaDefault.class)
public abstract class Create_AlphaTerminationReportableEventFromBetaAndGamma implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AlphaTerminationWorkflowStepFromBetaAndGamma create_AlphaTerminationWorkflowStepFromBetaAndGamma;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param betaReportableEvent 
	* @param gammaReportableEvent 
	* @param alphaUTI 
	* @param alphaExecutionVenue 
	* @return alphaReportableEvent 
	*/
	public ReportableEvent evaluate(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
		ReportableEvent.ReportableEventBuilder alphaReportableEventBuilder = doEvaluate(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue);
		
		final ReportableEvent alphaReportableEvent;
		if (alphaReportableEventBuilder == null) {
			alphaReportableEvent = null;
		} else {
			alphaReportableEvent = alphaReportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, alphaReportableEvent);
		}
		
		return alphaReportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	protected abstract MapperS<? extends ReferenceWithMetaParty> ccpFromTrade(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	protected abstract MapperS<? extends ReferenceWithMetaParty> ccpFromReportableInformation(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	protected abstract MapperS<? extends ReferenceWithMetaParty> ccpPartyReference(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	protected abstract MapperS<? extends Counterparty> betaCounterparty(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	protected abstract MapperS<? extends Counterparty> gammaCounterparty(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue);

	public static class Create_AlphaTerminationReportableEventFromBetaAndGammaDefault extends Create_AlphaTerminationReportableEventFromBetaAndGamma {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			ReportableEvent.ReportableEventBuilder alphaReportableEvent = ReportableEvent.builder();
			return assignOutput(alphaReportableEvent, betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder alphaReportableEvent, ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			alphaReportableEvent
				.setReportableInformation(MapperS.of(betaReportableEvent).<ReportableInformation>map("getReportableInformation", reportableEvent -> reportableEvent.getReportableInformation()).get());
			
			alphaReportableEvent
				.getOrCreateReportableInformation()
				.addGlobalPartyInformation(MapperS.of(gammaReportableEvent).<ReportableInformation>map("getReportableInformation", reportableEvent -> reportableEvent.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation())
					.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), gammaCounterparty(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get()).getMulti());
			
			alphaReportableEvent
				.getOrCreateReportableInformation()
				.getOrCreateJurisdictionInformation(0)
				.getOrCreateTransactionInformation()
				.getOrCreateReportableExecutionVenue()
				.setExecutionVenueType(alphaExecutionVenue);
			
			final ReferenceWithMetaParty referenceWithMetaParty = ccpPartyReference(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).get();
			alphaReportableEvent
				.setOriginatingWorkflowStep(create_AlphaTerminationWorkflowStepFromBetaAndGamma.evaluate(betaReportableEvent, alphaUTI, (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), betaCounterparty(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).get(), gammaCounterparty(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).get()));
			
			return Optional.ofNullable(alphaReportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> ccpFromTrade(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			final MapperC<PartyRole> thenArg0 = MapperS.of(tradeForEvent.evaluate(gammaReportableEvent)).<PartyRole>mapC("getPartyRole", trade -> trade.getPartyRole())
				.filterItemNullSafe(item -> areEqual(item.<PartyRoleEnum>map("getRole", partyRole -> partyRole.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION), CardinalityOperator.All).get());
			final MapperS<PartyRole> thenArg1 = MapperS.of(thenArg0.get());
			return thenArg1.<ReferenceWithMetaParty>map("getPartyReference", partyRole -> partyRole.getPartyReference());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> ccpFromReportableInformation(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			final MapperC<RelatedParty> thenArg0 = MapperS.of(gammaReportableEvent).<ReportableInformation>map("getReportableInformation", reportableEvent -> reportableEvent.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty())
				.filterItemNullSafe(item -> areEqual(item.<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.CLEARING_ORGANIZATION), CardinalityOperator.All).get());
			final MapperS<RelatedParty> thenArg1 = MapperS.of(thenArg0.get());
			return thenArg1.<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> ccpPartyReference(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			if (exists(ccpFromTrade(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue)).getOrDefault(false)) {
				return ccpFromTrade(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue);
			}
			if (exists(ccpFromReportableInformation(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue)).getOrDefault(false)) {
				return ccpFromReportableInformation(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue);
			}
			return MapperS.<ReferenceWithMetaParty>ofNull();
		}
		
		@Override
		protected MapperS<? extends Counterparty> betaCounterparty(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			final MapperC<Counterparty> thenArg = MapperS.of(tradeForEvent.evaluate(betaReportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty())
				.filterItemNullSafe(item -> notEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), ccpPartyReference(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.Any).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends Counterparty> gammaCounterparty(ReportableEvent betaReportableEvent, ReportableEvent gammaReportableEvent, TradeIdentifier alphaUTI, ExecutionVenueTypeEnum alphaExecutionVenue) {
			final MapperC<Counterparty> thenArg = MapperS.of(tradeForEvent.evaluate(gammaReportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty())
				.filterItemNullSafe(item -> notEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), ccpPartyReference(betaReportableEvent, gammaReportableEvent, alphaUTI, alphaExecutionVenue).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.Any).get());
			return MapperS.of(thenArg.get());
		}
	}
}
