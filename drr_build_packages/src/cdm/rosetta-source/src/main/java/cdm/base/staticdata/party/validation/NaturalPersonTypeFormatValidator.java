package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.NaturalPerson;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NaturalPersonTypeFormatValidator implements Validator<NaturalPerson> {

	private List<ComparisonResult> getComparisonResults(NaturalPerson o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPerson o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NaturalPerson", ValidationResult.ValidationType.TYPE_FORMAT, "NaturalPerson", path, "", res.getError());
				}
				return success("NaturalPerson", ValidationResult.ValidationType.TYPE_FORMAT, "NaturalPerson", path, "");
			})
			.collect(toList());
	}

}
