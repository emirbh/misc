package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.OrganisationIdentification15Choice__2;
import iso20022.auth108.hkma.dtcc.OrganisationIdentification38__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification15Choice__2Validator implements Validator<OrganisationIdentification15Choice__2> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification15Choice__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (OrganisationIdentification38__1) o.getOthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("anyBIC", (String) o.getAnyBIC() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification15Choice__2", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__2", path, "", res.getError());
				}
				return success("OrganisationIdentification15Choice__2", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__2", path, "");
			})
			.collect(toList());
	}

}
