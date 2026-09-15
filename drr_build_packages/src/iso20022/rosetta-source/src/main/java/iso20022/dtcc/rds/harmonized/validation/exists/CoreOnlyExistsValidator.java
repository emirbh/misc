package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Core;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoreOnlyExistsValidator implements ValidatorWithArg<Core, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Core> ValidationResult<Core> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeLegTypes", ExistenceChecker.isSet((String) o.getTradeLegTypes()))
				.put("latestExecutionDatetime", ExistenceChecker.isSet((ZonedDateTime) o.getLatestExecutionDatetime()))
				.put("messageId", ExistenceChecker.isSet((String) o.getMessageId()))
				.put("messageType", ExistenceChecker.isSet((String) o.getMessageType()))
				.put("primaryAssetClass", ExistenceChecker.isSet((String) o.getPrimaryAssetClass()))
				.put("productId", ExistenceChecker.isSet((String) o.getProductId()))
				.put("productIdType", ExistenceChecker.isSet((String) o.getProductIdType()))
				.put("submittedForParty", ExistenceChecker.isSet((String) o.getSubmittedForParty()))
				.put("submittingPartyId", ExistenceChecker.isSet((String) o.getSubmittingPartyId()))
				.put("submittingPartyIdType", ExistenceChecker.isSet((String) o.getSubmittingPartyIdType()))
				.put("tradeParty1Id", ExistenceChecker.isSet((String) o.getTradeParty1Id()))
				.put("tradeParty1IdType", ExistenceChecker.isSet((String) o.getTradeParty1IdType()))
				.put("tradeParty1ReportingDestination", ExistenceChecker.isSet((List<String>) o.getTradeParty1ReportingDestination()))
				.put("tradeParty1TransactionId", ExistenceChecker.isSet((String) o.getTradeParty1TransactionId()))
				.put("tradeParty2Id", ExistenceChecker.isSet((String) o.getTradeParty2Id()))
				.put("tradeParty2IdType", ExistenceChecker.isSet((String) o.getTradeParty2IdType()))
				.put("tradeParty2ReportingDestination", ExistenceChecker.isSet((List<String>) o.getTradeParty2ReportingDestination()))
				.put("tradeParty2TransactionId", ExistenceChecker.isSet((String) o.getTradeParty2TransactionId()))
				.put("transactionType", ExistenceChecker.isSet((String) o.getTransactionType()))
				.put("usiId", ExistenceChecker.isSet((String) o.getUsiId()))
				.put("usiIdPrefix", ExistenceChecker.isSet((String) o.getUsiIdPrefix()))
				.put("utiId", ExistenceChecker.isSet((String) o.getUtiId()))
				.put("utiIdPrefix", ExistenceChecker.isSet((String) o.getUtiIdPrefix()))
				.put("lifecycleEventType", ExistenceChecker.isSet((String) o.getLifecycleEventType()))
				.put("tradeParty1ExecutionAgentId", ExistenceChecker.isSet((String) o.getTradeParty1ExecutionAgentId()))
				.put("tradeParty1ExecutionAgentIdType", ExistenceChecker.isSet((String) o.getTradeParty1ExecutionAgentIdType()))
				.put("tradeParty2ExecutionAgentId", ExistenceChecker.isSet((String) o.getTradeParty2ExecutionAgentId()))
				.put("tradeParty2ExecutionAgentIdType", ExistenceChecker.isSet((String) o.getTradeParty2ExecutionAgentIdType()))
				.put("tradeParty1ThirdPartyViewerId", ExistenceChecker.isSet((List<String>) o.getTradeParty1ThirdPartyViewerId()))
				.put("tradeParty2ThirdPartyViewerId", ExistenceChecker.isSet((List<String>) o.getTradeParty2ThirdPartyViewerId()))
				.put("tradeParty1ThirdPartyViewerIdType", ExistenceChecker.isSet((List<String>) o.getTradeParty1ThirdPartyViewerIdType()))
				.put("tradeParty2ThirdPartyViewerIdType", ExistenceChecker.isSet((List<String>) o.getTradeParty2ThirdPartyViewerIdType()))
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("aiParty1Id", ExistenceChecker.isSet((String) o.getAiParty1Id()))
				.put("aiParty1IdType", ExistenceChecker.isSet((String) o.getAiParty1IdType()))
				.put("aiParty2Id", ExistenceChecker.isSet((String) o.getAiParty2Id()))
				.put("aiParty2IdType", ExistenceChecker.isSet((String) o.getAiParty2IdType()))
				.put("tradeParty1RegulatoryActionType1", ExistenceChecker.isSet((String) o.getTradeParty1RegulatoryActionType1()))
				.put("tradeParty2RegulatoryActionType1", ExistenceChecker.isSet((String) o.getTradeParty2RegulatoryActionType1()))
				.put("noaActionType", ExistenceChecker.isSet((String) o.getNoaActionType()))
				.put("noaEventType", ExistenceChecker.isSet((String) o.getNoaEventType()))
				.put("initialMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getInitialMarginCollateralPortfolioCode()))
				.put("variationMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getVariationMarginCollateralPortfolioCode()))
				.put("corporateActionNewTradeParty1Lei", ExistenceChecker.isSet((String) o.getCorporateActionNewTradeParty1Lei()))
				.put("upi", ExistenceChecker.isSet((String) o.getUpi()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Core", ValidationResult.ValidationType.ONLY_EXISTS, "Core", path, "");
		}
		return failure("Core", ValidationResult.ValidationType.ONLY_EXISTS, "Core", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
