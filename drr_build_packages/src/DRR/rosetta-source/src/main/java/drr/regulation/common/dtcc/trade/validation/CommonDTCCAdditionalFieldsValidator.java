package drr.regulation.common.dtcc.trade.validation;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.CommonDTCCAdditionalFields;
import drr.standards.iso.OptionStyleEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonDTCCAdditionalFieldsValidator implements Validator<CommonDTCCAdditionalFields> {

	private List<ComparisonResult> getComparisonResults(CommonDTCCAdditionalFields o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("clearingVenueIDType", (PartyIdentifierTypeEnum) o.getClearingVenueIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ClearingBrokerIDType", (PartyIdentifierTypeEnum) o.getTradeParty1ClearingBrokerIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittingPartyIDType", (PartyIdentifierTypeEnum) o.getSubmittingPartyIDType() != null ? 1 : 0, 1, 1), 
				checkCardinality("submittedForParty", (String) o.getSubmittedForParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeLegTypes", (String) o.getTradeLegTypes() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ReportingDestination", (List<SupervisoryBodyEnum>) o.getTradeParty1ReportingDestination() == null ? 0 : o.getTradeParty1ReportingDestination().size(), 1, 0), 
				checkCardinality("primaryAssetClass", (AssetClassEnum) o.getPrimaryAssetClass() != null ? 1 : 0, 1, 1), 
				checkCardinality("secondaryAssetClass", (AssetClassEnum) o.getSecondaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment1", (String) o.getComment1() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionStyle", (OptionStyleEnum) o.getOptionStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (String) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("productID", (String) o.getProductID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentID", (String) o.getTradeParty2ExecutionAgentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentIDType", (PartyIdentifierTypeEnum) o.getTradeParty2ExecutionAgentIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentID", (String) o.getTradeParty1ExecutionAgentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentIDType", (PartyIdentifierTypeEnum) o.getTradeParty1ExecutionAgentIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1TransactionID", (String) o.getTradeParty1TransactionID() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (String) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryLocation", (String) o.getDeliveryLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg1CommodityInstrumentID", (String) o.getLeg1CommodityInstrumentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg2CommodityInstrumentID", (String) o.getLeg2CommodityInstrumentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleDataSubmitterIDType", (PartyIdentifierTypeEnum) o.getResponsibleDataSubmitterIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleDataSubmitterID", (String) o.getResponsibleDataSubmitterID() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDateOfTheUnderlying", (Date) o.getMaturityDateOfTheUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("corporateActionNewTradeParty1Lei", (String) o.getCorporateActionNewTradeParty1Lei() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherPaymentPayerIDType", (List<String>) o.getOtherPaymentPayerIDType() == null ? 0 : o.getOtherPaymentPayerIDType().size(), 0, 18), 
				checkCardinality("otherPaymentReceiverIDType", (List<String>) o.getOtherPaymentReceiverIDType() == null ? 0 : o.getOtherPaymentReceiverIDType().size(), 0, 18), 
				checkCardinality("sefOrDcmAnonymousExecutionIndicator", (Boolean) o.getSefOrDcmAnonymousExecutionIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueID", (String) o.getExecutionVenueID() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueIDType", (PartyIdentifierTypeEnum) o.getExecutionVenueIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg1FloatingRateIndex", (String) o.getLeg1FloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg2FloatingRateIndex", (String) o.getLeg2FloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetName", (List<String>) o.getUnderlyingAssetName() == null ? 0 : o.getUnderlyingAssetName().size(), 0, 20)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonDTCCAdditionalFields o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonDTCCAdditionalFields", ValidationResult.ValidationType.CARDINALITY, "CommonDTCCAdditionalFields", path, "", res.getError());
				}
				return success("CommonDTCCAdditionalFields", ValidationResult.ValidationType.CARDINALITY, "CommonDTCCAdditionalFields", path, "");
			})
			.collect(toList());
	}

}
