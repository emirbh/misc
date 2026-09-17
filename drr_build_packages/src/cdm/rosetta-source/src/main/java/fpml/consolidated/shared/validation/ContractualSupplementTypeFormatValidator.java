package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ContractualSupplement;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ContractualSupplementTypeFormatValidator implements Validator<ContractualSupplement> {

	private List<ComparisonResult> getComparisonResults(ContractualSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("contractualSupplementScheme", o.getContractualSupplementScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractualSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "", res.getError());
				}
				return success("ContractualSupplement", ValidationResult.ValidationType.TYPE_FORMAT, "ContractualSupplement", path, "");
			})
			.collect(toList());
	}

}
