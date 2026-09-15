package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.PaymentType;
import fpml.consolidated.shared.PricingStructureReference;
import fpml.consolidated.shared.SettlementInformation;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentOnlyExistsValidator implements ValidatorWithArg<Payment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Payment> ValidationResult<Payment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("href", ExistenceChecker.isSet((String) o.getHref()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrAdjustedDate) o.getPaymentDate()))
				.put("paymentType", ExistenceChecker.isSet((PaymentType) o.getPaymentType()))
				.put("settlementInformation", ExistenceChecker.isSet((SettlementInformation) o.getSettlementInformation()))
				.put("discountFactor", ExistenceChecker.isSet((BigDecimal) o.getDiscountFactor()))
				.put("presentValueAmount", ExistenceChecker.isSet((Money) o.getPresentValueAmount()))
				.put("pricingStructureReference", ExistenceChecker.isSet((PricingStructureReference) o.getPricingStructureReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Payment", ValidationResult.ValidationType.ONLY_EXISTS, "Payment", path, "");
		}
		return failure("Payment", ValidationResult.ValidationType.ONLY_EXISTS, "Payment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
