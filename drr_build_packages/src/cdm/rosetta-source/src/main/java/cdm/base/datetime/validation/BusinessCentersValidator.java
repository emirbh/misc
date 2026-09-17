package cdm.base.datetime.validation;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.metafields.ReferenceWithMetaBusinessCenters;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessCentersValidator implements Validator<BusinessCenters> {

	private List<ComparisonResult> getComparisonResults(BusinessCenters o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessCentersReference", (ReferenceWithMetaBusinessCenters) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCenters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCenters", ValidationResult.ValidationType.CARDINALITY, "BusinessCenters", path, "", res.getError());
				}
				return success("BusinessCenters", ValidationResult.ValidationType.CARDINALITY, "BusinessCenters", path, "");
			})
			.collect(toList());
	}

}
