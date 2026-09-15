package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TechnicalRecordId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TechnicalRecordIdValidator implements Validator<TechnicalRecordId> {

	private List<ComparisonResult> getComparisonResults(TechnicalRecordId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (FieldWithMetaString) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("isUnique", (Boolean) o.getIsUnique() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TechnicalRecordId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TechnicalRecordId", ValidationResult.ValidationType.CARDINALITY, "TechnicalRecordId", path, "", res.getError());
				}
				return success("TechnicalRecordId", ValidationResult.ValidationType.CARDINALITY, "TechnicalRecordId", path, "");
			})
			.collect(toList());
	}

}
