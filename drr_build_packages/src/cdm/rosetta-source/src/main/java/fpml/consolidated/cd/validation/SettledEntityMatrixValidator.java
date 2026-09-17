package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.MatrixSource;
import fpml.consolidated.cd.SettledEntityMatrix;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettledEntityMatrixValidator implements Validator<SettledEntityMatrix> {

	private List<ComparisonResult> getComparisonResults(SettledEntityMatrix o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("matrixSource", (MatrixSource) o.getMatrixSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("publicationDate", (ZonedDateTime) o.getPublicationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettledEntityMatrix o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettledEntityMatrix", ValidationResult.ValidationType.CARDINALITY, "SettledEntityMatrix", path, "", res.getError());
				}
				return success("SettledEntityMatrix", ValidationResult.ValidationType.CARDINALITY, "SettledEntityMatrix", path, "");
			})
			.collect(toList());
	}

}
