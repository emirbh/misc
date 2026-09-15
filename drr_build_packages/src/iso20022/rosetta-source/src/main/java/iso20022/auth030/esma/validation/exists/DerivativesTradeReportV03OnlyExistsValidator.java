package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.DerivativesTradeReportV03;
import iso20022.auth030.esma.TradeData57Choice__1;
import iso20022.auth030.esma.TradeReportHeader4__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativesTradeReportV03OnlyExistsValidator implements ValidatorWithArg<DerivativesTradeReportV03, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativesTradeReportV03> ValidationResult<DerivativesTradeReportV03> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptHdr", ExistenceChecker.isSet((TradeReportHeader4__1) o.getRptHdr()))
				.put("tradData", ExistenceChecker.isSet((TradeData57Choice__1) o.getTradData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativesTradeReportV03", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativesTradeReportV03", path, "");
		}
		return failure("DerivativesTradeReportV03", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativesTradeReportV03", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
