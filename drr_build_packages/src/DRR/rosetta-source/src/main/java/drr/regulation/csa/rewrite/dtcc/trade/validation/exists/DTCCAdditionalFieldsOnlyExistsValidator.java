package drr.regulation.csa.rewrite.dtcc.trade.validation.exists;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.standards.iso.OptionStyleEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DTCCAdditionalFieldsOnlyExistsValidator implements ValidatorWithArg<DTCCAdditionalFields, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DTCCAdditionalFields> ValidationResult<DTCCAdditionalFields> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("clearingVenueIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getClearingVenueIDType()))
				.put("tradeParty1ClearingBrokerIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1ClearingBrokerIDType()))
				.put("submittingPartyIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getSubmittingPartyIDType()))
				.put("submittedForParty", ExistenceChecker.isSet((String) o.getSubmittedForParty()))
				.put("tradeLegTypes", ExistenceChecker.isSet((String) o.getTradeLegTypes()))
				.put("tradeParty1ReportingDestination", ExistenceChecker.isSet((List<SupervisoryBodyEnum>) o.getTradeParty1ReportingDestination()))
				.put("tradeParty2ReportingDestination", ExistenceChecker.isSet((List<SupervisoryBodyEnum>) o.getTradeParty2ReportingDestination()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClassEnum) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((AssetClassEnum) o.getSecondaryAssetClass()))
				.put("comment1", ExistenceChecker.isSet((String) o.getComment1()))
				.put("optionStyle", ExistenceChecker.isSet((OptionStyleEnum) o.getOptionStyle()))
				.put("optionType", ExistenceChecker.isSet((String) o.getOptionType()))
				.put("productID", ExistenceChecker.isSet((String) o.getProductID()))
				.put("tradeParty2ExecutionAgentID", ExistenceChecker.isSet((String) o.getTradeParty2ExecutionAgentID()))
				.put("tradeParty2ExecutionAgentIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty2ExecutionAgentIDType()))
				.put("tradeParty1ExecutionAgentID", ExistenceChecker.isSet((String) o.getTradeParty1ExecutionAgentID()))
				.put("tradeParty1ExecutionAgentIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1ExecutionAgentIDType()))
				.put("tradeParty1TransactionID", ExistenceChecker.isSet((String) o.getTradeParty1TransactionID()))
				.put("settlementType", ExistenceChecker.isSet((String) o.getSettlementType()))
				.put("productGrade", ExistenceChecker.isSet((List<? extends ProductGradeReport>) o.getProductGrade()))
				.put("deliveryLocation", ExistenceChecker.isSet((String) o.getDeliveryLocation()))
				.put("leg1CommodityInstrumentID", ExistenceChecker.isSet((String) o.getLeg1CommodityInstrumentID()))
				.put("leg2CommodityInstrumentID", ExistenceChecker.isSet((String) o.getLeg2CommodityInstrumentID()))
				.put("responsibleDataSubmitterIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getResponsibleDataSubmitterIDType()))
				.put("responsibleDataSubmitterID", ExistenceChecker.isSet((String) o.getResponsibleDataSubmitterID()))
				.put("maturityDateOfTheUnderlying", ExistenceChecker.isSet((Date) o.getMaturityDateOfTheUnderlying()))
				.put("corporateActionNewTradeParty1Lei", ExistenceChecker.isSet((String) o.getCorporateActionNewTradeParty1Lei()))
				.put("otherPaymentPayerIDType", ExistenceChecker.isSet((List<String>) o.getOtherPaymentPayerIDType()))
				.put("otherPaymentReceiverIDType", ExistenceChecker.isSet((List<String>) o.getOtherPaymentReceiverIDType()))
				.put("sefOrDcmAnonymousExecutionIndicator", ExistenceChecker.isSet((Boolean) o.getSefOrDcmAnonymousExecutionIndicator()))
				.put("executionVenueID", ExistenceChecker.isSet((String) o.getExecutionVenueID()))
				.put("executionVenueIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getExecutionVenueIDType()))
				.put("leg1FloatingRateIndex", ExistenceChecker.isSet((String) o.getLeg1FloatingRateIndex()))
				.put("leg2FloatingRateIndex", ExistenceChecker.isSet((String) o.getLeg2FloatingRateIndex()))
				.put("underlyingAssetName", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetName()))
				.put("underlyingAsset", ExistenceChecker.isSet((List<? extends UnderlyingAssetReport>) o.getUnderlyingAsset()))
				.put("tradeParty1IDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1IDType()))
				.put("allocationType", ExistenceChecker.isSet((AllocationIndicatorEnum) o.getAllocationType()))
				.put("usiID", ExistenceChecker.isSet((String) o.getUsiID()))
				.put("usiIDPrefix", ExistenceChecker.isSet((String) o.getUsiIDPrefix()))
				.put("newSDRIdentifier", ExistenceChecker.isSet((String) o.getNewSDRIdentifier()))
				.put("messageID", ExistenceChecker.isSet((String) o.getMessageID()))
				.put("leg1CommodityUnderlyerID", ExistenceChecker.isSet((String) o.getLeg1CommodityUnderlyerID()))
				.put("leg2CommodityUnderlyerID", ExistenceChecker.isSet((String) o.getLeg2CommodityUnderlyerID()))
				.put("messageTypeTransaction", ExistenceChecker.isSet((String) o.getMessageTypeTransaction()))
				.put("messageTypePPD", ExistenceChecker.isSet((String) o.getMessageTypePPD()))
				.put("leg1SettlementPeriod", ExistenceChecker.isSet((String) o.getLeg1SettlementPeriod()))
				.put("loadType", ExistenceChecker.isSet((String) o.getLoadType()))
				.put("tradeParty1BrokerIDType", ExistenceChecker.isSet((PartyIdentifierTypeEnum) o.getTradeParty1BrokerIDType()))
				.put("versionTransaction", ExistenceChecker.isSet((String) o.getVersionTransaction()))
				.put("versionPPD", ExistenceChecker.isSet((String) o.getVersionPPD()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DTCCAdditionalFields", ValidationResult.ValidationType.ONLY_EXISTS, "DTCCAdditionalFields", path, "");
		}
		return failure("DTCCAdditionalFields", ValidationResult.ValidationType.ONLY_EXISTS, "DTCCAdditionalFields", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
