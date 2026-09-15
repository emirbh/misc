package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AdmissionToTrading;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdmissionToTradingTypeFormatValidator implements Validator<AdmissionToTrading> {

	private List<ComparisonResult> getComparisonResults(AdmissionToTrading o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdmissionToTrading o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdmissionToTrading", ValidationResult.ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "", res.getError());
				}
				return success("AdmissionToTrading", ValidationResult.ValidationType.TYPE_FORMAT, "AdmissionToTrading", path, "");
			})
			.collect(toList());
	}

}
