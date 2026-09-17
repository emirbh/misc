package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityReturnCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityReturnCalculationTypeFormatValidator implements Validator<CommodityReturnCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityReturnCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReturnCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReturnCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "", res.getError());
				}
				return success("CommodityReturnCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "");
			})
			.collect(toList());
	}

}
