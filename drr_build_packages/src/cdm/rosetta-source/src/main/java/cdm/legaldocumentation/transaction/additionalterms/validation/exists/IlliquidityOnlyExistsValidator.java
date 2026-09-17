package cdm.legaldocumentation.transaction.additionalterms.validation.exists;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.math.Quantity;
import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.Illiquidity;
import cdm.observable.asset.SettlementRateOption;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IlliquidityOnlyExistsValidator implements ValidatorWithArg<Illiquidity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Illiquidity> ValidationResult<Illiquidity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("illiquidityIsApplicable", ExistenceChecker.isSet((Boolean) o.getIlliquidityIsApplicable()))
				.put("escrowArrangement", ExistenceChecker.isSet((EscrowArrangement) o.getEscrowArrangement()))
				.put("minimumAmount", ExistenceChecker.isSet((Quantity) o.getMinimumAmount()))
				.put("fallbackReferencePrice", ExistenceChecker.isSet((SettlementRateOption) o.getFallbackReferencePrice()))
				.put("illiquidityValuationDate", ExistenceChecker.isSet((AdjustedRelativeDateOffset) o.getIlliquidityValuationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Illiquidity", ValidationResult.ValidationType.ONLY_EXISTS, "Illiquidity", path, "");
		}
		return failure("Illiquidity", ValidationResult.ValidationType.ONLY_EXISTS, "Illiquidity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
