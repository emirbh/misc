package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericCommodityDeliveryPeriodTypeFormatValidator implements Validator<GenericCommodityDeliveryPeriod> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityDeliveryPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityDeliveryPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityDeliveryPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "GenericCommodityDeliveryPeriod", path, "", res.getError());
				}
				return success("GenericCommodityDeliveryPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "GenericCommodityDeliveryPeriod", path, "");
			})
			.collect(toList());
	}

}
