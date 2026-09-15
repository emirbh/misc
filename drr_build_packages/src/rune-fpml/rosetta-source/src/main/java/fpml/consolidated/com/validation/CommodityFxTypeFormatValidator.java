package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFx;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommodityFxTypeFormatValidator implements Validator<CommodityFx> {

	private List<ComparisonResult> getComparisonResults(CommodityFx o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("dayCount", o.getDayCount(), empty(), of(0), empty(), empty()), 
				checkNumber("dayNumber", o.getDayNumber(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFx o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFx", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFx", path, "", res.getError());
				}
				return success("CommodityFx", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityFx", path, "");
			})
			.collect(toList());
	}

}
