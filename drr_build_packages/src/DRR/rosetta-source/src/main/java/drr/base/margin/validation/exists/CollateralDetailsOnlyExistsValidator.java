package drr.base.margin.validation.exists;

import cdm.event.common.TradeIdentifier;
import cdm.product.collateral.Collateral;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.CollateralDetails;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralDetailsOnlyExistsValidator implements ValidatorWithArg<CollateralDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralDetails> ValidationResult<CollateralDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getCollateralTimestamp()))
				.put("collateral", ExistenceChecker.isSet((Collateral) o.getCollateral()))
				.put("uniqueTradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getUniqueTradeIdentifier()))
				.put("action", ExistenceChecker.isSet((MarginActionEnum) o.getAction()))
				.put("collateralisationCategory", ExistenceChecker.isSet((CollateralisationType3Code) o.getCollateralisationCategory()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralDetails", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralDetails", path, "");
		}
		return failure("CollateralDetails", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
