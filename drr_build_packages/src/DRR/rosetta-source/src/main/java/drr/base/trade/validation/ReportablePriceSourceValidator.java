package drr.base.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportablePriceSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportablePriceSourceValidator implements Validator<ReportablePriceSource> {

	private List<ComparisonResult> getComparisonResults(ReportablePriceSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("otherId", (String) o.getOtherId() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetPriceSource", (String) o.getUnderlyingAssetPriceSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportablePriceSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportablePriceSource", ValidationResult.ValidationType.CARDINALITY, "ReportablePriceSource", path, "", res.getError());
				}
				return success("ReportablePriceSource", ValidationResult.ValidationType.CARDINALITY, "ReportablePriceSource", path, "");
			})
			.collect(toList());
	}

}
