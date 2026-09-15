package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.eq.shared.DividendPeriod;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPeriodValidator implements Validator<DividendPeriod> {

	private List<ComparisonResult> getComparisonResults(DividendPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedStartDate", (IdentifiedDate) o.getUnadjustedStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedEndDate", (IdentifiedDate) o.getUnadjustedEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerReference", (AssetReference) o.getUnderlyerReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPeriod", ValidationResult.ValidationType.CARDINALITY, "DividendPeriod", path, "", res.getError());
				}
				return success("DividendPeriod", ValidationResult.ValidationType.CARDINALITY, "DividendPeriod", path, "");
			})
			.collect(toList());
	}

}
