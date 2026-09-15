package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import drr.standards.iosco.upi.AnnaDsbCredit;
import drr.standards.iosco.upi.AnnaDsbEquity;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import drr.standards.iosco.upi.AnnaDsbRates;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUnderlyingAssetClassOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUnderlyingAssetClass, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUnderlyingAssetClass> ValidationResult<AnnaDsbUnderlyingAssetClass> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Rates", ExistenceChecker.isSet((AnnaDsbRates) o.getRates()))
				.put("Credit", ExistenceChecker.isSet((AnnaDsbCredit) o.getCredit()))
				.put("Commodities", ExistenceChecker.isSet((AnnaDsbCommodities) o.getCommodities()))
				.put("Equity", ExistenceChecker.isSet((AnnaDsbEquity) o.getEquity()))
				.put("Foreign_Exchange", ExistenceChecker.isSet((AnnaDsbForeign_Exchange) o.getForeign_Exchange()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingAssetClass", path, "");
		}
		return failure("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlyingAssetClass", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
