package drr.base.trade.validation.exists;

import cdm.event.common.PositionIdentifier;
import cdm.observable.asset.PriceSchedule;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportablePriceSource;
import drr.base.trade.basket.CustomBasket;
import drr.enrichment.common.EnrichmentData;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableInformationBaseOnlyExistsValidator implements ValidatorWithArg<ReportableInformationBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableInformationBase> ValidationResult<ReportableInformationBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("globalPartyInformation", ExistenceChecker.isSet((List<? extends PartyInformation>) o.getGlobalPartyInformation()))
				.put("reportableAction", ExistenceChecker.isSet((ReportableActionEnum) o.getReportableAction()))
				.put("enrichment", ExistenceChecker.isSet((EnrichmentData) o.getEnrichment()))
				.put("confirmationMethod", ExistenceChecker.isSet((ConfirmationMethodEnum) o.getConfirmationMethod()))
				.put("originalExecutionTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getOriginalExecutionTimestamp()))
				.put("finalContractualSettlementDate", ExistenceChecker.isSet((Date) o.getFinalContractualSettlementDate()))
				.put("cryptoBased", ExistenceChecker.isSet((Boolean) o.getCryptoBased()))
				.put("customBasket", ExistenceChecker.isSet((CustomBasket) o.getCustomBasket()))
				.put("intragroup", ExistenceChecker.isSet((Boolean) o.getIntragroup()))
				.put("affiliated", ExistenceChecker.isSet((Boolean) o.getAffiliated()))
				.put("underlyingAssetLastAvailableSpotPrice", ExistenceChecker.isSet((PriceSchedule) o.getUnderlyingAssetLastAvailableSpotPrice()))
				.put("underlyingAssetPriceSource", ExistenceChecker.isSet((List<? extends ReportablePriceSource>) o.getUnderlyingAssetPriceSource()))
				.put("subsequentPositionUTI", ExistenceChecker.isSet((PositionIdentifier) o.getSubsequentPositionUTI()))
				.put("counterpartyPositionPriorUTI", ExistenceChecker.isSet((PositionIdentifier) o.getCounterpartyPositionPriorUTI()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableInformationBase", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableInformationBase", path, "");
		}
		return failure("ReportableInformationBase", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableInformationBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
