package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDateRange;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessDateRangeValidator implements Validator<BusinessDateRange> {

	private List<ComparisonResult> getComparisonResults(BusinessDateRange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedFirstDate", (ZonedDateTime) o.getUnadjustedFirstDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedLastDate", (ZonedDateTime) o.getUnadjustedLastDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDayConvention", (BusinessDayConventionEnum) o.getBusinessDayConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDateRange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessDateRange", ValidationResult.ValidationType.CARDINALITY, "BusinessDateRange", path, "", res.getError());
				}
				return success("BusinessDateRange", ValidationResult.ValidationType.CARDINALITY, "BusinessDateRange", path, "");
			})
			.collect(toList());
	}

}
