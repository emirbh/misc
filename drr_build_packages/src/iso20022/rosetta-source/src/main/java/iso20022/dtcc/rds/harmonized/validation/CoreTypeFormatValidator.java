package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Core;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CoreTypeFormatValidator implements Validator<Core> {

	private List<ComparisonResult> getComparisonResults(Core o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("tradeLegTypes", o.getTradeLegTypes(), 0, of(500), empty()), 
				checkString("messageId", o.getMessageId(), 0, of(255), empty()), 
				checkString("messageType", o.getMessageType(), 0, of(500), empty()), 
				checkString("primaryAssetClass", o.getPrimaryAssetClass(), 0, of(500), empty()), 
				checkString("productId", o.getProductId(), 0, of(500), empty()), 
				checkString("productIdType", o.getProductIdType(), 0, of(500), empty()), 
				checkString("submittedForParty", o.getSubmittedForParty(), 0, of(500), empty()), 
				checkString("submittingPartyId", o.getSubmittingPartyId(), 0, of(200), empty()), 
				checkString("submittingPartyIdType", o.getSubmittingPartyIdType(), 0, of(500), empty()), 
				checkString("tradeParty1Id", o.getTradeParty1Id(), 0, of(200), empty()), 
				checkString("tradeParty1IdType", o.getTradeParty1IdType(), 0, of(500), empty()), 
				checkString("tradeParty1ReportingDestination", o.getTradeParty1ReportingDestination(), 0, of(200), empty()), 
				checkString("tradeParty1TransactionId", o.getTradeParty1TransactionId(), 0, of(200), empty()), 
				checkString("tradeParty2Id", o.getTradeParty2Id(), 0, of(200), empty()), 
				checkString("tradeParty2IdType", o.getTradeParty2IdType(), 0, of(500), empty()), 
				checkString("tradeParty2ReportingDestination", o.getTradeParty2ReportingDestination(), 0, of(200), empty()), 
				checkString("tradeParty2TransactionId", o.getTradeParty2TransactionId(), 0, of(200), empty()), 
				checkString("transactionType", o.getTransactionType(), 0, of(500), empty()), 
				checkString("usiId", o.getUsiId(), 0, of(200), empty()), 
				checkString("usiIdPrefix", o.getUsiIdPrefix(), 0, of(40), empty()), 
				checkString("utiId", o.getUtiId(), 0, of(200), empty()), 
				checkString("utiIdPrefix", o.getUtiIdPrefix(), 0, of(40), empty()), 
				checkString("lifecycleEventType", o.getLifecycleEventType(), 0, of(500), empty()), 
				checkString("tradeParty1ExecutionAgentId", o.getTradeParty1ExecutionAgentId(), 0, of(200), empty()), 
				checkString("tradeParty1ExecutionAgentIdType", o.getTradeParty1ExecutionAgentIdType(), 0, of(500), empty()), 
				checkString("tradeParty2ExecutionAgentId", o.getTradeParty2ExecutionAgentId(), 0, of(200), empty()), 
				checkString("tradeParty2ExecutionAgentIdType", o.getTradeParty2ExecutionAgentIdType(), 0, of(500), empty()), 
				checkString("tradeParty1ThirdPartyViewerId", o.getTradeParty1ThirdPartyViewerId(), 0, of(200), empty()), 
				checkString("tradeParty2ThirdPartyViewerId", o.getTradeParty2ThirdPartyViewerId(), 0, of(200), empty()), 
				checkString("tradeParty1ThirdPartyViewerIdType", o.getTradeParty1ThirdPartyViewerIdType(), 0, of(500), empty()), 
				checkString("tradeParty2ThirdPartyViewerIdType", o.getTradeParty2ThirdPartyViewerIdType(), 0, of(500), empty()), 
				checkString("aiParty1Id", o.getAiParty1Id(), 0, of(20), empty()), 
				checkString("aiParty1IdType", o.getAiParty1IdType(), 0, of(500), empty()), 
				checkString("aiParty2Id", o.getAiParty2Id(), 0, of(20), empty()), 
				checkString("aiParty2IdType", o.getAiParty2IdType(), 0, of(500), empty()), 
				checkString("tradeParty1RegulatoryActionType1", o.getTradeParty1RegulatoryActionType1(), 0, of(500), empty()), 
				checkString("tradeParty2RegulatoryActionType1", o.getTradeParty2RegulatoryActionType1(), 0, of(500), empty()), 
				checkString("noaActionType", o.getNoaActionType(), 0, of(500), empty()), 
				checkString("noaEventType", o.getNoaEventType(), 0, of(500), empty()), 
				checkString("initialMarginCollateralPortfolioCode", o.getInitialMarginCollateralPortfolioCode(), 0, of(52), empty()), 
				checkString("variationMarginCollateralPortfolioCode", o.getVariationMarginCollateralPortfolioCode(), 0, of(52), empty()), 
				checkString("corporateActionNewTradeParty1Lei", o.getCorporateActionNewTradeParty1Lei(), 0, of(200), empty()), 
				checkString("upi", o.getUpi(), 0, of(20), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Core o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Core", ValidationResult.ValidationType.TYPE_FORMAT, "Core", path, "", res.getError());
				}
				return success("Core", ValidationResult.ValidationType.TYPE_FORMAT, "Core", path, "");
			})
			.collect(toList());
	}

}
