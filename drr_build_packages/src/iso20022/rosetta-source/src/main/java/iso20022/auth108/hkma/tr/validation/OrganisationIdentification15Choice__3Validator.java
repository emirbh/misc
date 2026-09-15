package iso20022.auth108.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.tr.OrganisationIdentification15Choice__3;
import iso20022.auth108.hkma.tr.OrganisationIdentification38__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification15Choice__3Validator implements Validator<OrganisationIdentification15Choice__3> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification15Choice__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (OrganisationIdentification38__2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification15Choice__3", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__3", path, "", res.getError());
				}
				return success("OrganisationIdentification15Choice__3", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__3", path, "");
			})
			.collect(toList());
	}

}
