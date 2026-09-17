package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.EquityForwardExpiration;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityForwardExpirationValidator implements Validator<EquityForwardExpiration> {

	private List<ComparisonResult> getComparisonResults(EquityForwardExpiration o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityExpirationTimeType", (TimeTypeEnum) o.getEquityExpirationTimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExpirationTime", (BusinessCenterTime) o.getEquityExpirationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTimeDetermination", (DeterminationMethod) o.getExpirationTimeDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityForwardExpiration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityForwardExpiration", ValidationResult.ValidationType.CARDINALITY, "EquityForwardExpiration", path, "", res.getError());
				}
				return success("EquityForwardExpiration", ValidationResult.ValidationType.CARDINALITY, "EquityForwardExpiration", path, "");
			})
			.collect(toList());
	}

}
