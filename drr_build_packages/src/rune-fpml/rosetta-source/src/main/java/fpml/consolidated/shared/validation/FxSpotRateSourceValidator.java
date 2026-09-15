package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.InformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxSpotRateSourceValidator implements Validator<FxSpotRateSource> {

	private List<ComparisonResult> getComparisonResults(FxSpotRateSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryRateSource", (InformationSource) o.getPrimaryRateSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("secondaryRateSource", (InformationSource) o.getSecondaryRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSpotRateSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSpotRateSource", ValidationResult.ValidationType.CARDINALITY, "FxSpotRateSource", path, "", res.getError());
				}
				return success("FxSpotRateSource", ValidationResult.ValidationType.CARDINALITY, "FxSpotRateSource", path, "");
			})
			.collect(toList());
	}

}
