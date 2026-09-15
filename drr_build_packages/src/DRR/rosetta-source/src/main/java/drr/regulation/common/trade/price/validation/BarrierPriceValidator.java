package drr.regulation.common.trade.price.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.trade.price.BarrierPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BarrierPriceValidator implements Validator<BarrierPrice> {

	private List<ComparisonResult> getComparisonResults(BarrierPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", (PriceFormat) o.getPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("notation", (PriceNotationEnum) o.getNotation() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BarrierPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BarrierPrice", ValidationResult.ValidationType.CARDINALITY, "BarrierPrice", path, "", res.getError());
				}
				return success("BarrierPrice", ValidationResult.ValidationType.CARDINALITY, "BarrierPrice", path, "");
			})
			.collect(toList());
	}

}
