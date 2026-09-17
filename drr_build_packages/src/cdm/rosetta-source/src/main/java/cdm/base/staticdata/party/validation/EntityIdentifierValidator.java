package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EntityIdentifierValidator implements Validator<EntityIdentifier> {

	private List<ComparisonResult> getComparisonResults(EntityIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (FieldWithMetaString) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("identifierType", (EntityIdentifierTypeEnum) o.getIdentifierType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EntityIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EntityIdentifier", ValidationResult.ValidationType.CARDINALITY, "EntityIdentifier", path, "", res.getError());
				}
				return success("EntityIdentifier", ValidationResult.ValidationType.CARDINALITY, "EntityIdentifier", path, "");
			})
			.collect(toList());
	}

}
