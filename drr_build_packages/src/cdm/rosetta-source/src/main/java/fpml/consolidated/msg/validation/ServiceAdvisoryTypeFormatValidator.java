package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ServiceAdvisory;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class ServiceAdvisoryTypeFormatValidator implements Validator<ServiceAdvisory> {

	private List<ComparisonResult> getComparisonResults(ServiceAdvisory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceAdvisory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceAdvisory", ValidationResult.ValidationType.TYPE_FORMAT, "ServiceAdvisory", path, "", res.getError());
				}
				return success("ServiceAdvisory", ValidationResult.ValidationType.TYPE_FORMAT, "ServiceAdvisory", path, "");
			})
			.collect(toList());
	}

}
