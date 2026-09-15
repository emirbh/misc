package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.GenericIdentification175;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericIdentification175Validator implements Validator<GenericIdentification175> {

	private List<ComparisonResult> getComparisonResults(GenericIdentification175 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("schmeNm", (String) o.getSchmeNm() != null ? 1 : 0, 0, 1), 
				checkCardinality("issr", (String) o.getIssr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericIdentification175 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericIdentification175", ValidationResult.ValidationType.CARDINALITY, "GenericIdentification175", path, "", res.getError());
				}
				return success("GenericIdentification175", ValidationResult.ValidationType.CARDINALITY, "GenericIdentification175", path, "");
			})
			.collect(toList());
	}

}
