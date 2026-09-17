package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityVarianceCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityVarianceCalculationTypeFormatValidator implements Validator<CommodityVarianceCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityVarianceCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityVarianceCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityVarianceCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityVarianceCalculation", path, "", res.getError());
				}
				return success("CommodityVarianceCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityVarianceCalculation", path, "");
			})
			.collect(toList());
	}

}
