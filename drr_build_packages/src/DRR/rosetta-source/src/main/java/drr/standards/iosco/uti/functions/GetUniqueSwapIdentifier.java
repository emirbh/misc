package drr.standards.iosco.uti.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.PositionIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetRegimeSpecificIdentifiers;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUniqueSwapIdentifier.GetUniqueSwapIdentifierDefault.class)
public abstract class GetUniqueSwapIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetRegimeSpecificIdentifiers getRegimeSpecificIdentifiers;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param transaction 
	* @param supervisoryBody 
	* @return uti 
	*/
	public String evaluate(TransactionReportInstruction transaction, List<SupervisoryBodyEnum> supervisoryBody) {
		String uti = doEvaluate(transaction, supervisoryBody);
		
		return uti;
	}

	protected abstract String doEvaluate(TransactionReportInstruction transaction, List<SupervisoryBodyEnum> supervisoryBody);

	public static class GetUniqueSwapIdentifierDefault extends GetUniqueSwapIdentifier {
		@Override
		protected String doEvaluate(TransactionReportInstruction transaction, List<SupervisoryBodyEnum> supervisoryBody) {
			if (supervisoryBody == null) {
				supervisoryBody = Collections.emptyList();
			}
			String uti = null;
			return assignOutput(uti, transaction, supervisoryBody);
		}
		
		protected String assignOutput(String uti, TransactionReportInstruction transaction, List<SupervisoryBodyEnum> supervisoryBody) {
			final MapperC<String> thenArg2;
			if (exists(MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER))).getOrDefault(false)) {
				thenArg2 = MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER));
			} else if (exists(MapperS.of(tradeForEvent.evaluate(transaction))).getOrDefault(false)) {
				final MapperC<TradeIdentifier> thenArg0 = MapperS.of(tradeForEvent.evaluate(transaction)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
				thenArg2 = thenArg0.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue());
			} else if (exists(MapperS.of(positionForEvent.evaluate(transaction))).getOrDefault(false)) {
				final MapperC<PositionIdentifier> thenArg1 = MapperS.of(positionForEvent.evaluate(transaction)).<PositionIdentifier>mapC("getPositionIdentifier", counterpartyPosition -> counterpartyPosition.getPositionIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", positionIdentifier -> positionIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_SWAP_IDENTIFIER), CardinalityOperator.All).get());
				thenArg2 = thenArg1.<AssignedIdentifier>mapC("getAssignedIdentifier", positionIdentifier -> positionIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue());
			} else {
				thenArg2 = MapperC.<String>ofNull();
			}
			final MapperC<String> thenArg3 = distinctIgnoringPrecision(thenArg2);
			uti = MapperS.of(thenArg3.get()).get();
			
			return uti;
		}
	}
}
