package drr.regulation.common.valuation.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.valuation.CriticalDataElement;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CriticalDataElementOnlyExistsValidator implements ValidatorWithArg<CriticalDataElement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CriticalDataElement> ValidationResult<CriticalDataElement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("counterparty1", ExistenceChecker.isSet((String) o.getCounterparty1()))
				.put("counterparty2IdentifierType", ExistenceChecker.isSet((Boolean) o.getCounterparty2IdentifierType()))
				.put("counterparty2", ExistenceChecker.isSet((String) o.getCounterparty2()))
				.put("valuationAmount", ExistenceChecker.isSet((BigDecimal) o.getValuationAmount()))
				.put("valuationCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getValuationCurrency()))
				.put("valuationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getValuationTimestamp()))
				.put("valuationMethod", ExistenceChecker.isSet((ValuationType1Code) o.getValuationMethod()))
				.put("delta", ExistenceChecker.isSet((BigDecimal) o.getDelta()))
				.put("actionType", ExistenceChecker.isSet((ActionTypeEnum) o.getActionType()))
				.put("level", ExistenceChecker.isSet((ReportLevelEnum) o.getLevel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "");
		}
		return failure("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
