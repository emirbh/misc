package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.AveragePriceLeg;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.NonPeriodicFixedPriceLeg;
import fpml.consolidated.com.PhysicalLegBase;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityForwardOnlyExistsValidator implements ValidatorWithArg<CommodityForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityForward> ValidationResult<CommodityForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("valueDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getValueDate()))
				.put("fixedLeg", ExistenceChecker.isSet((NonPeriodicFixedPriceLeg) o.getFixedLeg()))
				.put("averagePriceLeg", ExistenceChecker.isSet((AveragePriceLeg) o.getAveragePriceLeg()))
				.put("physicalCommodityForwardLeg", ExistenceChecker.isSet((PhysicalLegBase) o.getPhysicalCommodityForwardLeg()))
				.put("commonPricing", ExistenceChecker.isSet((Boolean) o.getCommonPricing()))
				.put("marketDisruption", ExistenceChecker.isSet((CommodityMarketDisruption) o.getMarketDisruption()))
				.put("settlementDisruption", ExistenceChecker.isSet((CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption()))
				.put("rounding", ExistenceChecker.isSet((Rounding) o.getRounding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityForward", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityForward", path, "");
		}
		return failure("CommodityForward", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
