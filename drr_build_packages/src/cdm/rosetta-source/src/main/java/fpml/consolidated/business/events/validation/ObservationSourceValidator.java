package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ObservationSource;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.InformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationSourceValidator implements Validator<ObservationSource> {

	private List<ComparisonResult> getComparisonResults(ObservationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (TradeUnderlyer2) o.getUnderlyer() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationSource", ValidationResult.ValidationType.CARDINALITY, "ObservationSource", path, "", res.getError());
				}
				return success("ObservationSource", ValidationResult.ValidationType.CARDINALITY, "ObservationSource", path, "");
			})
			.collect(toList());
	}

}
