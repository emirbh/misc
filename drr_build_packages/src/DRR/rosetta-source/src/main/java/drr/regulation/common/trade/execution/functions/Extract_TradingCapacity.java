package drr.regulation.common.trade.execution.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.ReportingRoleEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.standards.iso.TradingCapacity7Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_TradingCapacity.Extract_TradingCapacityDefault.class)
public abstract class Extract_TradingCapacity implements RosettaFunction {

	/**
	* @param transactionReportInstruction 
	* @param sprvsryBody 
	* @return result 
	*/
	public TradingCapacity7Code evaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum sprvsryBody) {
		TradingCapacity7Code result = doEvaluate(transactionReportInstruction, sprvsryBody);
		
		return result;
	}

	protected abstract TradingCapacity7Code doEvaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum sprvsryBody);

	public static class Extract_TradingCapacityDefault extends Extract_TradingCapacity {
		@Override
		protected TradingCapacity7Code doEvaluate(TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum sprvsryBody) {
			TradingCapacity7Code result = null;
			return assignOutput(result, transactionReportInstruction, sprvsryBody);
		}
		
		protected TradingCapacity7Code assignOutput(TradingCapacity7Code result, TransactionReportInstruction transactionReportInstruction, SupervisoryBodyEnum sprvsryBody) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(sprvsryBody), CardinalityOperator.All).get());
			final MapperListOfLists<JurisdictionPartyInformation> thenArg2 = thenArg1
				.mapItemToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
			final MapperListOfLists<JurisdictionPartyInformation> thenArg3 = thenArg2
				.filterListNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", _referenceWithMetaParty -> _referenceWithMetaParty.getValue()), MapperS.of(transactionReportInstruction).<ReportingSide>map("getReportingSide", _transactionReportInstruction -> _transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), CardinalityOperator.Any).get());
			final MapperS<JurisdictionPartyInformation> thenArg4 = MapperS.of(thenArg3
				.flattenList().get());
			result = thenArg4
				.mapSingleToItem(item -> {
					if (areEqual(item.<ReportingRoleEnum>map("getTradingCapacity", jurisdictionPartyInformation -> jurisdictionPartyInformation.getTradingCapacity()), MapperS.of(ReportingRoleEnum.AGENT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(TradingCapacity7Code.AGEN);
					}
					if (areEqual(item.<ReportingRoleEnum>map("getTradingCapacity", jurisdictionPartyInformation -> jurisdictionPartyInformation.getTradingCapacity()), MapperS.of(ReportingRoleEnum.PRINCIPAL), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(TradingCapacity7Code.PRIN);
					}
					return MapperS.<TradingCapacity7Code>ofNull();
				}).get();
			
			return result;
		}
	}
}
