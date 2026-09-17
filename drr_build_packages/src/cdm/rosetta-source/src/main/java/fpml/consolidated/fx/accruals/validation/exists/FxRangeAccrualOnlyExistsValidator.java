package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.fx.accruals.FxRangeAccrual;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxRangeAccrualOnlyExistsValidator implements ValidatorWithArg<FxRangeAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxRangeAccrual> ValidationResult<FxRangeAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("accrual", ExistenceChecker.isSet((FxAccrual) o.getAccrual()))
				.put("expiryDate", ExistenceChecker.isSet((FxExpiryDate) o.getExpiryDate()))
				.put("expirySchedule", ExistenceChecker.isSet((FxExpirySchedule) o.getExpirySchedule()))
				.put("settlementDate", ExistenceChecker.isSet((FxAdjustedDateAndDateAdjustments) o.getSettlementDate()))
				.put("settlementSchedule", ExistenceChecker.isSet((FxSettlementSchedule) o.getSettlementSchedule()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxAccrualBarrier>) o.getBarrier()))
				.put("premium", ExistenceChecker.isSet((List<? extends FxOptionPremium>) o.getPremium()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxRangeAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "FxRangeAccrual", path, "");
		}
		return failure("FxRangeAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "FxRangeAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
