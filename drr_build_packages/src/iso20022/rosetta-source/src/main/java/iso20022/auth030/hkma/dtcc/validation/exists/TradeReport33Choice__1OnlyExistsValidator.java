package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.TradeData43__1;
import iso20022.auth030.hkma.dtcc.TradeData43__2;
import iso20022.auth030.hkma.dtcc.TradeData43__3;
import iso20022.auth030.hkma.dtcc.TradeData43__4;
import iso20022.auth030.hkma.dtcc.TradeData43__5;
import iso20022.auth030.hkma.dtcc.TradeData43__6;
import iso20022.auth030.hkma.dtcc.TradeData43__7;
import iso20022.auth030.hkma.dtcc.TradeReport33Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReport33Choice__1OnlyExistsValidator implements ValidatorWithArg<TradeReport33Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReport33Choice__1> ValidationResult<TradeReport33Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("new", ExistenceChecker.isSet((TradeData43__1) o.getNew()))
				.put("mod", ExistenceChecker.isSet((TradeData43__2) o.getMod()))
				.put("crrctn", ExistenceChecker.isSet((TradeData43__3) o.getCrrctn()))
				.put("termntn", ExistenceChecker.isSet((TradeData43__4) o.getTermntn()))
				.put("valtnUpd", ExistenceChecker.isSet((TradeData43__5) o.getValtnUpd()))
				.put("err", ExistenceChecker.isSet((TradeData43__6) o.getErr()))
				.put("portOut", ExistenceChecker.isSet((TradeData43__7) o.getPortOut()))
				.put("rvv", ExistenceChecker.isSet((TradeData43__3) o.getRvv()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReport33Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport33Choice__1", path, "");
		}
		return failure("TradeReport33Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReport33Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
