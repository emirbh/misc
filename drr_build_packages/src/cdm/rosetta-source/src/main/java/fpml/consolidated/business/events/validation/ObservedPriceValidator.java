package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ObservedPrice;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.NonNegativeMoney;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservedPriceValidator implements Validator<ObservedPrice> {

	private List<ComparisonResult> getComparisonResults(ObservedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", (NonNegativeMoney) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (LocalTime) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservedPrice", ValidationResult.ValidationType.CARDINALITY, "ObservedPrice", path, "", res.getError());
				}
				return success("ObservedPrice", ValidationResult.ValidationType.CARDINALITY, "ObservedPrice", path, "");
			})
			.collect(toList());
	}

}
