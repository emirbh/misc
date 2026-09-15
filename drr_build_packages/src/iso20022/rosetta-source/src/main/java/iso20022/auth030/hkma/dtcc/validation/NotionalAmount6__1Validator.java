package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__3;
import iso20022.auth030.hkma.dtcc.NotionalAmount6__1;
import iso20022.auth030.hkma.dtcc.Schedule11__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalAmount6__1Validator implements Validator<NotionalAmount6__1> {

	private List<ComparisonResult> getComparisonResults(NotionalAmount6__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amt", (AmountAndDirection106__3) o.getAmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("schdlPrd", (List<? extends Schedule11__1>) o.getSchdlPrd() == null ? 0 : o.getSchdlPrd().size(), 0, 600)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalAmount6__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalAmount6__1", ValidationResult.ValidationType.CARDINALITY, "NotionalAmount6__1", path, "", res.getError());
				}
				return success("NotionalAmount6__1", ValidationResult.ValidationType.CARDINALITY, "NotionalAmount6__1", path, "");
			})
			.collect(toList());
	}

}
