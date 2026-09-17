package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.MutualFund;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class MutualFundTypeFormatValidator implements Validator<MutualFund> {

	private List<ComparisonResult> getComparisonResults(MutualFund o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty()), 
				checkString("fundManager", o.getFundManager(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutualFund o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutualFund", ValidationResult.ValidationType.TYPE_FORMAT, "MutualFund", path, "", res.getError());
				}
				return success("MutualFund", ValidationResult.ValidationType.TYPE_FORMAT, "MutualFund", path, "");
			})
			.collect(toList());
	}

}
