package drr.standards.iosco.cde.version3.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.quantity.NotionalPeriod;
import drr.standards.iosco.cde.version3.Leg;
import drr.standards.iso.Direction2Enum;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegOnlyExistsValidator implements ValidatorWithArg<Leg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Leg> ValidationResult<Leg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodicPayment", ExistenceChecker.isSet((PeriodicPayment) o.getPeriodicPayment()))
				.put("notionalAmount", ExistenceChecker.isSet((BigDecimal) o.getNotionalAmount()))
				.put("notionalAmountSchedule", ExistenceChecker.isSet((List<? extends NotionalPeriod>) o.getNotionalAmountSchedule()))
				.put("notionalQuantitySchedule", ExistenceChecker.isSet((List<? extends NotionalPeriod>) o.getNotionalQuantitySchedule()))
				.put("notionalCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getNotionalCurrency()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getTotalNotionalQuantity()))
				.put("fixedRate", ExistenceChecker.isSet((BigDecimal) o.getFixedRate()))
				.put("settlementCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getSettlementCurrency()))
				.put("spread", ExistenceChecker.isSet((PriceFormat) o.getSpread()))
				.put("spreadNotation", ExistenceChecker.isSet((PriceNotationEnum) o.getSpreadNotation()))
				.put("spreadCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getSpreadCurrency()))
				.put("quantityUnitOfMeasure", ExistenceChecker.isSet((String) o.getQuantityUnitOfMeasure()))
				.put("direction2", ExistenceChecker.isSet((Direction2Enum) o.getDirection2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Leg", ValidationResult.ValidationType.ONLY_EXISTS, "Leg", path, "");
		}
		return failure("Leg", ValidationResult.ValidationType.ONLY_EXISTS, "Leg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
