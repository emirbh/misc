package drr.base.trade.validation.exists;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportablePriceSource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportablePriceSourceOnlyExistsValidator implements ValidatorWithArg<ReportablePriceSource, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportablePriceSource> ValidationResult<ReportablePriceSource> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assetIdentifier", ExistenceChecker.isSet((List<? extends AssetIdentifier>) o.getAssetIdentifier()))
				.put("otherId", ExistenceChecker.isSet((String) o.getOtherId()))
				.put("underlyingAssetPriceSource", ExistenceChecker.isSet((String) o.getUnderlyingAssetPriceSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportablePriceSource", ValidationResult.ValidationType.ONLY_EXISTS, "ReportablePriceSource", path, "");
		}
		return failure("ReportablePriceSource", ValidationResult.ValidationType.ONLY_EXISTS, "ReportablePriceSource", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
