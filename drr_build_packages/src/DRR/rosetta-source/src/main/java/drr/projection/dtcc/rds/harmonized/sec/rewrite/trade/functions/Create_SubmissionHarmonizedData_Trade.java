package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.JurisdictionEnum;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedData_Trade.Create_SubmissionHarmonizedData_TradeDefault.class)
public abstract class Create_SubmissionHarmonizedData_Trade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param commonHarmonized 
	* @return harmonized 
	*/
	public HarmonizedData evaluate(SECTransactionReportTrade drrReport, HarmonizedData commonHarmonized) {
		HarmonizedData.HarmonizedDataBuilder harmonizedBuilder = doEvaluate(drrReport, commonHarmonized);
		
		final HarmonizedData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(SECTransactionReportTrade drrReport, HarmonizedData commonHarmonized);

	public static class Create_SubmissionHarmonizedData_TradeDefault extends Create_SubmissionHarmonizedData_Trade {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(SECTransactionReportTrade drrReport, HarmonizedData commonHarmonized) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport, commonHarmonized);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, SECTransactionReportTrade drrReport, HarmonizedData commonHarmonized) {
			harmonized = toBuilder(commonHarmonized, () -> HarmonizedData.builder());
			
			harmonized
				.setClearingVenueId(MapperS.of(drrReport).<String>map("getCentralCounterparty", sECTransactionReportTrade -> sECTransactionReportTrade.getCentralCounterparty()).get());
			
			harmonized
				.setClearingVenueIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getClearingVenueIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getClearingVenueIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setOrigin(MapperS.of(drrReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", sECTransactionReportTrade -> sECTransactionReportTrade.getClearingAccountOrigin()).map("to-string", ClearingAccountOriginEnum::toDisplayString).get());
			
			harmonized
				.setTradeParty1ClearingBrokerId(MapperS.of(drrReport).<String>map("getClearingMember", sECTransactionReportTrade -> sECTransactionReportTrade.getClearingMember()).get());
			
			harmonized
				.setTradeParty1ClearingBrokerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ClearingBrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ClearingBrokerIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setClearingSwapUtiId(MapperS.of(drrReport).<String>mapC("getClearingSwapUTIs", sECTransactionReportTrade -> sECTransactionReportTrade.getClearingSwapUTIs()).get());
			
			harmonized
				.setOriginalSwapUsi(MapperS.of(drrReport).<String>map("getOriginalSwapUSI", sECTransactionReportTrade -> sECTransactionReportTrade.getOriginalSwapUSI()).get());
			
			harmonized
				.setOriginalSwapUti(MapperS.of(drrReport).<String>map("getOriginalSwapUTI", sECTransactionReportTrade -> sECTransactionReportTrade.getOriginalSwapUTI()).get());
			
			harmonized
				.setOriginalSwapSdrId(MapperS.of(drrReport).<String>map("getOriginalSwapSDRIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getOriginalSwapSDRIdentifier()).get());
			
			harmonized
				.setOriginalSwapSdrIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getOriginalSwapSDRIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOriginalSwapSDRIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			harmonized
				.setClearingReceiptDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getClearingReceiptTimestamp", sECTransactionReportTrade -> sECTransactionReportTrade.getClearingReceiptTimestamp()).get());
			
			harmonized
				.setBuyerPayer1(MapperS.of(drrReport).<String>map("getBuyerIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getBuyerIdentifier()).get());
			
			harmonized
				.setSellerPayer2(MapperS.of(drrReport).<String>map("getSellerIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getSellerIdentifier()).get());
			
			harmonized
				.setPayment1Payer(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg1()).<String>map("getPayerIdentifier", sECLeg -> sECLeg.getPayerIdentifier()).get());
			
			harmonized
				.setPayment2Payer(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg2()).<String>map("getPayerIdentifier", sECLeg -> sECLeg.getPayerIdentifier()).get());
			
			harmonized
				.setPayment1Receiver(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg1()).<String>map("getReceiverIdentifier", sECLeg -> sECLeg.getReceiverIdentifier()).get());
			
			harmonized
				.setCdeReceiverIdentifierLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg2()).<String>map("getReceiverIdentifier", sECLeg -> sECLeg.getReceiverIdentifier()).get());
			
			harmonized
				.setEventIdentifier(MapperS.of(drrReport).<String>map("getEventIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getEventIdentifier()).get());
			
			harmonized
				.setCdePackageIdentifier(MapperS.of(drrReport).<String>map("getPackageIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getPackageIdentifier()).get());
			
			harmonized
				.setFixingDateLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg1()).<ZonedDateTime>map("getFixingDate", sECLeg -> sECLeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get());
			
			harmonized
				.setFixingDateLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReportTrade -> sECTransactionReportTrade.getLeg2()).<ZonedDateTime>map("getFixingDate", sECLeg -> sECLeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get());
			
			harmonized
				.setPremiumPaymentDateUnadjusted(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", sECTransactionReportTrade -> sECTransactionReportTrade.getOptionPremiumPaymentDate()).get());
			
			harmonized
				.setAttachmentPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", sECTransactionReportTrade -> sECTransactionReportTrade.getCdSIndexAttachmentPoint()).get());
			
			harmonized
				.setExhaustionPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", sECTransactionReportTrade -> sECTransactionReportTrade.getCdSIndexDetachmentPoint()).get());
			
			harmonized
				.setCdeFinalContractualSettlementDate(MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", sECTransactionReportTrade -> sECTransactionReportTrade.getFinalContractualSettlementDate()).get());
			
			harmonized
				.setAllocationType(MapperS.of(drrReport).<AllocationIndicatorEnum>map("getAllocationIndicator", sECTransactionReportTrade -> sECTransactionReportTrade.getAllocationIndicator()).map("to-string", AllocationIndicatorEnum::toDisplayString).get());
			
			harmonized
				.setPriorUsiId(MapperS.of(drrReport).<String>map("getPriorUSI", sECTransactionReportTrade -> sECTransactionReportTrade.getPriorUSI()).get());
			
			harmonized
				.setPriorUsiIdPrefix(null);
			
			harmonized
				.setPriorUtiId(MapperS.of(drrReport).<String>map("getPriorUTI", sECTransactionReportTrade -> sECTransactionReportTrade.getPriorUTI()).get());
			
			harmonized
				.setPriorUtiIdPrefix(null);
			
			harmonized
				.setSwapReportingJurisdiction(MapperS.of(drrReport).<JurisdictionEnum>map("getJurisdiction", sECTransactionReportTrade -> sECTransactionReportTrade.getJurisdiction()).map("to-string", JurisdictionEnum::toDisplayString).get());
			
			harmonized
				.setNewSdrIdentifier(MapperS.of(drrReport).<String>map("getNewSDRIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getNewSDRIdentifier()).get());
			
			harmonized
				.setSecondaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getSecondaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getSecondaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get());
			
			harmonized
				.setExecutionVenueId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<String>map("getExecutionVenueID", dTCCAdditionalFields -> dTCCAdditionalFields.getExecutionVenueID()).get());
			
			harmonized
				.setExecutionVenueIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getExecutionVenueIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getExecutionVenueIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
