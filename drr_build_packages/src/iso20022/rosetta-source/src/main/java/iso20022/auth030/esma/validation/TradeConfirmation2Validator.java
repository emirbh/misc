package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.TradeConfirmation2;
import iso20022.auth030.esma.TradeConfirmationType1Code;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeConfirmation2Validator implements Validator<TradeConfirmation2> {

	private List<ComparisonResult> getComparisonResults(TradeConfirmation2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (TradeConfirmationType1Code) o.getTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("tmStmp", (ZonedDateTime) o.getTmStmp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeConfirmation2", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation2", path, "", res.getError());
				}
				return success("TradeConfirmation2", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation2", path, "");
			})
			.collect(toList());
	}

}
