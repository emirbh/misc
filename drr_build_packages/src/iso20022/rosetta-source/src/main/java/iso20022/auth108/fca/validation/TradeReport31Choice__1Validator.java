package iso20022.auth108.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.MarginReportData7__2;
import iso20022.auth108.fca.TradeReport31Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport31Choice__1Validator implements Validator<TradeReport31Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeReport31Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mrgnUpd", (MarginReportData7__1) o.getMrgnUpd() != null ? 1 : 0, 0, 1), 
				checkCardinality("crrctn", (MarginReportData7__2) o.getCrrctn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport31Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport31Choice__1", path, "", res.getError());
				}
				return success("TradeReport31Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport31Choice__1", path, "");
			})
			.collect(toList());
	}

}
