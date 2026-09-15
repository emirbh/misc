package drr.regulation.sec.rewrite.trade.validation.exists;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.standards.iso.Direction2Enum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SECLegOnlyExistsValidator implements ValidatorWithArg<SECLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SECLeg> ValidationResult<SECLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodicPayment", ExistenceChecker.isSet((CommonPeriodicPayment) o.getPeriodicPayment()))
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
				.put("notionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getNotionalQuantity()))
				.put("fixingDate", ExistenceChecker.isSet((ZonedDateTime) o.getFixingDate()))
				.put("quantityFrequency", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getQuantityFrequency()))
				.put("quantityFrequencyMultiplier", ExistenceChecker.isSet((Integer) o.getQuantityFrequencyMultiplier()))
				.put("payerIdentifier", ExistenceChecker.isSet((String) o.getPayerIdentifier()))
				.put("receiverIdentifier", ExistenceChecker.isSet((String) o.getReceiverIdentifier()))
				.put("settlementLocation", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getSettlementLocation()))
				.put("nextFloatingReferenceResetDate", ExistenceChecker.isSet((Date) o.getNextFloatingReferenceResetDate()))
				.put("floatingRateIndex", ExistenceChecker.isSet((String) o.getFloatingRateIndex()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SECLeg", ValidationResult.ValidationType.ONLY_EXISTS, "SECLeg", path, "");
		}
		return failure("SECLeg", ValidationResult.ValidationType.ONLY_EXISTS, "SECLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
