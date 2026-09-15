package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.DerivativesTradeMarginDataReportV01;
import iso20022.auth108.iso.SupplementaryData1;
import iso20022.auth108.iso.TradeData55Choice;
import iso20022.auth108.iso.TradeReportHeader4;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativesTradeMarginDataReportV01OnlyExistsValidator implements ValidatorWithArg<DerivativesTradeMarginDataReportV01, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativesTradeMarginDataReportV01> ValidationResult<DerivativesTradeMarginDataReportV01> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptHdr", ExistenceChecker.isSet((TradeReportHeader4) o.getRptHdr()))
				.put("tradData", ExistenceChecker.isSet((TradeData55Choice) o.getTradData()))
				.put("splmtryData", ExistenceChecker.isSet((List<? extends SupplementaryData1>) o.getSplmtryData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativesTradeMarginDataReportV01", path, "");
		}
		return failure("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativesTradeMarginDataReportV01", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
