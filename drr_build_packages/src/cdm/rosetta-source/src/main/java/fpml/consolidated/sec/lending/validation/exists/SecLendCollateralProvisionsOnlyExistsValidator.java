package fpml.consolidated.sec.lending.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.CollateralArrangement;
import fpml.consolidated.repo.CollateralType;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecLendCollateralProvisionsOnlyExistsValidator implements ValidatorWithArg<SecLendCollateralProvisions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecLendCollateralProvisions> ValidationResult<SecLendCollateralProvisions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralType", ExistenceChecker.isSet((CollateralType) o.getCollateralType()))
				.put("triParty", ExistenceChecker.isSet((TriParty) o.getTriParty()))
				.put("marginRatio", ExistenceChecker.isSet((BigDecimal) o.getMarginRatio()))
				.put("haircut", ExistenceChecker.isSet((BigDecimal) o.getHaircut()))
				.put("collateralCurrency", ExistenceChecker.isSet((Currency) o.getCollateralCurrency()))
				.put("fxRate", ExistenceChecker.isSet((FxRate) o.getFxRate()))
				.put("collateralArrangement", ExistenceChecker.isSet((CollateralArrangement) o.getCollateralArrangement()))
				.put("exclusiveArrangements", ExistenceChecker.isSet((Boolean) o.getExclusiveArrangements()))
				.put("eligibleForRehypothecation", ExistenceChecker.isSet((Boolean) o.getEligibleForRehypothecation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecLendCollateralProvisions", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendCollateralProvisions", path, "");
		}
		return failure("SecLendCollateralProvisions", ValidationResult.ValidationType.ONLY_EXISTS, "SecLendCollateralProvisions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
