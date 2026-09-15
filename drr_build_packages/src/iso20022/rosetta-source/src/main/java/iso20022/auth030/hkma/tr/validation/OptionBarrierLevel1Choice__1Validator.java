package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.OptionBarrierLevel1Choice__1;
import iso20022.auth030.hkma.tr.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice23Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionBarrierLevel1Choice__1Validator implements Validator<OptionBarrierLevel1Choice__1> {

	private List<ComparisonResult> getComparisonResults(OptionBarrierLevel1Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sngl", (SecuritiesTransactionPrice23Choice__1) o.getSngl() != null ? 1 : 0, 0, 1), 
				checkCardinality("mltpl", (OptionMultipleBarrierLevels1__1) o.getMltpl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBarrierLevel1Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBarrierLevel1Choice__1", ValidationResult.ValidationType.CARDINALITY, "OptionBarrierLevel1Choice__1", path, "", res.getError());
				}
				return success("OptionBarrierLevel1Choice__1", ValidationResult.ValidationType.CARDINALITY, "OptionBarrierLevel1Choice__1", path, "");
			})
			.collect(toList());
	}

}
