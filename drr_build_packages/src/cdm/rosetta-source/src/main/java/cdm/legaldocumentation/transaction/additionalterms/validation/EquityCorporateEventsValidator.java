package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EquityCorporateEvents;
import cdm.observable.event.ShareExtraordinaryEventEnum;
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

public class EquityCorporateEventsValidator implements Validator<EquityCorporateEvents> {

	private List<ComparisonResult> getComparisonResults(EquityCorporateEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("shareForShare", (ShareExtraordinaryEventEnum) o.getShareForShare() != null ? 1 : 0, 1, 1), 
				checkCardinality("shareForOther", (ShareExtraordinaryEventEnum) o.getShareForOther() != null ? 1 : 0, 1, 1), 
				checkCardinality("shareForCombined", (ShareExtraordinaryEventEnum) o.getShareForCombined() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityCorporateEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityCorporateEvents", ValidationResult.ValidationType.CARDINALITY, "EquityCorporateEvents", path, "", res.getError());
				}
				return success("EquityCorporateEvents", ValidationResult.ValidationType.CARDINALITY, "EquityCorporateEvents", path, "");
			})
			.collect(toList());
	}

}
