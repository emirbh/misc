package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommodityPerformanceSwapBase;
import fpml.consolidated.com.CommodityPerformanceSwapLeg;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPerformanceSwapBaseOnlyExistsValidator implements ValidatorWithArg<CommodityPerformanceSwapBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPerformanceSwapBase> ValidationResult<CommodityPerformanceSwapBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("settlementCurrency", ExistenceChecker.isSet((IdentifiedCurrency) o.getSettlementCurrency()))
				.put("commodityPerformanceSwapLeg", ExistenceChecker.isSet((List<? extends CommodityPerformanceSwapLeg>) o.getCommodityPerformanceSwapLeg()))
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
			return success("CommodityPerformanceSwapBase", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPerformanceSwapBase", path, "");
		}
		return failure("CommodityPerformanceSwapBase", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPerformanceSwapBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
