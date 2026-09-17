package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.CollateralValuation;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepoFarLegOnlyExistsValidator implements ValidatorWithArg<RepoFarLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RepoFarLeg> ValidationResult<RepoFarLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementDate()))
				.put("settlementAmount", ExistenceChecker.isSet((Money) o.getSettlementAmount()))
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("fxRate", ExistenceChecker.isSet((FxRate) o.getFxRate()))
				.put("deliveryMethod", ExistenceChecker.isSet((DeliveryMethod) o.getDeliveryMethod()))
				.put("deliveryDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getDeliveryDate()))
				.put("collateral", ExistenceChecker.isSet((List<? extends CollateralValuation>) o.getCollateral()))
				.put("repoInterest", ExistenceChecker.isSet((BigDecimal) o.getRepoInterest()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RepoFarLeg", ValidationResult.ValidationType.ONLY_EXISTS, "RepoFarLeg", path, "");
		}
		return failure("RepoFarLeg", ValidationResult.ValidationType.ONLY_EXISTS, "RepoFarLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
