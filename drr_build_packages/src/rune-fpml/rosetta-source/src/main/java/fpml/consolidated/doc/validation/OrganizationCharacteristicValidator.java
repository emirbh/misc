package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.OrganizationCharacteristic;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganizationCharacteristicValidator implements Validator<OrganizationCharacteristic> {

	private List<ComparisonResult> getComparisonResults(OrganizationCharacteristic o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("organizationCharacteristicScheme", (String) o.getOrganizationCharacteristicScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganizationCharacteristic o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganizationCharacteristic", ValidationResult.ValidationType.CARDINALITY, "OrganizationCharacteristic", path, "", res.getError());
				}
				return success("OrganizationCharacteristic", ValidationResult.ValidationType.CARDINALITY, "OrganizationCharacteristic", path, "");
			})
			.collect(toList());
	}

}
