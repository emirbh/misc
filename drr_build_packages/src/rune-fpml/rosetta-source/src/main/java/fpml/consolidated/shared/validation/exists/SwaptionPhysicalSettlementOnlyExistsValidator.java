package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementRateSource;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SwaptionPhysicalSettlementOnlyExistsValidator implements ValidatorWithArg<SwaptionPhysicalSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SwaptionPhysicalSettlement> ValidationResult<SwaptionPhysicalSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("clearedPhysicalSettlement", ExistenceChecker.isSet((Boolean) o.getClearedPhysicalSettlement()))
				.put("predeterminedClearingOrganizationPartyReference", ExistenceChecker.isSet((PartyReference) o.getPredeterminedClearingOrganizationPartyReference()))
				.put("mutuallyAgreedClearinghouse", ExistenceChecker.isSet((MutuallyAgreedClearinghouse) o.getMutuallyAgreedClearinghouse()))
				.put("agreedDiscountRate", ExistenceChecker.isSet((BenchmarkRate) o.getAgreedDiscountRate()))
				.put("settlementRateSource", ExistenceChecker.isSet((SettlementRateSource) o.getSettlementRateSource()))
				.put("quotationRateType", ExistenceChecker.isSet((QuotationRateTypeEnum) o.getQuotationRateType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SwaptionPhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "SwaptionPhysicalSettlement", path, "");
		}
		return failure("SwaptionPhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "SwaptionPhysicalSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
