package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AgriculturalCommodityLiveStock2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AgriculturalCommodityLiveStock2TypeFormatValidator implements Validator<AgriculturalCommodityLiveStock2> {

	private List<ComparisonResult> getComparisonResults(AgriculturalCommodityLiveStock2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AgriculturalCommodityLiveStock2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AgriculturalCommodityLiveStock2", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityLiveStock2", path, "", res.getError());
				}
				return success("AgriculturalCommodityLiveStock2", ValidationResult.ValidationType.TYPE_FORMAT, "AgriculturalCommodityLiveStock2", path, "");
			})
			.collect(toList());
	}

}
