package drr.regulation.common.trade.party.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportingSide;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetInternalId.GetInternalIdDefault.class)
public abstract class GetInternalId implements RosettaFunction {

	/**
	* @param tradeIdentifier 
	* @param reportingSide 
	* @param internalTradeIdentifier 
	* @return internalTradeId 
	*/
	public String evaluate(List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier) {
		String internalTradeId = doEvaluate(tradeIdentifier, reportingSide, internalTradeIdentifier);
		
		return internalTradeId;
	}

	protected abstract String doEvaluate(List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier);

	protected abstract MapperC<? extends FieldWithMetaString> internalIdentifiers(List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier);

	public static class GetInternalIdDefault extends GetInternalId {
		@Override
		protected String doEvaluate(List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier) {
			if (tradeIdentifier == null) {
				tradeIdentifier = Collections.emptyList();
			}
			String internalTradeId = null;
			return assignOutput(internalTradeId, tradeIdentifier, reportingSide, internalTradeIdentifier);
		}
		
		protected String assignOutput(String internalTradeId, List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier) {
			final MapperC<? extends FieldWithMetaString> thenArg = internalIdentifiers(tradeIdentifier, reportingSide, internalTradeIdentifier);
			final FieldWithMetaString fieldWithMetaString = distinctIgnoringPrecision(thenArg)
				.first().get();
			internalTradeId = MapperS.of(internalTradeIdentifier).getOrDefault((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			return internalTradeId;
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> internalIdentifiers(List<? extends TradeIdentifier> tradeIdentifier, ReportingSide reportingSide, String internalTradeIdentifier) {
			final MapperC<TradeIdentifier> thenArg0 = MapperC.<TradeIdentifier>of(tradeIdentifier);
			final MapperC<TradeIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getIssuerReference", _tradeIdentifier -> _tradeIdentifier.getIssuerReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingParty", _reportingSide -> _reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
			final MapperC<TradeIdentifier> thenArg2 = thenArg1
				.filterItemNullSafe(item -> notEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", _tradeIdentifier -> _tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.Any).andNullSafe(notEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", _tradeIdentifier -> _tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.Any)).get());
			final MapperListOfLists<FieldWithMetaString> thenArg3 = thenArg2
				.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", _tradeIdentifier -> _tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			return thenArg3
				.flattenList();
		}
	}
}
