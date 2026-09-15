package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAsianFeatureValidator implements Validator<FxAsianFeature> {

	private List<ComparisonResult> getComparisonResults(FxAsianFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryRateSource", (InformationSource) o.getPrimaryRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("secondaryRateSource", (InformationSource) o.getSecondaryRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationSchedule", (FxAverageRateObservationSchedule) o.getObservationSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateObservationQuoteBasis", (StrikeQuoteBasisEnum) o.getRateObservationQuoteBasis() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoutFormula", (String) o.getPayoutFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("precision", (Integer) o.getPrecision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAsianFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAsianFeature", ValidationResult.ValidationType.CARDINALITY, "FxAsianFeature", path, "", res.getError());
				}
				return success("FxAsianFeature", ValidationResult.ValidationType.CARDINALITY, "FxAsianFeature", path, "");
			})
			.collect(toList());
	}

}
