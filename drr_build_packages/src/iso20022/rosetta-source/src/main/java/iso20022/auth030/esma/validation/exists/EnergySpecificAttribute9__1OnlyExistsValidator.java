package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.DeliveryInterconnectionPoint1Choice__1;
import iso20022.auth030.esma.EnergyDeliveryAttribute10__1;
import iso20022.auth030.esma.EnergyLoadType1Code;
import iso20022.auth030.esma.EnergySpecificAttribute9__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnergySpecificAttribute9__1OnlyExistsValidator implements ValidatorWithArg<EnergySpecificAttribute9__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnergySpecificAttribute9__1> ValidationResult<EnergySpecificAttribute9__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dlvryPtOrZone", ExistenceChecker.isSet((List<? extends DeliveryInterconnectionPoint1Choice__1>) o.getDlvryPtOrZone()))
				.put("intrCnnctnPt", ExistenceChecker.isSet((DeliveryInterconnectionPoint1Choice__1) o.getIntrCnnctnPt()))
				.put("ldTp", ExistenceChecker.isSet((EnergyLoadType1Code) o.getLdTp()))
				.put("dlvryAttr", ExistenceChecker.isSet((List<? extends EnergyDeliveryAttribute10__1>) o.getDlvryAttr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnergySpecificAttribute9__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnergySpecificAttribute9__1", path, "");
		}
		return failure("EnergySpecificAttribute9__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnergySpecificAttribute9__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
