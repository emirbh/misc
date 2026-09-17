package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.PricingDataPointCoordinateChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingDataPointCoordinateValidator implements Validator<PricingDataPointCoordinate> {

	private List<ComparisonResult> getComparisonResults(PricingDataPointCoordinate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDataPointCoordinateChoice", (List<? extends PricingDataPointCoordinateChoice>) o.getPricingDataPointCoordinateChoice() == null ? 0 : o.getPricingDataPointCoordinateChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDataPointCoordinate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingDataPointCoordinate", ValidationResult.ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "", res.getError());
				}
				return success("PricingDataPointCoordinate", ValidationResult.ValidationType.CARDINALITY, "PricingDataPointCoordinate", path, "");
			})
			.collect(toList());
	}

}
