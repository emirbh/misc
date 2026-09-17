package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegReportingPayment;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryProductInfo;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEOptionDetails;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEProductCommodityDetails;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCalculationTerms;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCreditDetails;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductDates;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductNonCDEFxDetails;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductParties;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductPriceTerms;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSettlementDetails;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSizes;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductUnderlyers;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryProductInfoOnlyExistsValidator implements ValidatorWithArg<RegulatoryProductInfo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryProductInfo> ValidationResult<RegulatoryProductInfo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("parties", ExistenceChecker.isSet((RegulatoryReportingProductParties) o.getParties()))
				.put("dates", ExistenceChecker.isSet((RegulatoryReportingProductDates) o.getDates()))
				.put("sizes", ExistenceChecker.isSet((RegulatoryReportingProductSizes) o.getSizes()))
				.put("underlyers", ExistenceChecker.isSet((RegulatoryReportingProductUnderlyers) o.getUnderlyers()))
				.put("priceTerms", ExistenceChecker.isSet((RegulatoryReportingProductPriceTerms) o.getPriceTerms()))
				.put("otherCalculationTerms", ExistenceChecker.isSet((RegulatoryReportingProductCalculationTerms) o.getOtherCalculationTerms()))
				.put("optionDetails", ExistenceChecker.isSet((RegulatoryReportingNonCDEOptionDetails) o.getOptionDetails()))
				.put("settlementDetails", ExistenceChecker.isSet((RegulatoryReportingProductSettlementDetails) o.getSettlementDetails()))
				.put("otherPayment", ExistenceChecker.isSet((List<? extends RegReportingPayment>) o.getOtherPayment()))
				.put("creditDetails", ExistenceChecker.isSet((RegulatoryReportingProductCreditDetails) o.getCreditDetails()))
				.put("fxDetails", ExistenceChecker.isSet((RegulatoryReportingProductNonCDEFxDetails) o.getFxDetails()))
				.put("commodityDetails", ExistenceChecker.isSet((RegulatoryReportingNonCDEProductCommodityDetails) o.getCommodityDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryProductInfo", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryProductInfo", path, "");
		}
		return failure("RegulatoryProductInfo", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryProductInfo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
