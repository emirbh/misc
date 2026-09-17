package cdm.product.asset.floatingrate.validation;

import cdm.observable.asset.calculatedrate.CalculatedRateDetails;
import cdm.product.asset.floatingrate.FloatingRateSettingDetails;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRateSettingDetailsValidator implements Validator<FloatingRateSettingDetails> {

	private List<ComparisonResult> getComparisonResults(FloatingRateSettingDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDetails", (CalculatedRateDetails) o.getCalculationDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationDate", (Date) o.getObservationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetDate", (Date) o.getResetDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRate", (BigDecimal) o.getFloatingRate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateSettingDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateSettingDetails", ValidationResult.ValidationType.CARDINALITY, "FloatingRateSettingDetails", path, "", res.getError());
				}
				return success("FloatingRateSettingDetails", ValidationResult.ValidationType.CARDINALITY, "FloatingRateSettingDetails", path, "");
			})
			.collect(toList());
	}

}
