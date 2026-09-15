package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedInterestCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityFixedInterestCalculationTypeFormatValidator implements Validator<CommodityFixedInterestCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedInterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedInterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedInterestCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "", res.getError());
				}
				return success("CommodityFixedInterestCalculation", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFixedInterestCalculation", path, "");
			})
			.collect(toList());
	}

}
