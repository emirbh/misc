package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.MarginTypeEnum;
import fpml.consolidated.repo.InitialMargin;
import fpml.consolidated.repo.InitialMarginCalculation;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InitialMarginValidator implements Validator<InitialMargin> {

	private List<ComparisonResult> getComparisonResults(InitialMargin o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("marginType", (MarginTypeEnum) o.getMarginType() != null ? 1 : 0, 1, 1), 
				checkCardinality("margin", (List<? extends InitialMarginCalculation>) o.getMargin() == null ? 0 : o.getMargin().size(), 1, 0), 
				checkCardinality("marginThreshold", (NonNegativeMoney) o.getMarginThreshold() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumTransferAmount", (NonNegativeMoney) o.getMinimumTransferAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialMargin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InitialMargin", ValidationResult.ValidationType.CARDINALITY, "InitialMargin", path, "", res.getError());
				}
				return success("InitialMargin", ValidationResult.ValidationType.CARDINALITY, "InitialMargin", path, "");
			})
			.collect(toList());
	}

}
