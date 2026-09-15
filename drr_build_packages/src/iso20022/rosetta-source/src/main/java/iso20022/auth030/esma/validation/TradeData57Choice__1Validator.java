package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.TradeData57Choice__1;
import iso20022.auth030.esma.TradeReport32Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData57Choice__1Validator implements Validator<TradeData57Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeData57Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rpt", (List<? extends TradeReport32Choice__1>) o.getRpt() == null ? 0 : o.getRpt().size(), 1, 100000)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData57Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData57Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeData57Choice__1", path, "", res.getError());
				}
				return success("TradeData57Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeData57Choice__1", path, "");
			})
			.collect(toList());
	}

}
