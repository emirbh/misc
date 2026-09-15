package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMACreditSeniority;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMACreditSeniorityValidator implements Validator<ESMACreditSeniority> {

	private List<ComparisonResult> getComparisonResults(ESMACreditSeniority o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSeniorityScheme", (String) o.getCreditSeniorityScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMACreditSeniority o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMACreditSeniority", ValidationResult.ValidationType.CARDINALITY, "ESMACreditSeniority", path, "", res.getError());
				}
				return success("ESMACreditSeniority", ValidationResult.ValidationType.CARDINALITY, "ESMACreditSeniority", path, "");
			})
			.collect(toList());
	}

}
