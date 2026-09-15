package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ServiceAdvisory;
import fpml.consolidated.msg.ServiceAdvisoryCategory;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ServiceAdvisoryValidator implements Validator<ServiceAdvisory> {

	private List<ComparisonResult> getComparisonResults(ServiceAdvisory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("category", (ServiceAdvisoryCategory) o.getCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveFrom", (ZonedDateTime) o.getEffectiveFrom() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveTo", (ZonedDateTime) o.getEffectiveTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceAdvisory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceAdvisory", ValidationResult.ValidationType.CARDINALITY, "ServiceAdvisory", path, "", res.getError());
				}
				return success("ServiceAdvisory", ValidationResult.ValidationType.CARDINALITY, "ServiceAdvisory", path, "");
			})
			.collect(toList());
	}

}
