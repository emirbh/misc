package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EnvironmentalProduct;
import fpml.consolidated.com.EnvironmentalProductApplicableLaw;
import fpml.consolidated.com.EnvironmentalProductComplaincePeriod;
import fpml.consolidated.com.EnvironmentalTrackingSystem;
import fpml.consolidated.fpmlenum.EnvironmentalProductTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalProductValidator implements Validator<EnvironmentalProduct> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productType", (EnvironmentalProductTypeEnum) o.getProductType() != null ? 1 : 0, 1, 1), 
				checkCardinality("compliancePeriod", (EnvironmentalProductComplaincePeriod) o.getCompliancePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("applicableLaw", (EnvironmentalProductApplicableLaw) o.getApplicableLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("trackingSystem", (EnvironmentalTrackingSystem) o.getTrackingSystem() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalProduct", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalProduct", path, "", res.getError());
				}
				return success("EnvironmentalProduct", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalProduct", path, "");
			})
			.collect(toList());
	}

}
