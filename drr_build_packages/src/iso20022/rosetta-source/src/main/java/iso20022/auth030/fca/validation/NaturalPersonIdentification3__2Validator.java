package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.NaturalPersonIdentification2__1;
import iso20022.auth030.fca.NaturalPersonIdentification3__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NaturalPersonIdentification3__2Validator implements Validator<NaturalPersonIdentification3__2> {

	private List<ComparisonResult> getComparisonResults(NaturalPersonIdentification3__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (NaturalPersonIdentification2__1) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("ctry", (String) o.getCtry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NaturalPersonIdentification3__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NaturalPersonIdentification3__2", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3__2", path, "", res.getError());
				}
				return success("NaturalPersonIdentification3__2", ValidationResult.ValidationType.CARDINALITY, "NaturalPersonIdentification3__2", path, "");
			})
			.collect(toList());
	}

}
