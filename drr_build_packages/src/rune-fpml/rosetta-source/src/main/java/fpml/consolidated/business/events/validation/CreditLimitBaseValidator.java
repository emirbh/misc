package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditLimitBase;
import fpml.consolidated.business.events.LimitId;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Period;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditLimitBaseValidator implements Validator<CreditLimitBase> {

	private List<ComparisonResult> getComparisonResults(CreditLimitBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitId", (LimitId) o.getLimitId() != null ? 1 : 0, 1, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitBase", ValidationResult.ValidationType.CARDINALITY, "CreditLimitBase", path, "", res.getError());
				}
				return success("CreditLimitBase", ValidationResult.ValidationType.CARDINALITY, "CreditLimitBase", path, "");
			})
			.collect(toList());
	}

}
