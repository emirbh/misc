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

@ImplementedBy(GetUniqueTransactionIdentifier.GetUniqueTransactionIdentifierDefault.class)
public abstract class GetUniqueTransactionIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetRegimeSpecificIdentifiers getRegimeSpecificIdentifiers;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableInformation 
	* @param supervisoryBody 
	* @param utidentifier 
	* @param transaction 
	* @return uti 
	*/
	public String evaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
		String uti = doEvaluate(reportableInformation, supervisoryBody, utidentifier, transaction);
		
		return uti;
	}

	protected abstract String doEvaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction);

	protected abstract MapperC<String> utiFromReportableInformation(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction);

	protected abstract MapperC<? extends FieldWithMetaString> utiFromTrade(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction);

	protected abstract MapperC<? extends FieldWithMetaString> utiFromPosition(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction);

	public static class GetUniqueTransactionIdentifierDefault extends GetUniqueTransactionIdentifier {
		@Override
		protected String doEvaluate(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
			if (supervisoryBody == null) {
				supervisoryBody = Collections.emptyList();
			}
			String uti = null;
			return assignOutput(uti, reportableInformation, supervisoryBody, utidentifier, transaction);
		}
		
		protected String assignOutput(String uti, ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
			final MapperC<String> thenArg = (utiFromReportableInformation(reportableInformation, supervisoryBody, utidentifier, transaction).getMulti().isEmpty() ? utiFromTrade(reportableInformation, supervisoryBody, utidentifier, transaction).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()) : utiFromReportableInformation(reportableInformation, supervisoryBody, utidentifier, transaction)).getMulti().isEmpty() ? utiFromPosition(reportableInformation, supervisoryBody, utidentifier, transaction).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()) : (utiFromReportableInformation(reportableInformation, supervisoryBody, utidentifier, transaction).getMulti().isEmpty() ? utiFromTrade(reportableInformation, supervisoryBody, utidentifier, transaction).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()) : utiFromReportableInformation(reportableInformation, supervisoryBody, utidentifier, transaction));
			uti = MapperS.of(distinctIgnoringPrecision(thenArg).get()).get();
			
			return uti;
		}
		
		@Override
		protected MapperC<String> utiFromReportableInformation(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
			return MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(reportableInformation, supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER)).getMulti().isEmpty() ? MapperS.of(utidentifier).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()) : MapperC.<String>of(getRegimeSpecificIdentifiers.evaluate(reportableInformation, supervisoryBody, TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER));
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> utiFromTrade(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
			final MapperC<TradeIdentifier> thenArg = MapperS.of(tradeForEvent.evaluate(transaction)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			return thenArg.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> utiFromPosition(ReportableInformation reportableInformation, List<SupervisoryBodyEnum> supervisoryBody, TradeIdentifier utidentifier, TransactionReportInstruction transaction) {
			final MapperC<PositionIdentifier> thenArg = MapperS.of(positionForEvent.evaluate(transaction)).<PositionIdentifier>mapC("getPositionIdentifier", counterpartyPosition -> counterpartyPosition.getPositionIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", positionIdentifier -> positionIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			return thenArg.<AssignedIdentifier>mapC("getAssignedIdentifier", positionIdentifier -> positionIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier());
		}
	}
}
