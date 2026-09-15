package drr.regulation.common.trade.price.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.trade.price.BarrierPrice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BarrierPriceOnlyExistsValidator implements ValidatorWithArg<BarrierPrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BarrierPrice> ValidationResult<BarrierPrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("price", ExistenceChecker.isSet((PriceFormat) o.getPrice()))
				.put("notation", ExistenceChecker.isSet((PriceNotationEnum) o.getNotation()))
				.put("currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BarrierPrice", ValidationResult.ValidationType.ONLY_EXISTS, "BarrierPrice", path, "");
		}
		return failure("BarrierPrice", ValidationResult.ValidationType.ONLY_EXISTS, "BarrierPrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
