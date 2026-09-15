package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.TradeReportHeader4__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReportHeader4__1OnlyExistsValidator implements ValidatorWithArg<TradeReportHeader4__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReportHeader4__1> ValidationResult<TradeReportHeader4__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nbRcrds", ExistenceChecker.isSet((Long) o.getNbRcrds()))
				.put("newTradRpstryIdr", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getNewTradRpstryIdr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReportHeader4__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReportHeader4__1", path, "");
		}
		return failure("TradeReportHeader4__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReportHeader4__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
