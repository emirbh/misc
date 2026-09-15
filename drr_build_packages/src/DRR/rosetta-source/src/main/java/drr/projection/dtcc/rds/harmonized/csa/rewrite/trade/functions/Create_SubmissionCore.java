package drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions;

import cdm.base.datetime.functions.Now;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import iso20022.dtcc.rds.harmonized.Core;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_SubmissionCore.Create_SubmissionCoreDefault.class)
public abstract class Create_SubmissionCore implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Now now;

	/**
	* @param drrReport 
	* @return core 
	*/
	public Core evaluate(CSATransactionReport drrReport) {
		Core.CoreBuilder coreBuilder = doEvaluate(drrReport);
		
		final Core core;
		if (coreBuilder == null) {
			core = null;
		} else {
			core = coreBuilder.build();
			objectValidator.validate(Core.class, core);
		}
		
		return core;
	}

	protected abstract Core.CoreBuilder doEvaluate(CSATransactionReport drrReport);

	public static class Create_SubmissionCoreDefault extends Create_SubmissionCore {
		@Override
		protected Core.CoreBuilder doEvaluate(CSATransactionReport drrReport) {
			Core.CoreBuilder core = Core.builder();
			return assignOutput(core, drrReport);
		}
		
		protected Core.CoreBuilder assignOutput(Core.CoreBuilder core, CSATransactionReport drrReport) {
			final String ifThenElseResult;
			if (exists(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getMessageTypeTransaction", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageTypeTransaction())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getMessageTypeTransaction", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageTypeTransaction()).get();
			} else if (exists(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getMessageTypePPD", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageTypePPD())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getMessageTypePPD", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageTypePPD()).get();
			} else {
				ifThenElseResult = null;
			}
			core = toBuilder(Core.builder()
				.setTradeLegTypes(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getTradeLegTypes", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeLegTypes()).get())
				.setLatestExecutionDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getEventTimestamp", cSATransactionReport -> cSATransactionReport.getEventTimestamp()).get())
				.setMessageId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getMessageID", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageID()).get())
				.setMessageType(ifThenElseResult)
				.setPrimaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get())
				.setProductId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getProductID", dTCCAdditionalFields -> dTCCAdditionalFields.getProductID()).get())
				.setSubmittedForParty(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getSubmittedForParty", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittedForParty()).get())
				.setSubmittingPartyId(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", cSATransactionReport -> cSATransactionReport.getReportSubmittingEntityID()).get())
				.setSubmittingPartyIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getSubmittingPartyIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittingPartyIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1Id(MapperS.of(drrReport).<String>map("getCounterparty1", cSATransactionReport -> cSATransactionReport.getCounterparty1()).get())
				.setTradeParty1IdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1IDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1IDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.setTradeParty1TransactionId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1TransactionID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1TransactionID()).get())
				.setTradeParty2Id(MapperS.of(drrReport).<String>map("getCounterparty2", cSATransactionReport -> cSATransactionReport.getCounterparty2()).get())
				.setTradeParty2IdType(MapperS.of(drrReport).<Counterparty2IdentifierEnum>map("getCounterparty2IdentifierSource", cSATransactionReport -> cSATransactionReport.getCounterparty2IdentifierSource()).map("to-string", Counterparty2IdentifierEnum::toDisplayString).get())
				.setTradeParty2ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty2ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.setUsiId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getUsiID", dTCCAdditionalFields -> dTCCAdditionalFields.getUsiID()).get())
				.setUsiIdPrefix(null)
				.setUtiId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", cSATransactionReport -> cSATransactionReport.getUniqueTransactionIdentifier()).get())
				.setUtiIdPrefix(null)
				.setTradeParty1ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1ExecutionAgentID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ExecutionAgentID()).get())
				.setTradeParty1ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ExecutionAgentIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty2ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty2ExecutionAgentID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ExecutionAgentID()).get())
				.setTradeParty2ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty2ExecutionAgentIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setReportingTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", cSATransactionReport -> cSATransactionReport.getReportingTimestamp()).getOrDefault(now.evaluate()))
				.setUpi(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", cSATransactionReport -> cSATransactionReport.getUniqueProductIdentifier()).get())
				.setCorporateActionNewTradeParty1Lei(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getCorporateActionNewTradeParty1Lei", dTCCAdditionalFields -> dTCCAdditionalFields.getCorporateActionNewTradeParty1Lei()).get())
				.build());
			
			return Optional.ofNullable(core)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
