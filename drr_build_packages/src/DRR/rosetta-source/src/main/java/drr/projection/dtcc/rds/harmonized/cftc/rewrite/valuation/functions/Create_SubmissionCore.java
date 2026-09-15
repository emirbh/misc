package drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.functions;

import cdm.base.datetime.functions.Now;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.cftc.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.standards.iso.ActionTypeEnum;
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
	public Core evaluate(CFTCValuationReport drrReport) {
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

	protected abstract Core.CoreBuilder doEvaluate(CFTCValuationReport drrReport);

	public static class Create_SubmissionCoreDefault extends Create_SubmissionCore {
		@Override
		protected Core.CoreBuilder doEvaluate(CFTCValuationReport drrReport) {
			Core.CoreBuilder core = Core.builder();
			return assignOutput(core, drrReport);
		}
		
		protected Core.CoreBuilder assignOutput(Core.CoreBuilder core, CFTCValuationReport drrReport) {
			core = toBuilder(Core.builder()
				.setMessageId(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getMessageID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getMessageID()).get())
				.setMessageType(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getMessageType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getMessageType()).get())
				.setPrimaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getPrimaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get())
				.setSubmittedForParty(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getSubmittedForParty", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getSubmittedForParty()).get())
				.setSubmittingPartyId(MapperS.of(drrReport).<String>map("getReportSubmittingEntityID", cFTCValuationReport -> cFTCValuationReport.getReportSubmittingEntityID()).get())
				.setSubmittingPartyIdType(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<PartyIdentifierTypeEnum>map("getSubmittingPartyIDType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getSubmittingPartyIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1Id(MapperS.of(drrReport).<String>map("getCounterparty1", cFTCValuationReport -> cFTCValuationReport.getCounterparty1()).get())
				.setTradeParty1IdType(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<PartyIdentifierTypeEnum>map("getTradeParty1IDType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty1IDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty1ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.setTradeParty1TransactionId(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getTradeParty1TransactionID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty1TransactionID()).get())
				.setTradeParty2Id(MapperS.of(drrReport).<String>map("getCounterparty2", cFTCValuationReport -> cFTCValuationReport.getCounterparty2()).get())
				.setTradeParty2IdType(MapperS.of(drrReport).<String>map("getCounterparty2IdentifierSource", cFTCValuationReport -> cFTCValuationReport.getCounterparty2IdentifierSource()).get())
				.setTradeParty2ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<SupervisoryBodyEnum>mapC("getTradeParty2ReportingDestination", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty2ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.setUsiId(MapperS.of(drrReport).<String>map("getUniqueSwapIdentifier", cFTCValuationReport -> cFTCValuationReport.getUniqueSwapIdentifier()).get())
				.setUsiIdPrefix(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getUsiIDPrefix", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getUsiIDPrefix()).get())
				.setUtiId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", cFTCValuationReport -> cFTCValuationReport.getUniqueTransactionIdentifier()).get())
				.setTradeParty1ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getTradeParty1ExecutionAgentID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty1ExecutionAgentID()).get())
				.setTradeParty1ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ExecutionAgentIDType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty1ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty2ExecutionAgentId(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getTradeParty2ExecutionAgentID", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty2ExecutionAgentID()).get())
				.setTradeParty2ExecutionAgentIdType(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<PartyIdentifierTypeEnum>map("getTradeParty2ExecutionAgentIDType", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getTradeParty2ExecutionAgentIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setReportingTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", cFTCValuationReport -> cFTCValuationReport.getReportingTimestamp()).getOrDefault(now.evaluate()))
				.setUpi(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", cFTCValuationReport -> cFTCValuationReport.getUniqueProductIdentifier()).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cFTCValuationReport -> cFTCValuationReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cFTCValuationReport -> cFTCValuationReport.getVariationMarginCollateralPortfolioCode()).get())
				.setUtiIdPrefix(MapperS.of(drrReport).<DTCCAdditionalValuationFields>map("getDtccValuationFields", cFTCValuationReport -> cFTCValuationReport.getDtccValuationFields()).<String>map("getUtiIDPrefix", dTCCAdditionalValuationFields -> dTCCAdditionalValuationFields.getUtiIDPrefix()).get())
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cFTCValuationReport -> cFTCValuationReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.build());
			
			return Optional.ofNullable(core)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
