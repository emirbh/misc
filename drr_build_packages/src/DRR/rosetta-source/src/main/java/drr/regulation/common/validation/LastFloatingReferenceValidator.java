package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.LastFloatingReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LastFloatingReferenceValidator implements Validator<LastFloatingReference> {

	private List<ComparisonResult> getComparisonResults(LastFloatingReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lastFloatingReferenceResetDateLeg1", (Date) o.getLastFloatingReferenceResetDateLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceResetDateLeg2", (Date) o.getLastFloatingReferenceResetDateLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceValueLeg1", (BigDecimal) o.getLastFloatingReferenceValueLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceValueLeg2", (BigDecimal) o.getLastFloatingReferenceValueLeg2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LastFloatingReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LastFloatingReference", ValidationResult.ValidationType.CARDINALITY, "LastFloatingReference", path, "", res.getError());
				}
				return success("LastFloatingReference", ValidationResult.ValidationType.CARDINALITY, "LastFloatingReference", path, "");
			})
			.collect(toList());
	}

}
