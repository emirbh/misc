package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.ProRataFacilities;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProRataFacilitiesValidator implements Validator<ProRataFacilities> {

	private List<ComparisonResult> getComparisonResults(ProRataFacilities o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityReference", (List<? extends FacilityReference>) o.getFacilityReference() == null ? 0 : o.getFacilityReference().size(), 2, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProRataFacilities o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProRataFacilities", ValidationResult.ValidationType.CARDINALITY, "ProRataFacilities", path, "", res.getError());
				}
				return success("ProRataFacilities", ValidationResult.ValidationType.CARDINALITY, "ProRataFacilities", path, "");
			})
			.collect(toList());
	}

}
