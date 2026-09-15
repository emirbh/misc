package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__4;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification38__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification15Choice__4Validator implements Validator<OrganisationIdentification15Choice__4> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification15Choice__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lei", (String) o.getLei() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (OrganisationIdentification38__3) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification15Choice__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification15Choice__4", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__4", path, "", res.getError());
				}
				return success("OrganisationIdentification15Choice__4", ValidationResult.ValidationType.CARDINALITY, "OrganisationIdentification15Choice__4", path, "");
			})
			.collect(toList());
	}

}
