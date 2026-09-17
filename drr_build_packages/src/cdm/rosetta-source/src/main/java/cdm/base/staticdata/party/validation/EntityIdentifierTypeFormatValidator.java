package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.EntityIdentifier;
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

public class EntityIdentifierTypeFormatValidator implements Validator<EntityIdentifier> {

	private List<ComparisonResult> getComparisonResults(EntityIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EntityIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EntityIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "EntityIdentifier", path, "", res.getError());
				}
				return success("EntityIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "EntityIdentifier", path, "");
			})
			.collect(toList());
	}

}
