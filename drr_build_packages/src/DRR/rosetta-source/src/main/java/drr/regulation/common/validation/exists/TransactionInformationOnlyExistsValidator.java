package drr.regulation.common.validation.exists;

import cdm.event.common.TradeIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TransactionInformationOnlyExistsValidator implements ValidatorWithArg<TransactionInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TransactionInformation> ValidationResult<TransactionInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transactionIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTransactionIdentifier()))
				.put("priorTransactionIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getPriorTransactionIdentifier()))
				.put("reportableExecutionVenue", ExistenceChecker.isSet((ReportableExecutionVenue) o.getReportableExecutionVenue()))
				.put("largeSizeTrade", ExistenceChecker.isSet((Boolean) o.getLargeSizeTrade()))
				.put("duration", ExistenceChecker.isSet((CommodityTimeUnitEnum) o.getDuration()))
				.put("tradableOnTradingVenue", ExistenceChecker.isSet((TradableOnTradingVenueEnum) o.getTradableOnTradingVenue()))
				.put("underlierTradedOnTradingVenue", ExistenceChecker.isSet((Boolean) o.getUnderlierTradedOnTradingVenue()))
				.put("underlierAssetTradingPlatformIdentifier", ExistenceChecker.isSet((String) o.getUnderlierAssetTradingPlatformIdentifier()))
				.put("internalTradeIdentifier", ExistenceChecker.isSet((String) o.getInternalTradeIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TransactionInformation", ValidationResult.ValidationType.ONLY_EXISTS, "TransactionInformation", path, "");
		}
		return failure("TransactionInformation", ValidationResult.ValidationType.ONLY_EXISTS, "TransactionInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
