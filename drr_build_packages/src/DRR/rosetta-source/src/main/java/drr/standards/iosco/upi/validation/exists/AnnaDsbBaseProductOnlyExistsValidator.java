package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbENVR;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import drr.standards.iosco.upi.AnnaDsbINDP;
import drr.standards.iosco.upi.AnnaDsbMETL;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import drr.standards.iosco.upi.AnnaDsbPOLY;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbBaseProductOnlyExistsValidator implements ValidatorWithArg<AnnaDsbBaseProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbBaseProduct> ValidationResult<AnnaDsbBaseProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("AGRI", ExistenceChecker.isSet((AnnaDsbAGRI) o.getAGRI()))
				.put("ENVR", ExistenceChecker.isSet((AnnaDsbENVR) o.getENVR()))
				.put("FRTL", ExistenceChecker.isSet((AnnaDsbFRTL) o.getFRTL()))
				.put("OTHC", ExistenceChecker.isSet((AnnaDsbOTHC) o.getOTHC()))
				.put("INFL", ExistenceChecker.isSet((AnnaDsbEmpty) o.getINFL()))
				.put("POLY", ExistenceChecker.isSet((AnnaDsbPOLY) o.getPOLY()))
				.put("OTHR", ExistenceChecker.isSet((AnnaDsbEmpty) o.getOTHR()))
				.put("MCEX", ExistenceChecker.isSet((AnnaDsbEmpty) o.getMCEX()))
				.put("NRGY", ExistenceChecker.isSet((AnnaDsbNRGY) o.getNRGY()))
				.put("INDP", ExistenceChecker.isSet((AnnaDsbINDP) o.getINDP()))
				.put("OEST", ExistenceChecker.isSet((AnnaDsbEmpty) o.getOEST()))
				.put("METL", ExistenceChecker.isSet((AnnaDsbMETL) o.getMETL()))
				.put("PAPR", ExistenceChecker.isSet((AnnaDsbPAPR) o.getPAPR()))
				.put("FRGT", ExistenceChecker.isSet((AnnaDsbFRGT) o.getFRGT()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbBaseProduct", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbBaseProduct", path, "");
		}
		return failure("AnnaDsbBaseProduct", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbBaseProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
