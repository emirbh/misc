package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.legaldocumentation.csa.AdditionalObligations;
import cdm.legaldocumentation.csa.CoveredTransactions;
import cdm.legaldocumentation.csa.ExposureScope;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoveredTransactionsOnlyExistsValidator implements ValidatorWithArg<CoveredTransactions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoveredTransactions> ValidationResult<CoveredTransactions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("inclusionDate", ExistenceChecker.isSet((Date) o.getInclusionDate()))
				.put("coveredTransactions", ExistenceChecker.isSet((List<? extends ProductTaxonomy>) o.getCoveredTransactions()))
				.put("bespokeCoveredTransactions", ExistenceChecker.isSet((List<String>) o.getBespokeCoveredTransactions()))
				.put("additionalObligations", ExistenceChecker.isSet((List<? extends AdditionalObligations>) o.getAdditionalObligations()))
				.put("exposure", ExistenceChecker.isSet((String) o.getExposure()))
				.put("legacyExposure", ExistenceChecker.isSet((List<? extends ExposureScope>) o.getLegacyExposure()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoveredTransactions", ValidationResult.ValidationType.ONLY_EXISTS, "CoveredTransactions", path, "");
		}
		return failure("CoveredTransactions", ValidationResult.ValidationType.ONLY_EXISTS, "CoveredTransactions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
