package drr.regulation.common.dtcc.trade.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnderlyingAssetReportTypeFormatValidator implements Validator<UnderlyingAssetReport> {

	private List<ComparisonResult> getComparisonResults(UnderlyingAssetReport o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyingAssetReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyingAssetReport", ValidationResult.ValidationType.TYPE_FORMAT, "UnderlyingAssetReport", path, "", res.getError());
				}
				return success("UnderlyingAssetReport", ValidationResult.ValidationType.TYPE_FORMAT, "UnderlyingAssetReport", path, "");
			})
			.collect(toList());
	}

}
