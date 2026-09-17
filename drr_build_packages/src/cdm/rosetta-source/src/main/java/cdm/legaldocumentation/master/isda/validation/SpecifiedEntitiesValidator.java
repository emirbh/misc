package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.common.SpecifiedEntityClauseEnum;
import cdm.legaldocumentation.master.isda.SpecifiedEntities;
import cdm.legaldocumentation.master.isda.SpecifiedEntity;
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

public class SpecifiedEntitiesValidator implements Validator<SpecifiedEntities> {

	private List<ComparisonResult> getComparisonResults(SpecifiedEntities o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("specifiedEntityClause", (SpecifiedEntityClauseEnum) o.getSpecifiedEntityClause() != null ? 1 : 0, 1, 1), 
				checkCardinality("specifiedEntity", (List<? extends SpecifiedEntity>) o.getSpecifiedEntity() == null ? 0 : o.getSpecifiedEntity().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecifiedEntities o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecifiedEntities", ValidationResult.ValidationType.CARDINALITY, "SpecifiedEntities", path, "", res.getError());
				}
				return success("SpecifiedEntities", ValidationResult.ValidationType.CARDINALITY, "SpecifiedEntities", path, "");
			})
			.collect(toList());
	}

}
