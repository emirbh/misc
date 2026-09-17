package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QuasiGovernmentIssuerTypeTypeFormatValidator implements Validator<QuasiGovernmentIssuerType> {

	private List<ComparisonResult> getComparisonResults(QuasiGovernmentIssuerType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuasiGovernmentIssuerType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuasiGovernmentIssuerType", ValidationResult.ValidationType.TYPE_FORMAT, "QuasiGovernmentIssuerType", path, "", res.getError());
				}
				return success("QuasiGovernmentIssuerType", ValidationResult.ValidationType.TYPE_FORMAT, "QuasiGovernmentIssuerType", path, "");
			})
			.collect(toList());
	}

}
