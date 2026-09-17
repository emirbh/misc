package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FacilityType;
import fpml.consolidated.fpmlenum.LoanAllAssetsEnum;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.FacilityIdentifier;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableAssetsOnlyExistsValidator implements ValidatorWithArg<ApplicableAssets, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableAssets> ValidationResult<ApplicableAssets> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dealIdentifier", ExistenceChecker.isSet((List<? extends DealIdentifier>) o.getDealIdentifier()))
				.put("facilityIdentifier", ExistenceChecker.isSet((List<? extends FacilityIdentifier>) o.getFacilityIdentifier()))
				.put("facilityType", ExistenceChecker.isSet((List<? extends FacilityType>) o.getFacilityType()))
				.put("allAssets", ExistenceChecker.isSet((LoanAllAssetsEnum) o.getAllAssets()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableAssets", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableAssets", path, "");
		}
		return failure("ApplicableAssets", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableAssets", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
