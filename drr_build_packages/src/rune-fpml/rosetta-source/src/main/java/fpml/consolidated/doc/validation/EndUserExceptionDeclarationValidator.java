package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EndUserExceptionDeclarationValidator implements Validator<EndUserExceptionDeclaration> {

	private List<ComparisonResult> getComparisonResults(EndUserExceptionDeclaration o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EndUserExceptionDeclaration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EndUserExceptionDeclaration", ValidationResult.ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "", res.getError());
				}
				return success("EndUserExceptionDeclaration", ValidationResult.ValidationType.CARDINALITY, "EndUserExceptionDeclaration", path, "");
			})
			.collect(toList());
	}

}
