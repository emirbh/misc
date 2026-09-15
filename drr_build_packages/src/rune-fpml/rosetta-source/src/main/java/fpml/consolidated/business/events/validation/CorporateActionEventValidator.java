package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CorporateActionEvent;
import fpml.consolidated.business.events.CorporateActionType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CorporateActionEventValidator implements Validator<CorporateActionEvent> {

	private List<ComparisonResult> getComparisonResults(CorporateActionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CorporateActionType) o._getType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorporateActionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorporateActionEvent", ValidationResult.ValidationType.CARDINALITY, "CorporateActionEvent", path, "", res.getError());
				}
				return success("CorporateActionEvent", ValidationResult.ValidationType.CARDINALITY, "CorporateActionEvent", path, "");
			})
			.collect(toList());
	}

}
