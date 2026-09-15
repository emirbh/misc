package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.TradeReport31Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport31ChoiceValidator implements Validator<TradeReport31Choice> {

	private List<ComparisonResult> getComparisonResults(TradeReport31Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("new", (MarginReportData7) o.getNew() != null ? 1 : 0, 0, 1), 
				checkCardinality("mrgnUpd", (MarginReportData7) o.getMrgnUpd() != null ? 1 : 0, 0, 1), 
				checkCardinality("err", (MarginReportData7) o.getErr() != null ? 1 : 0, 0, 1), 
				checkCardinality("crrctn", (MarginReportData7) o.getCrrctn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport31Choice", ValidationResult.ValidationType.CARDINALITY, "TradeReport31Choice", path, "", res.getError());
				}
				return success("TradeReport31Choice", ValidationResult.ValidationType.CARDINALITY, "TradeReport31Choice", path, "");
			})
			.collect(toList());
	}

}
