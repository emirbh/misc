package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.Cleared23Choice__1;
import iso20022.auth030.fca.ClearingObligationType1Code;
import iso20022.auth030.fca.TradeClearing11__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeClearing11__1Validator implements Validator<TradeClearing11__1> {

	private List<ComparisonResult> getComparisonResults(TradeClearing11__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("clrOblgtn", (ClearingObligationType1Code) o.getClrOblgtn() != null ? 1 : 0, 0, 1), 
				checkCardinality("clrSts", (Cleared23Choice__1) o.getClrSts() != null ? 1 : 0, 1, 1), 
				checkCardinality("intraGrp", (Boolean) o.getIntraGrp() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeClearing11__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeClearing11__1", ValidationResult.ValidationType.CARDINALITY, "TradeClearing11__1", path, "", res.getError());
				}
				return success("TradeClearing11__1", ValidationResult.ValidationType.CARDINALITY, "TradeClearing11__1", path, "");
			})
			.collect(toList());
	}

}
