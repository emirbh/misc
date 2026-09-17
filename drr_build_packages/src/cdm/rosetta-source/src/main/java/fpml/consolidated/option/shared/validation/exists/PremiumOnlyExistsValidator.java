package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.PremiumTypeEnum;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PremiumOnlyExistsValidator implements ValidatorWithArg<Premium, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Premium> ValidationResult<Premium> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDate()))
				.put("premiumType", ExistenceChecker.isSet((PremiumTypeEnum) o.getPremiumType()))
				.put("pricePerOption", ExistenceChecker.isSet((Money) o.getPricePerOption()))
				.put("percentageOfNotional", ExistenceChecker.isSet((BigDecimal) o.getPercentageOfNotional()))
				.put("discountFactor", ExistenceChecker.isSet((BigDecimal) o.getDiscountFactor()))
				.put("presentValueAmount", ExistenceChecker.isSet((Money) o.getPresentValueAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Premium", ValidationResult.ValidationType.ONLY_EXISTS, "Premium", path, "");
		}
		return failure("Premium", ValidationResult.ValidationType.ONLY_EXISTS, "Premium", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
