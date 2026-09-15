package drr.regulation.common.trade.link.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeIdentifier;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.standards.iosco.cde.version3.link.reports.PriorUTIRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPriorTransactionIdentifier.GetPriorTransactionIdentifierDefault.class)
public abstract class GetPriorTransactionIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected PriorUTIRule priorUTIRule;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param transactionReportInstruction 
	* @param regime 
	* @return uti 
	*/
	public String evaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime) {
		String uti = doEvaluate(transactionReportInstruction, regime);
		
		return uti;
	}

	protected abstract String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime);

	protected abstract MapperC<? extends FieldWithMetaString> AfterTradeIdentifier(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime);

	protected abstract MapperC<? extends FieldWithMetaString> BeforeTradeIdentifier(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime);

	public static class GetPriorTransactionIdentifierDefault extends GetPriorTransactionIdentifier {
		@Override
		protected String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime) {
			String uti = null;
			return assignOutput(uti, transactionReportInstruction, regime);
		}
		
		protected String assignOutput(String uti, TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime) {
			if (exists(AfterTradeIdentifier(transactionReportInstruction, regime)).andNullSafe(exists(BeforeTradeIdentifier(transactionReportInstruction, regime))).andNullSafe(notEqual(AfterTradeIdentifier(transactionReportInstruction, regime).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), BeforeTradeIdentifier(transactionReportInstruction, regime).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(qualify_Compression.evaluate(MapperS.of(transactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				uti = priorUTIRule.evaluate(transactionReportInstruction);
			} else {
				final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
				final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
					.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(regime), CardinalityOperator.All).get());
				final MapperC<TradeIdentifier> thenArg2 = thenArg1
					.mapItem(item -> item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradeIdentifier>map("getPriorTransactionIdentifier", transactionInformation -> transactionInformation.getPriorTransactionIdentifier()));
				final MapperC<TradeIdentifier> thenArg3 = thenArg2
					.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
				final MapperListOfLists<FieldWithMetaString> thenArg4 = thenArg3
					.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
				final MapperC<FieldWithMetaString> thenArg5 = thenArg4
					.flattenList();
				final MapperC<FieldWithMetaString> thenArg6 = distinctIgnoringPrecision(thenArg5);
				final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg6.get()).get();
				if (fieldWithMetaString == null) {
					uti = null;
				} else {
					uti = fieldWithMetaString.getValue();
				}
			}
			
			return uti;
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> AfterTradeIdentifier(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime) {
			return MapperS.of(tradeForEvent.evaluate(transactionReportInstruction)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.first().<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> BeforeTradeIdentifier(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regime) {
			return MapperS.of(beforeTradeForEvent.evaluate(transactionReportInstruction)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.first().<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier());
		}
	}
}
