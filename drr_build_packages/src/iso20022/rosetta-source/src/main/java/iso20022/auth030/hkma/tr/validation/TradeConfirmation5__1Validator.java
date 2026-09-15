package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.TradeConfirmation5__1;
import iso20022.auth030.hkma.tr.TradeConfirmationType1Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeConfirmation5__1Validator implements Validator<TradeConfirmation5__1> {

	private List<ComparisonResult> getComparisonResults(TradeConfirmation5__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (TradeConfirmationType1Code) o.getTp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation5__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeConfirmation5__1", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation5__1", path, "", res.getError());
				}
				return success("TradeConfirmation5__1", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation5__1", path, "");
			})
			.collect(toList());
	}

}
