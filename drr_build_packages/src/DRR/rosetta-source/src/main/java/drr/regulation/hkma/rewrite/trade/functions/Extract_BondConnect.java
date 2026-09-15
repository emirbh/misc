package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_BondConnect.Extract_BondConnectDefault.class)
public abstract class Extract_BondConnect implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return bondConnectValue 
	*/
	public String evaluate(ReportableEventBase reportableEvent) {
		String bondConnectValue = doEvaluate(reportableEvent);
		
		return bondConnectValue;
	}

	protected abstract String doEvaluate(ReportableEventBase reportableEvent);

	public static class Extract_BondConnectDefault extends Extract_BondConnect {
		@Override
		protected String doEvaluate(ReportableEventBase reportableEvent) {
			String bondConnectValue = null;
			return assignOutput(bondConnectValue, reportableEvent);
		}
		
		protected String assignOutput(String bondConnectValue, ReportableEventBase reportableEvent) {
			final MapperS<ReportableEventBase> thenArg0 = MapperS.of(reportableEvent);
			final MapperC<FieldWithMetaString> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperS.of(tradeForEvent.evaluate(item.get())).<Party>mapC("getParty", trade -> trade.getParty()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("https://www.hkma.gov.hk/cmu/account-id/bondconnect"), CardinalityOperator.All).get());
			final MapperS<FieldWithMetaString> thenArg3 = thenArg2
				.first();
			final FieldWithMetaString fieldWithMetaString = thenArg3.get();
			if (fieldWithMetaString == null) {
				bondConnectValue = null;
			} else {
				bondConnectValue = fieldWithMetaString.getValue();
			}
			
			return bondConnectValue;
		}
	}
}
