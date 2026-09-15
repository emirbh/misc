package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.generic.GenericExerciseStyle;
import fpml.consolidated.generic.GenericProductFeature;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEOptionDetails;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingNonCDEOptionDetailsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingNonCDEOptionDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingNonCDEOptionDetails> ValidationResult<RegulatoryReportingNonCDEOptionDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("firstExerciseDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getFirstExerciseDate()))
				.put("optionExpirationDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getOptionExpirationDate()))
				.put("underlyerMaturityDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getUnderlyerMaturityDate()))
				.put("exerciseStyle", ExistenceChecker.isSet((GenericExerciseStyle) o.getExerciseStyle()))
				.put("feature", ExistenceChecker.isSet((List<? extends GenericProductFeature>) o.getFeature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingNonCDEOptionDetails", path, "");
		}
		return failure("RegulatoryReportingNonCDEOptionDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingNonCDEOptionDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
