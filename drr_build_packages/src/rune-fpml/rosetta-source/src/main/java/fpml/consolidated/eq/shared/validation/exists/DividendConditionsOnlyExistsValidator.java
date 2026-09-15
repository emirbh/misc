package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.DividendPaymentDate;
import fpml.consolidated.fpmlenum.DividendAmountTypeEnum;
import fpml.consolidated.fpmlenum.DividendCompositionEnum;
import fpml.consolidated.fpmlenum.DividendEntitlementEnum;
import fpml.consolidated.fpmlenum.DividendPeriodEnum;
import fpml.consolidated.fpmlenum.NonCashDividendTreatmentEnum;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.InterestAccrualsCompoundingMethod;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendConditionsOnlyExistsValidator implements ValidatorWithArg<DividendConditions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendConditions> ValidationResult<DividendConditions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dividendReinvestment", ExistenceChecker.isSet((Boolean) o.getDividendReinvestment()))
				.put("dividendEntitlement", ExistenceChecker.isSet((DividendEntitlementEnum) o.getDividendEntitlement()))
				.put("dividendAmount", ExistenceChecker.isSet((DividendAmountTypeEnum) o.getDividendAmount()))
				.put("dividendPaymentDate", ExistenceChecker.isSet((DividendPaymentDate) o.getDividendPaymentDate()))
				.put("dividendPeriodEffectiveDate", ExistenceChecker.isSet((DateReference) o.getDividendPeriodEffectiveDate()))
				.put("dividendPeriodEndDate", ExistenceChecker.isSet((DateReference) o.getDividendPeriodEndDate()))
				.put("dividendPeriod", ExistenceChecker.isSet((DividendPeriodEnum) o.getDividendPeriod()))
				.put("extraOrdinaryDividends", ExistenceChecker.isSet((PartyReference) o.getExtraOrdinaryDividends()))
				.put("excessDividendAmount", ExistenceChecker.isSet((DividendAmountTypeEnum) o.getExcessDividendAmount()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("currencyReference", ExistenceChecker.isSet((IdentifiedCurrencyReference) o.getCurrencyReference()))
				.put("dividendFxTriggerDate", ExistenceChecker.isSet((DividendPaymentDate) o.getDividendFxTriggerDate()))
				.put("interestAccrualsMethod", ExistenceChecker.isSet((InterestAccrualsCompoundingMethod) o.getInterestAccrualsMethod()))
				.put("numberOfIndexUnits", ExistenceChecker.isSet((BigDecimal) o.getNumberOfIndexUnits()))
				.put("declaredCashDividendPercentage", ExistenceChecker.isSet((BigDecimal) o.getDeclaredCashDividendPercentage()))
				.put("declaredCashEquivalentDividendPercentage", ExistenceChecker.isSet((BigDecimal) o.getDeclaredCashEquivalentDividendPercentage()))
				.put("nonCashDividendTreatment", ExistenceChecker.isSet((NonCashDividendTreatmentEnum) o.getNonCashDividendTreatment()))
				.put("dividendComposition", ExistenceChecker.isSet((DividendCompositionEnum) o.getDividendComposition()))
				.put("specialDividends", ExistenceChecker.isSet((Boolean) o.getSpecialDividends()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendConditions", ValidationResult.ValidationType.ONLY_EXISTS, "DividendConditions", path, "");
		}
		return failure("DividendConditions", ValidationResult.ValidationType.ONLY_EXISTS, "DividendConditions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
