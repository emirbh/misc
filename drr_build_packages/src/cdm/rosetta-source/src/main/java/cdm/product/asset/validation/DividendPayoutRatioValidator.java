package cdm.product.asset.validation;

import cdm.observable.asset.metafields.ReferenceWithMetaBasketConstituent;
import cdm.product.asset.DividendPayoutRatio;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPayoutRatioValidator implements Validator<DividendPayoutRatio> {

	private List<ComparisonResult> getComparisonResults(DividendPayoutRatio o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("totalRatio", (BigDecimal) o.getTotalRatio() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashRatio", (BigDecimal) o.getCashRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonCashRatio", (BigDecimal) o.getNonCashRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketConstituent", (ReferenceWithMetaBasketConstituent) o.getBasketConstituent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayoutRatio o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayoutRatio", ValidationResult.ValidationType.CARDINALITY, "DividendPayoutRatio", path, "", res.getError());
				}
				return success("DividendPayoutRatio", ValidationResult.ValidationType.CARDINALITY, "DividendPayoutRatio", path, "");
			})
			.collect(toList());
	}

}
