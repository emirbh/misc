package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
import fpml.consolidated.com.FixedPriceLeg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.SettlementPeriodsFixedPrice;
import fpml.consolidated.fpmlenum.FlatRateEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedPriceLegOnlyExistsValidator implements ValidatorWithArg<FixedPriceLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedPriceLeg> ValidationResult<FixedPriceLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("fixedPriceSchedule", ExistenceChecker.isSet((CommodityFixedPriceSchedule) o.getFixedPriceSchedule()))
				.put("fixedPrice", ExistenceChecker.isSet((CommodityFixedPrice) o.getFixedPrice()))
				.put("worldscaleRate", ExistenceChecker.isSet((BigDecimal) o.getWorldscaleRate()))
				.put("contractRate", ExistenceChecker.isSet((NonNegativeMoney) o.getContractRate()))
				.put("settlementPeriodsPrice", ExistenceChecker.isSet((List<? extends SettlementPeriodsFixedPrice>) o.getSettlementPeriodsPrice()))
				.put("totalPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getTotalPrice()))
				.put("notionalQuantitySchedule", ExistenceChecker.isSet((CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule()))
				.put("notionalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getNotionalQuantity()))
				.put("settlementPeriodsNotionalQuantity", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsNotionalQuantity>) o.getSettlementPeriodsNotionalQuantity()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getTotalNotionalQuantity()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.put("relativePaymentDates", ExistenceChecker.isSet((CommodityRelativePaymentDates) o.getRelativePaymentDates()))
				.put("paymentDates", ExistenceChecker.isSet((AdjustableDatesOrRelativeDateOffset) o.getPaymentDates()))
				.put("masterAgreementPaymentDates", ExistenceChecker.isSet((Boolean) o.getMasterAgreementPaymentDates()))
				.put("flatRate", ExistenceChecker.isSet((FlatRateEnum) o.getFlatRate()))
				.put("flatRateAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getFlatRateAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedPriceLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FixedPriceLeg", path, "");
		}
		return failure("FixedPriceLeg", ValidationResult.ValidationType.ONLY_EXISTS, "FixedPriceLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
