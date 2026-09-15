package drr.regulation.common.trade.price.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.price.BarrierPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BarrierPriceTypeFormatValidator implements Validator<BarrierPrice> {

	private List<ComparisonResult> getComparisonResults(BarrierPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BarrierPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BarrierPrice", ValidationResult.ValidationType.TYPE_FORMAT, "BarrierPrice", path, "", res.getError());
				}
				return success("BarrierPrice", ValidationResult.ValidationType.TYPE_FORMAT, "BarrierPrice", path, "");
			})
			.collect(toList());
	}

}
