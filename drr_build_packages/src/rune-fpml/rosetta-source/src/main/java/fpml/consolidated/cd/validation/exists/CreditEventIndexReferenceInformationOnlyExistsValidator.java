package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditEventIndexReferenceInformation;
import fpml.consolidated.cd.IndexAnnexSource;
import fpml.consolidated.cd.IndexId;
import fpml.consolidated.cd.IndexName;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.cd.SettledEntityMatrix;
import fpml.consolidated.cd.Tranche;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventIndexReferenceInformationOnlyExistsValidator implements ValidatorWithArg<CreditEventIndexReferenceInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEventIndexReferenceInformation> ValidationResult<CreditEventIndexReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("indexName", ExistenceChecker.isSet((IndexName) o.getIndexName()))
				.put("indexId", ExistenceChecker.isSet((List<? extends IndexId>) o.getIndexId()))
				.put("indexSeries", ExistenceChecker.isSet((Integer) o.getIndexSeries()))
				.put("indexAnnexVersion", ExistenceChecker.isSet((Integer) o.getIndexAnnexVersion()))
				.put("indexAnnexDate", ExistenceChecker.isSet((ZonedDateTime) o.getIndexAnnexDate()))
				.put("indexAnnexSource", ExistenceChecker.isSet((IndexAnnexSource) o.getIndexAnnexSource()))
				.put("excludedReferenceEntity", ExistenceChecker.isSet((List<? extends ReferenceInformation>) o.getExcludedReferenceEntity()))
				.put("tranche", ExistenceChecker.isSet((Tranche) o.getTranche()))
				.put("settledEntityMatrix", ExistenceChecker.isSet((SettledEntityMatrix) o.getSettledEntityMatrix()))
				.put("indexFactor", ExistenceChecker.isSet((BigDecimal) o.getIndexFactor()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("indexReversionDate", ExistenceChecker.isSet((ZonedDateTime) o.getIndexReversionDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEventIndexReferenceInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEventIndexReferenceInformation", path, "");
		}
		return failure("CreditEventIndexReferenceInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEventIndexReferenceInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
