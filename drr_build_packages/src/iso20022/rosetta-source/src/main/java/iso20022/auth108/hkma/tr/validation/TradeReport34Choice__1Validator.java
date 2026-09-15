package iso20022.auth108.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.tr.MarginReportData9__1;
import iso20022.auth108.hkma.tr.TradeReport34Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport34Choice__1Validator implements Validator<TradeReport34Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeReport34Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mrgnUpd", (MarginReportData9__1) o.getMrgnUpd() != null ? 1 : 0, 0, 1), 
				checkCardinality("crrctn", (MarginReportData9__1) o.getCrrctn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport34Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport34Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport34Choice__1", path, "", res.getError());
				}
				return success("TradeReport34Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport34Choice__1", path, "");
			})
			.collect(toList());
	}

}
