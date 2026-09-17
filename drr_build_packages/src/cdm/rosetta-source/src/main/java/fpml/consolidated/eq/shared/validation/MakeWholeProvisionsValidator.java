package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.MakeWholeProvisions;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MakeWholeProvisionsValidator implements Validator<MakeWholeProvisions> {

	private List<ComparisonResult> getComparisonResults(MakeWholeProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("makeWholeDate", (ZonedDateTime) o.getMakeWholeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("recallSpread", (BigDecimal) o.getRecallSpread() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MakeWholeProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MakeWholeProvisions", ValidationResult.ValidationType.CARDINALITY, "MakeWholeProvisions", path, "", res.getError());
				}
				return success("MakeWholeProvisions", ValidationResult.ValidationType.CARDINALITY, "MakeWholeProvisions", path, "");
			})
			.collect(toList());
	}

}
