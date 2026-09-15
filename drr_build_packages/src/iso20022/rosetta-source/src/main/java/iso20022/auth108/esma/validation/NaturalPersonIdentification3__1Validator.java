package iso20022.auth108.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.esma.NaturalPersonIdentification2__1;
import iso20022.auth108.esma.NaturalPersonIdentification3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NaturalPersonIdentification3__1Validator implements Validator<NaturalPersonIdentification3__1> {

	private List<ComparisonResult> getComparisonResults(NaturalPersonIdentification3__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (NaturalPersonIdentification2__1) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPersonIdentification3__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NaturalPersonIdentification3__1", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3__1", path, "", res.getError());
				}
				return success("NaturalPersonIdentification3__1", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3__1", path, "");
			})
			.collect(toList());
	}

}
