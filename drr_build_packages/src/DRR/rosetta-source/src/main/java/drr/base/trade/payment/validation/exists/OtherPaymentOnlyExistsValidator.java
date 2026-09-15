package drr.base.trade.payment.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.payment.OtherPayment;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OtherPaymentOnlyExistsValidator implements ValidatorWithArg<OtherPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OtherPayment> ValidationResult<OtherPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("paymentType", ExistenceChecker.isSet((PaymentType4Code) o.getPaymentType()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCurrency()))
				.put("date", ExistenceChecker.isSet((Date) o.getDate()))
				.put("payer", ExistenceChecker.isSet((String) o.getPayer()))
				.put("payerFormat", ExistenceChecker.isSet((PartyIdentifierFormatEnum) o.getPayerFormat()))
				.put("receiver", ExistenceChecker.isSet((String) o.getReceiver()))
				.put("receiverFormat", ExistenceChecker.isSet((PartyIdentifierFormatEnum) o.getReceiverFormat()))
				.put("payerSchemeName", ExistenceChecker.isSet((String) o.getPayerSchemeName()))
				.put("receiverSchemeName", ExistenceChecker.isSet((String) o.getReceiverSchemeName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OtherPayment", ValidationResult.ValidationType.ONLY_EXISTS, "OtherPayment", path, "");
		}
		return failure("OtherPayment", ValidationResult.ValidationType.ONLY_EXISTS, "OtherPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
