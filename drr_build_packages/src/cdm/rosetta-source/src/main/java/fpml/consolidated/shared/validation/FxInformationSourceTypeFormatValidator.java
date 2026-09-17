package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FxInformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class FxInformationSourceTypeFormatValidator implements Validator<FxInformationSource> {

	private List<ComparisonResult> getComparisonResults(FxInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rateSourcePageHeading", o.getRateSourcePageHeading(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxInformationSource", ValidationResult.ValidationType.TYPE_FORMAT, "FxInformationSource", path, "", res.getError());
				}
				return success("FxInformationSource", ValidationResult.ValidationType.TYPE_FORMAT, "FxInformationSource", path, "");
			})
			.collect(toList());
	}

}
