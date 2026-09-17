package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.ProductSummary;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ProductSummaryOnlyExistsValidator implements ValidatorWithArg<ProductSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ProductSummary> ValidationResult<ProductSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("finalSettlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getFinalSettlementDate()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("settlementLocation", ExistenceChecker.isSet((BusinessCenter) o.getSettlementLocation()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("indexFactor", ExistenceChecker.isSet((BigDecimal) o.getIndexFactor()))
				.put("admissionToTrading", ExistenceChecker.isSet((AdmissionToTrading) o.getAdmissionToTrading()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProductSummary", ValidationResult.ValidationType.ONLY_EXISTS, "ProductSummary", path, "");
		}
		return failure("ProductSummary", ValidationResult.ValidationType.ONLY_EXISTS, "ProductSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
