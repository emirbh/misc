package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.NoReasonCode;
import iso20022.auth030.esma.Tranche3;
import iso20022.auth030.esma.TrancheIndicator3Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TrancheIndicator3ChoiceValidator implements Validator<TrancheIndicator3Choice> {

	private List<ComparisonResult> getComparisonResults(TrancheIndicator3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("trnchd", (Tranche3) o.getTrnchd() != null ? 1 : 0, 0, 1), 
				checkCardinality("utrnchd", (NoReasonCode) o.getUtrnchd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TrancheIndicator3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TrancheIndicator3Choice", ValidationResult.ValidationType.CARDINALITY, "TrancheIndicator3Choice", path, "", res.getError());
				}
				return success("TrancheIndicator3Choice", ValidationResult.ValidationType.CARDINALITY, "TrancheIndicator3Choice", path, "");
			})
			.collect(toList());
	}

}
