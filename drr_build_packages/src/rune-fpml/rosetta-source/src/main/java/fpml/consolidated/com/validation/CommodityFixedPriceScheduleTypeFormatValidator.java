package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceScheduleTypeFormatValidator implements Validator<CommodityFixedPriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPriceSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFixedPriceSchedule", path, "", res.getError());
				}
				return success("CommodityFixedPriceSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFixedPriceSchedule", path, "");
			})
			.collect(toList());
	}

}
