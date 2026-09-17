package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.PendingPayment;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.UnderlyerLoanRate;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SpreadScheduleReference;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasketConstituentOnlyExistsValidator implements ValidatorWithArg<BasketConstituent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BasketConstituent> ValidationResult<BasketConstituent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("constituentWeight", ExistenceChecker.isSet((ConstituentWeight) o.getConstituentWeight()))
				.put("underlyerPrice", ExistenceChecker.isSet((Price) o.getUnderlyerPrice()))
				.put("underlyerNotional", ExistenceChecker.isSet((Money) o.getUnderlyerNotional()))
				.put("underlyerSpread", ExistenceChecker.isSet((SpreadScheduleReference) o.getUnderlyerSpread()))
				.put("underlyerFinancing", ExistenceChecker.isSet((UnderlyerInterestLeg) o.getUnderlyerFinancing()))
				.put("underlyerLoanRate", ExistenceChecker.isSet((UnderlyerLoanRate) o.getUnderlyerLoanRate()))
				.put("underlyerCollateral", ExistenceChecker.isSet((Collateral) o.getUnderlyerCollateral()))
				.put("dividendPayout", ExistenceChecker.isSet((DividendPayout) o.getDividendPayout()))
				.put("couponPayment", ExistenceChecker.isSet((PendingPayment) o.getCouponPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasketConstituent", ValidationResult.ValidationType.ONLY_EXISTS, "BasketConstituent", path, "");
		}
		return failure("BasketConstituent", ValidationResult.ValidationType.ONLY_EXISTS, "BasketConstituent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
