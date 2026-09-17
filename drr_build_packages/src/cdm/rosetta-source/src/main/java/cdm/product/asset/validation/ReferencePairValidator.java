package cdm.product.asset.validation;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.metafields.FieldWithMetaEntityTypeEnum;
import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferencePair;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferencePairValidator implements Validator<ReferencePair> {

	private List<ComparisonResult> getComparisonResults(ReferencePair o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceObligation", (ReferenceObligation) o.getReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("noReferenceObligation", (Boolean) o.getNoReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityType", (FieldWithMetaEntityTypeEnum) o.getEntityType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePair", ValidationResult.ValidationType.CARDINALITY, "ReferencePair", path, "", res.getError());
				}
				return success("ReferencePair", ValidationResult.ValidationType.CARDINALITY, "ReferencePair", path, "");
			})
			.collect(toList());
	}

}
