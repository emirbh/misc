package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.NaturalPersonIdentification2;
import iso20022.auth108.iso.NaturalPersonIdentification3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NaturalPersonIdentification3Validator implements Validator<NaturalPersonIdentification3> {

	private List<ComparisonResult> getComparisonResults(NaturalPersonIdentification3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (NaturalPersonIdentification2) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("ctry", (String) o.getCtry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPersonIdentification3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NaturalPersonIdentification3", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3", path, "", res.getError());
				}
				return success("NaturalPersonIdentification3", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3", path, "");
			})
			.collect(toList());
	}

}
