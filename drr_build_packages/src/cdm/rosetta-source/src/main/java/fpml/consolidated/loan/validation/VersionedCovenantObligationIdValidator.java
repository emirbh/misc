package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.CovenantObligationId;
import fpml.consolidated.loan.VersionedCovenantObligationId;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VersionedCovenantObligationIdValidator implements Validator<VersionedCovenantObligationId> {

	private List<ComparisonResult> getComparisonResults(VersionedCovenantObligationId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("covenantObligationId", (CovenantObligationId) o.getCovenantObligationId() != null ? 1 : 0, 1, 1), 
				checkCardinality("version", (Integer) o.getVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (IdentifiedDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedCovenantObligationId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedCovenantObligationId", ValidationResult.ValidationType.CARDINALITY, "VersionedCovenantObligationId", path, "", res.getError());
				}
				return success("VersionedCovenantObligationId", ValidationResult.ValidationType.CARDINALITY, "VersionedCovenantObligationId", path, "");
			})
			.collect(toList());
	}

}
