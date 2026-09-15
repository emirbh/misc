package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.DeliveryInterconnectionPoint1Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DeliveryInterconnectionPoint1Choice__1Validator implements Validator<DeliveryInterconnectionPoint1Choice__1> {

	private List<ComparisonResult> getComparisonResults(DeliveryInterconnectionPoint1Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cd", (String) o.getCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("prtry", (String) o.getPrtry() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryInterconnectionPoint1Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryInterconnectionPoint1Choice__1", ValidationResult.ValidationType.CARDINALITY, "DeliveryInterconnectionPoint1Choice__1", path, "", res.getError());
				}
				return success("DeliveryInterconnectionPoint1Choice__1", ValidationResult.ValidationType.CARDINALITY, "DeliveryInterconnectionPoint1Choice__1", path, "");
			})
			.collect(toList());
	}

}
