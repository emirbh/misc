package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryProductInfoValidator implements Validator<RegulatoryProductInfo> {

	private List<ComparisonResult> getComparisonResults(RegulatoryProductInfo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("parties", (RegulatoryReportingProductParties) o.getParties() != null ? 1 : 0, 0, 1), 
				checkCardinality("dates", (RegulatoryReportingProductDates) o.getDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("sizes", (RegulatoryReportingProductSizes) o.getSizes() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyers", (RegulatoryReportingProductUnderlyers) o.getUnderlyers() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceTerms", (RegulatoryReportingProductPriceTerms) o.getPriceTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherCalculationTerms", (RegulatoryReportingProductCalculationTerms) o.getOtherCalculationTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionDetails", (RegulatoryReportingNonCDEOptionDetails) o.getOptionDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDetails", (RegulatoryReportingProductSettlementDetails) o.getSettlementDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditDetails", (RegulatoryReportingProductCreditDetails) o.getCreditDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxDetails", (RegulatoryReportingProductNonCDEFxDetails) o.getFxDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityDetails", (RegulatoryReportingNonCDEProductCommodityDetails) o.getCommodityDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryProductInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryProductInfo", ValidationResult.ValidationType.CARDINALITY, "RegulatoryProductInfo", path, "", res.getError());
				}
				return success("RegulatoryProductInfo", ValidationResult.ValidationType.CARDINALITY, "RegulatoryProductInfo", path, "");
			})
			.collect(toList());
	}

}
