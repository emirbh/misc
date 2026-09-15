package drr.regulation.common.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.functions.FilterPartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeForEvent;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetReportTrackingNumber.GetReportTrackingNumberDefault.class)
public abstract class GetReportTrackingNumber implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPartyRole filterPartyRole;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return reportingTrackingNumber 
	*/
	public String evaluate(ReportableEventBase reportableEvent) {
		String reportingTrackingNumber = doEvaluate(reportableEvent);
		
		return reportingTrackingNumber;
	}

	protected abstract String doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends ReferenceWithMetaParty> role(ReportableEventBase reportableEvent);

	public static class GetReportTrackingNumberDefault extends GetReportTrackingNumber {
		@Override
		protected String doEvaluate(ReportableEventBase reportableEvent) {
			String reportingTrackingNumber = null;
			return assignOutput(reportingTrackingNumber, reportableEvent);
		}
		
		protected String assignOutput(String reportingTrackingNumber, ReportableEventBase reportableEvent) {
			final MapperC<TradeIdentifier> thenArg0 = MapperS.of(tradeForEvent.evaluate(reportableEvent)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getIssuerReference", tradeIdentifier -> tradeIdentifier.getIssuerReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), role(reportableEvent).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
			final MapperListOfLists<FieldWithMetaString> thenArg1 = thenArg0
				.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg2 = thenArg1
				.flattenList();
			final MapperC<String> ifThenElseResult;
			if (exists(thenArg2).getOrDefault(false)) {
				ifThenElseResult = thenArg2.<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue());
			} else {
				ifThenElseResult = MapperC.of(Collections.singletonList("RTNNotProvided"));
			}
			reportingTrackingNumber = MapperS.of(ifThenElseResult.get()).get();
			
			return reportingTrackingNumber;
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> role(ReportableEventBase reportableEvent) {
			return MapperS.of(MapperC.<PartyRole>of(filterPartyRole.evaluate(MapperS.of(tradeForEvent.evaluate(reportableEvent)).<PartyRole>mapC("getPartyRole", trade -> trade.getPartyRole()).getMulti(), PartyRoleEnum.EXECUTION_FACILITY)).<ReferenceWithMetaParty>map("getPartyReference", partyRole -> partyRole.getPartyReference()).get());
		}
	}
}
