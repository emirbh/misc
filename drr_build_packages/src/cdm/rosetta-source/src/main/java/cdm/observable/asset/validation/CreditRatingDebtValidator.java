package cdm.observable.asset.validation;

import cdm.observable.asset.CreditRatingDebt;
import cdm.observable.asset.MultipleDebtTypes;
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

public class CreditRatingDebtValidator implements Validator<CreditRatingDebt> {

	private List<ComparisonResult> getComparisonResults(CreditRatingDebt o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("debtType", (FieldWithMetaString) o.getDebtType() != null ? 1 : 0, 0, 1), 
				checkCardinality("debtTypes", (MultipleDebtTypes) o.getDebtTypes() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditRatingDebt o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditRatingDebt", ValidationResult.ValidationType.CARDINALITY, "CreditRatingDebt", path, "", res.getError());
				}
				return success("CreditRatingDebt", ValidationResult.ValidationType.CARDINALITY, "CreditRatingDebt", path, "");
			})
			.collect(toList());
	}

}
