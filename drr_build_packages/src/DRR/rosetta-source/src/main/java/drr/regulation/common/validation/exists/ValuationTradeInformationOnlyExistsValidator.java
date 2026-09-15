package drr.regulation.common.validation.exists;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.event.common.TradeIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.LastFloatingReference;
import drr.regulation.common.ValuationTradeInformation;
import drr.standards.iso.ActionTypeEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationTradeInformationOnlyExistsValidator implements ValidatorWithArg<ValuationTradeInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationTradeInformation> ValidationResult<ValuationTradeInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("uniqueTradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getUniqueTradeIdentifier()))
				.put("uniqueProductIdentifier", ExistenceChecker.isSet((List<? extends ProductIdentifier>) o.getUniqueProductIdentifier()))
				.put("action", ExistenceChecker.isSet((ActionTypeEnum) o.getAction()))
				.put("nextFloatingReferenceResetDateLeg1", ExistenceChecker.isSet((Date) o.getNextFloatingReferenceResetDateLeg1()))
				.put("nextFloatingReferenceResetDateLeg2", ExistenceChecker.isSet((Date) o.getNextFloatingReferenceResetDateLeg2()))
				.put("lastFloatingReference", ExistenceChecker.isSet((LastFloatingReference) o.getLastFloatingReference()))
				.put("assetClass", ExistenceChecker.isSet((CommonAssetClass) o.getAssetClass()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationTradeInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationTradeInformation", path, "");
		}
		return failure("ValuationTradeInformation", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationTradeInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
