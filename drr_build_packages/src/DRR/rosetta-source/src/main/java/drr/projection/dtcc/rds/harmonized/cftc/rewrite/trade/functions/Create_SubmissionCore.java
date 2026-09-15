package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.datetime.functions.Now;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import iso20022.dtcc.rds.harmonized.Core;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


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
	public Core evaluate(CFTCTransactionReport drrReport) {
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

	protected abstract Core.CoreBuilder doEvaluate(CFTCTransactionReport drrReport);

	public static class Create_SubmissionCoreDefault extends Create_SubmissionCore {
		@Override
		protected Core.CoreBuilder doEvaluate(CFTCTransactionReport drrReport) {
			Core.CoreBuilder core = Core.builder();
			return assignOutput(core, drrReport);
		}
		
		protected Core.CoreBuilder assignOutput(Core.CoreBuilder core, CFTCTransactionReport drrReport) {
			core = toBuilder(Core.builder()
				.setLatestExecutionDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getEventTimestamp", cFTCTransactionReport -> cFTCTransactionReport.getEventTimestamp()).get())
				.setSubmittingPartyId(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", cFTCTransactionReport -> cFTCTransactionReport.getReportSubmittingEntityID()).get())
				.setTradeParty1Id(MapperS.of(drrReport).<String>map("getCounterparty1", cFTCTransactionReport -> cFTCTransactionReport.getCounterparty1()).get())
				.setTradeParty2Id(MapperS.of(drrReport).<String>map("getCounterparty2", cFTCTransactionReport -> cFTCTransactionReport.getCounterparty2()).get())
				.setTradeParty2IdType(MapperS.of(drrReport).<Counterparty2IdentifierEnum>map("getCounterparty2IdentifierSource", cFTCTransactionReport -> cFTCTransactionReport.getCounterparty2IdentifierSource()).map("to-string", Counterparty2IdentifierEnum::toDisplayString).get())
				.setUsiId(MapperS.of(drrReport).<String>map("getUniqueSwapIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getUniqueSwapIdentifier()).get())
				.setUtiId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getUniqueTransactionIdentifier()).get())
				.setReportingTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", cFTCTransactionReport -> cFTCTransactionReport.getReportingTimestamp()).getOrDefault(now.evaluate()))
				.setUpi(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getUniqueProductIdentifier()).get())
				.setUtiIdPrefix(null)
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cFTCTransactionReport -> cFTCTransactionReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setNoaEventType(MapperS.of(drrReport).<EventTypeEnum>map("getEventType", cFTCTransactionReport -> cFTCTransactionReport.getEventType()).map("to-string", EventTypeEnum::toDisplayString).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cFTCTransactionReport -> cFTCTransactionReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cFTCTransactionReport -> cFTCTransactionReport.getVariationMarginCollateralPortfolioCode()).get())
				.setTradeLegTypes(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getTradeLegTypes", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeLegTypes()).get())
				.setMessageId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getMessageID", dTCCAdditionalFields -> dTCCAdditionalFields.getMessageID()).get())
				.setPrimaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get())
				.setProductId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getProductID", dTCCAdditionalFields -> dTCCAdditionalFields.getProductID()).get())
				.setSubmittedForParty(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getSubmittedForParty", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittedForParty()).get())
				.setSubmittingPartyIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getSubmittingPartyIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getSubmittingPartyIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1IdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1IDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1IDType()).map("to-string", Object::toString).get())
				.setTradeParty1ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.setTradeParty1TransactionId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1TransactionID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1TransactionID()).get())
				.setTradeParty1ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty1ExecutionAgentID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ExecutionAgentID()).get())
				.setTradeParty1ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ExecutionAgentIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty2ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getTradeParty2ExecutionAgentID", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ExecutionAgentID()).get())
				.setTradeParty2ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty2ExecutionAgentIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setCorporateActionNewTradeParty1Lei(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getCorporateActionNewTradeParty1Lei", dTCCAdditionalFields -> dTCCAdditionalFields.getCorporateActionNewTradeParty1Lei()).get())
				.build());
			
			return Optional.ofNullable(core)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
