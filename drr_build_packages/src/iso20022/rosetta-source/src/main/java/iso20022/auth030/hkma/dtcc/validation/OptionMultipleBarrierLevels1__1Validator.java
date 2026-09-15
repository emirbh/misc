package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice23Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionMultipleBarrierLevels1__1Validator implements Validator<OptionMultipleBarrierLevels1__1> {

	private List<ComparisonResult> getComparisonResults(OptionMultipleBarrierLevels1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lwrLvl", (SecuritiesTransactionPrice23Choice__1) o.getLwrLvl() != null ? 1 : 0, 1, 1), 
				checkCardinality("upperLvl", (SecuritiesTransactionPrice23Choice__1) o.getUpperLvl() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionMultipleBarrierLevels1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.CARDINALITY, "OptionMultipleBarrierLevels1__1", path, "", res.getError());
				}
				return success("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.CARDINALITY, "OptionMultipleBarrierLevels1__1", path, "");
			})
			.collect(toList());
	}

}
