package cdm.regulation.validation;

import cdm.regulation.FinInstrmRptgTxRpt;
import cdm.regulation.Tx;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinInstrmRptgTxRptValidator implements Validator<FinInstrmRptgTxRpt> {

	private List<ComparisonResult> getComparisonResults(FinInstrmRptgTxRpt o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tx", (Tx) o.getTx() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinInstrmRptgTxRpt o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinInstrmRptgTxRpt", ValidationResult.ValidationType.CARDINALITY, "FinInstrmRptgTxRpt", path, "", res.getError());
				}
				return success("FinInstrmRptgTxRpt", ValidationResult.ValidationType.CARDINALITY, "FinInstrmRptgTxRpt", path, "");
			})
			.collect(toList());
	}

}
