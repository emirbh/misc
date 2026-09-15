package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ContractValuationData8__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ContractValuationData8__1TypeFormatValidator implements Validator<ContractValuationData8__1> {

	private List<ComparisonResult> getComparisonResults(ContractValuationData8__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("dlta", o.getDlta(), of(25), of(5), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractValuationData8__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractValuationData8__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractValuationData8__1", path, "", res.getError());
				}
				return success("ContractValuationData8__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractValuationData8__1", path, "");
			})
			.collect(toList());
	}

}
