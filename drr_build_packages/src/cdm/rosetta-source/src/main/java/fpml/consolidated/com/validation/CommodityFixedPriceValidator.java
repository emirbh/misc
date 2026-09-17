package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceValidator implements Validator<CommodityFixedPrice> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceCurrency", (Currency) o.getPriceCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("priceUnit", (QuantityUnit) o.getPriceUnit() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPrice", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedPrice", path, "", res.getError());
				}
				return success("CommodityFixedPrice", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedPrice", path, "");
			})
			.collect(toList());
	}

}
