package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.MidMarketValuationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MidMarketValuationValidator implements Validator<MidMarketValuation> {

	private List<ComparisonResult> getComparisonResults(MidMarketValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indicativeQuotations", (MidMarketValuationMethod) o.getIndicativeQuotations() != null ? 1 : 0, 0, 1), 
				checkCardinality("indicativeQuotationsAlternate", (MidMarketValuationMethod) o.getIndicativeQuotationsAlternate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgentDetermination", (MidMarketValuationMethod) o.getCalculationAgentDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MidMarketValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MidMarketValuation", ValidationResult.ValidationType.CARDINALITY, "MidMarketValuation", path, "", res.getError());
				}
				return success("MidMarketValuation", ValidationResult.ValidationType.CARDINALITY, "MidMarketValuation", path, "");
			})
			.collect(toList());
	}

}
