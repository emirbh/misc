package drr.regulation.common.validation.exists;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableValuation;
import drr.regulation.common.ValuationDetails;
import drr.standards.iso.ReportLevelEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableValuationOnlyExistsValidator implements ValidatorWithArg<ReportableValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableValuation> ValidationResult<ReportableValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("valuationDetails", ExistenceChecker.isSet((ValuationDetails) o.getValuationDetails()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformation) o.getReportableInformation()))
				.put("collateralDetails", ExistenceChecker.isSet((Collateral) o.getCollateralDetails()))
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends Identifier>) o.getEventIdentifier()))
				.put("level", ExistenceChecker.isSet((ReportLevelEnum) o.getLevel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableValuation", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableValuation", path, "");
		}
		return failure("ReportableValuation", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
