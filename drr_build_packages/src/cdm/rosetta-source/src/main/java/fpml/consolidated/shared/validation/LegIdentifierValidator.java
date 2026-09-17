package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.LegId;
import fpml.consolidated.shared.LegIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegIdentifierValidator implements Validator<LegIdentifier> {

	private List<ComparisonResult> getComparisonResults(LegIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("legId", (LegId) o.getLegId() != null ? 1 : 0, 0, 1), 
				checkCardinality("version", (Integer) o.getVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (IdentifiedDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegIdentifier", ValidationResult.ValidationType.CARDINALITY, "LegIdentifier", path, "", res.getError());
				}
				return success("LegIdentifier", ValidationResult.ValidationType.CARDINALITY, "LegIdentifier", path, "");
			})
			.collect(toList());
	}

}
