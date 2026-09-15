package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityBasket;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityNotionalAmount;
import fpml.consolidated.com.CommodityNotionalAmountReference;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.CommodityVarianceCalculation;
import fpml.consolidated.com.CommodityVarianceLeg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityVarianceLegOnlyExistsValidator implements ValidatorWithArg<CommodityVarianceLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityVarianceLeg> ValidationResult<CommodityVarianceLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("calculationDates", ExistenceChecker.isSet((AdjustableDates) o.getCalculationDates()))
				.put("calculationPeriods", ExistenceChecker.isSet((AdjustableDates) o.getCalculationPeriods()))
				.put("calculationPeriodsSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule()))
				.put("calculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getCalculationPeriodsReference()))
				.put("calculationPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference()))
				.put("calculationPeriodsDatesReference", ExistenceChecker.isSet((CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference()))
				.put("relativePaymentDates", ExistenceChecker.isSet((CommodityRelativePaymentDates) o.getRelativePaymentDates()))
				.put("paymentDates", ExistenceChecker.isSet((AdjustableDatesOrRelativeDateOffset) o.getPaymentDates()))
				.put("masterAgreementPaymentDates", ExistenceChecker.isSet((Boolean) o.getMasterAgreementPaymentDates()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("commodityBasket", ExistenceChecker.isSet((CommodityBasket) o.getCommodityBasket()))
				.put("notionalAmount", ExistenceChecker.isSet((CommodityNotionalAmount) o.getNotionalAmount()))
				.put("notionalAmountReference", ExistenceChecker.isSet((CommodityNotionalAmountReference) o.getNotionalAmountReference()))
				.put("varianceStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getVarianceStrikePrice()))
				.put("volatilityStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getVolatilityStrikePrice()))
				.put("varianceCalculation", ExistenceChecker.isSet((CommodityVarianceCalculation) o.getVarianceCalculation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityVarianceLeg", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityVarianceLeg", path, "");
		}
		return failure("CommodityVarianceLeg", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityVarianceLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
