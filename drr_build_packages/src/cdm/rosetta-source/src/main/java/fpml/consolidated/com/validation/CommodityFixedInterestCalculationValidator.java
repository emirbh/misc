package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedInterestCalculation;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.IdentifiedRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityFixedInterestCalculationValidator implements Validator<CommodityFixedInterestCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedInterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRate", (IdentifiedRate) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedInterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedInterestCalculation", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedInterestCalculation", path, "", res.getError());
				}
				return success("CommodityFixedInterestCalculation", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedInterestCalculation", path, "");
			})
			.collect(toList());
	}

}
