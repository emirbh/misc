package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCreditDetails;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductCreditDetailsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductCreditDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductCreditDetails> ValidationResult<RegulatoryReportingProductCreditDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("attachmentPoint", ExistenceChecker.isSet((BigDecimal) o.getAttachmentPoint()))
				.put("exhaustionPoint", ExistenceChecker.isSet((BigDecimal) o.getExhaustionPoint()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("indexFactor", ExistenceChecker.isSet((BigDecimal) o.getIndexFactor()))
				.put("indexSeries", ExistenceChecker.isSet((Integer) o.getIndexSeries()))
				.put("indexAnnexVersion", ExistenceChecker.isSet((Integer) o.getIndexAnnexVersion()))
				.put("fixedRecoveryFinalPrice", ExistenceChecker.isSet((BigDecimal) o.getFixedRecoveryFinalPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductCreditDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductCreditDetails", path, "");
		}
		return failure("RegulatoryReportingProductCreditDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductCreditDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
