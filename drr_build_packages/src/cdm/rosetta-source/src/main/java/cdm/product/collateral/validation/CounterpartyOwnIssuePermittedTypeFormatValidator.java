package cdm.product.collateral.validation;

import cdm.product.collateral.CounterpartyOwnIssuePermitted;
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

public class CounterpartyOwnIssuePermittedTypeFormatValidator implements Validator<CounterpartyOwnIssuePermitted> {

	private List<ComparisonResult> getComparisonResults(CounterpartyOwnIssuePermitted o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyOwnIssuePermitted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartyOwnIssuePermitted", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartyOwnIssuePermitted", path, "", res.getError());
				}
				return success("CounterpartyOwnIssuePermitted", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartyOwnIssuePermitted", path, "");
			})
			.collect(toList());
	}

}
