package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.OrganisationIdentification38__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class OrganisationIdentification38__1TypeFormatValidator implements Validator<OrganisationIdentification38__1> {

	private List<ComparisonResult> getComparisonResults(OrganisationIdentification38__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("nm", o.getNm(), 1, of(105), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrganisationIdentification38__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrganisationIdentification38__1", ValidationResult.ValidationType.TYPE_FORMAT, "OrganisationIdentification38__1", path, "", res.getError());
				}
				return success("OrganisationIdentification38__1", ValidationResult.ValidationType.TYPE_FORMAT, "OrganisationIdentification38__1", path, "");
			})
			.collect(toList());
	}

}
