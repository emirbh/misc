package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.ird.InflationRate;
import fpml.consolidated.ird.ReturnCalculation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnCalculationOnlyExistsValidator implements ValidatorWithArg<ReturnCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnCalculation> ValidationResult<ReturnCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("finalValuation", ExistenceChecker.isSet((QuotationCharacteristics) o.getFinalValuation()))
				.put("inflationRate", ExistenceChecker.isSet((InflationRate) o.getInflationRate()))
				.put("initialPrice", ExistenceChecker.isSet((ActualPrice) o.getInitialPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnCalculation", path, "");
		}
		return failure("ReturnCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
