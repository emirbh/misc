package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingIssuerTypeTypeFormatValidator implements Validator<AnnaDsbUnderlyingIssuerType> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlyingIssuerType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlyingIssuerType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlyingIssuerType", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingIssuerType", path, "", res.getError());
				}
				return success("AnnaDsbUnderlyingIssuerType", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbUnderlyingIssuerType", path, "");
			})
			.collect(toList());
	}

}
