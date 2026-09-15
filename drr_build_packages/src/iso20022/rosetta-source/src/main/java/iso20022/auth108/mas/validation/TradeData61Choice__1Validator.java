package iso20022.auth108.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.mas.ReportPeriodActivity1Code;
import iso20022.auth108.mas.TradeData61Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData61Choice__1Validator implements Validator<TradeData61Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeData61Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dataSetActn", (ReportPeriodActivity1Code) o.getDataSetActn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData61Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData61Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeData61Choice__1", path, "", res.getError());
				}
				return success("TradeData61Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeData61Choice__1", path, "");
			})
			.collect(toList());
	}

}
