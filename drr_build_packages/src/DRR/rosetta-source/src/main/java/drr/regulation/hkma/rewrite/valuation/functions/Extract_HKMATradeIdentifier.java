package drr.regulation.hkma.rewrite.valuation.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;


@ImplementedBy(Extract_HKMATradeIdentifier.Extract_HKMATradeIdentifierDefault.class)
public abstract class Extract_HKMATradeIdentifier implements RosettaFunction {

	/**
	* @param tradeIdentifier 
	* @return hkmaTradeIdentifiers 
	*/
	public String evaluate(TradeIdentifier tradeIdentifier) {
		String hkmaTradeIdentifiers = doEvaluate(tradeIdentifier);
		
		return hkmaTradeIdentifiers;
	}

	protected abstract String doEvaluate(TradeIdentifier tradeIdentifier);

	public static class Extract_HKMATradeIdentifierDefault extends Extract_HKMATradeIdentifier {
		@Override
		protected String doEvaluate(TradeIdentifier tradeIdentifier) {
			String hkmaTradeIdentifiers = null;
			return assignOutput(hkmaTradeIdentifiers, tradeIdentifier);
		}
		
		protected String assignOutput(String hkmaTradeIdentifiers, TradeIdentifier tradeIdentifier) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(tradeIdentifier).<AssignedIdentifier>mapC("getAssignedIdentifier", _tradeIdentifier -> _tradeIdentifier.getAssignedIdentifier())
				.first().<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).get();
			if (fieldWithMetaString == null) {
				hkmaTradeIdentifiers = null;
			} else {
				hkmaTradeIdentifiers = fieldWithMetaString.getValue();
			}
			
			return hkmaTradeIdentifiers;
		}
	}
}
