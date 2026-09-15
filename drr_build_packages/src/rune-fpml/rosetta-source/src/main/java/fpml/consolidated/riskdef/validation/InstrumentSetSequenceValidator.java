package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.riskdef.InstrumentSetSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InstrumentSetSequenceValidator implements Validator<InstrumentSetSequence> {

	private List<ComparisonResult> getComparisonResults(InstrumentSetSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("curveInstrument", (Asset) o.getCurveInstrument() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentSetSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentSetSequence", ValidationResult.ValidationType.CARDINALITY, "InstrumentSetSequence", path, "", res.getError());
				}
				return success("InstrumentSetSequence", ValidationResult.ValidationType.CARDINALITY, "InstrumentSetSequence", path, "");
			})
			.collect(toList());
	}

}
