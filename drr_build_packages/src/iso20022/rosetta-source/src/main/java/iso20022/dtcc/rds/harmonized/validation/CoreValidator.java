package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Core;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CoreValidator implements Validator<Core> {

	private List<ComparisonResult> getComparisonResults(Core o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeLegTypes", (String) o.getTradeLegTypes() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExecutionDatetime", (ZonedDateTime) o.getLatestExecutionDatetime() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageId", (String) o.getMessageId() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageType", (String) o.getMessageType() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (String) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("productId", (String) o.getProductId() != null ? 1 : 0, 0, 1), 
				checkCardinality("productIdType", (String) o.getProductIdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittedForParty", (String) o.getSubmittedForParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittingPartyId", (String) o.getSubmittingPartyId() != null ? 1 : 0, 0, 1), 
				checkCardinality("submittingPartyIdType", (String) o.getSubmittingPartyIdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1Id", (String) o.getTradeParty1Id() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1IdType", (String) o.getTradeParty1IdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1TransactionId", (String) o.getTradeParty1TransactionId() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2Id", (String) o.getTradeParty2Id() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2IdType", (String) o.getTradeParty2IdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2TransactionId", (String) o.getTradeParty2TransactionId() != null ? 1 : 0, 0, 1), 
				checkCardinality("transactionType", (String) o.getTransactionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("usiId", (String) o.getUsiId() != null ? 1 : 0, 0, 1), 
				checkCardinality("usiIdPrefix", (String) o.getUsiIdPrefix() != null ? 1 : 0, 0, 1), 
				checkCardinality("utiId", (String) o.getUtiId() != null ? 1 : 0, 0, 1), 
				checkCardinality("utiIdPrefix", (String) o.getUtiIdPrefix() != null ? 1 : 0, 0, 1), 
				checkCardinality("lifecycleEventType", (String) o.getLifecycleEventType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentId", (String) o.getTradeParty1ExecutionAgentId() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1ExecutionAgentIdType", (String) o.getTradeParty1ExecutionAgentIdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentId", (String) o.getTradeParty2ExecutionAgentId() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2ExecutionAgentIdType", (String) o.getTradeParty2ExecutionAgentIdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingTimestamp", (ZonedDateTime) o.getReportingTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("aiParty1Id", (String) o.getAiParty1Id() != null ? 1 : 0, 0, 1), 
				checkCardinality("aiParty1IdType", (String) o.getAiParty1IdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("aiParty2Id", (String) o.getAiParty2Id() != null ? 1 : 0, 0, 1), 
				checkCardinality("aiParty2IdType", (String) o.getAiParty2IdType() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty1RegulatoryActionType1", (String) o.getTradeParty1RegulatoryActionType1() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeParty2RegulatoryActionType1", (String) o.getTradeParty2RegulatoryActionType1() != null ? 1 : 0, 0, 1), 
				checkCardinality("noaActionType", (String) o.getNoaActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("noaEventType", (String) o.getNoaEventType() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollateralPortfolioCode", (String) o.getInitialMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollateralPortfolioCode", (String) o.getVariationMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("corporateActionNewTradeParty1Lei", (String) o.getCorporateActionNewTradeParty1Lei() != null ? 1 : 0, 0, 1), 
				checkCardinality("upi", (String) o.getUpi() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Core o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Core", ValidationResult.ValidationType.CARDINALITY, "Core", path, "", res.getError());
				}
				return success("Core", ValidationResult.ValidationType.CARDINALITY, "Core", path, "");
			})
			.collect(toList());
	}

}
