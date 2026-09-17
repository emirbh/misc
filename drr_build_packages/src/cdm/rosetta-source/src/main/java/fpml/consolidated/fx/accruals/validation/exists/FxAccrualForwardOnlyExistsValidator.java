package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.FxAccrualForward;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodSchedule;
import fpml.consolidated.fx.accruals.FxAdjustedDateAndDateAdjustments;
import fpml.consolidated.fx.accruals.FxAverageRate;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.fx.targets.FxExpirySchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualForwardOnlyExistsValidator implements ValidatorWithArg<FxAccrualForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualForward> ValidationResult<FxAccrualForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("accrual", ExistenceChecker.isSet((FxAccrual) o.getAccrual()))
				.put("expiryDate", ExistenceChecker.isSet((FxExpiryDate) o.getExpiryDate()))
				.put("expirySchedule", ExistenceChecker.isSet((FxExpirySchedule) o.getExpirySchedule()))
				.put("settlementDate", ExistenceChecker.isSet((FxAdjustedDateAndDateAdjustments) o.getSettlementDate()))
				.put("settlementSchedule", ExistenceChecker.isSet((FxSettlementSchedule) o.getSettlementSchedule()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((List<? extends FxAccrualLinearPayoffRegion>) o.getLinearPayoffRegion()))
				.put("averageRate", ExistenceChecker.isSet((FxAverageRate) o.getAverageRate()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxAccrualBarrier>) o.getBarrier()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends SimplePayment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.put("settlementPeriodSchedule", ExistenceChecker.isSet((FxAccrualSettlementPeriodSchedule) o.getSettlementPeriodSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualForward", path, "");
		}
		return failure("FxAccrualForward", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
