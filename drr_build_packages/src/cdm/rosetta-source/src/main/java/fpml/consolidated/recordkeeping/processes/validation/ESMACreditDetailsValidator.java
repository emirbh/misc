package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMACreditDetails;
import fpml.consolidated.recordkeeping.processes.ESMACreditSeniority;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMACreditDetailsValidator implements Validator<ESMACreditDetails> {

	private List<ComparisonResult> getComparisonResults(ESMACreditDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("seniority", (ESMACreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMACreditDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMACreditDetails", ValidationResult.ValidationType.CARDINALITY, "ESMACreditDetails", path, "", res.getError());
				}
				return success("ESMACreditDetails", ValidationResult.ValidationType.CARDINALITY, "ESMACreditDetails", path, "");
			})
			.collect(toList());
	}

}
