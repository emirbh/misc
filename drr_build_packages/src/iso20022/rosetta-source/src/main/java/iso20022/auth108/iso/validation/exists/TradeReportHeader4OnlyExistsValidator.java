package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.Pagination1;
import iso20022.auth108.iso.TradeReportHeader4;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReportHeader4OnlyExistsValidator implements ValidatorWithArg<TradeReportHeader4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReportHeader4> ValidationResult<TradeReportHeader4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptExctnDt", ExistenceChecker.isSet((Date) o.getRptExctnDt()))
				.put("msgPgntn", ExistenceChecker.isSet((Pagination1) o.getMsgPgntn()))
				.put("nbRcrds", ExistenceChecker.isSet((Long) o.getNbRcrds()))
				.put("cmptntAuthrty", ExistenceChecker.isSet((List<String>) o.getCmptntAuthrty()))
				.put("newTradRpstryIdr", ExistenceChecker.isSet((OrganisationIdentification15Choice) o.getNewTradRpstryIdr()))
				.put("rptgPurp", ExistenceChecker.isSet((List<String>) o.getRptgPurp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReportHeader4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReportHeader4", path, "");
		}
		return failure("TradeReportHeader4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeReportHeader4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
