package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.FertilizerCommodityUrea2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FertilizerCommodityUrea2__1TypeFormatValidator implements Validator<FertilizerCommodityUrea2__1> {

	private List<ComparisonResult> getComparisonResults(FertilizerCommodityUrea2__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FertilizerCommodityUrea2__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FertilizerCommodityUrea2__1", ValidationResult.ValidationType.TYPE_FORMAT, "FertilizerCommodityUrea2__1", path, "", res.getError());
				}
				return success("FertilizerCommodityUrea2__1", ValidationResult.ValidationType.TYPE_FORMAT, "FertilizerCommodityUrea2__1", path, "");
			})
			.collect(toList());
	}

}
