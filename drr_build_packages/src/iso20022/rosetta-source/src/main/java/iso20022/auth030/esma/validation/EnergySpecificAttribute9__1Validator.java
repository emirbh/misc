package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.DeliveryInterconnectionPoint1Choice__1;
import iso20022.auth030.esma.EnergyLoadType1Code;
import iso20022.auth030.esma.EnergySpecificAttribute9__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergySpecificAttribute9__1Validator implements Validator<EnergySpecificAttribute9__1> {

	private List<ComparisonResult> getComparisonResults(EnergySpecificAttribute9__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("intrCnnctnPt", (DeliveryInterconnectionPoint1Choice__1) o.getIntrCnnctnPt() != null ? 1 : 0, 0, 1), 
				checkCardinality("ldTp", (EnergyLoadType1Code) o.getLdTp() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergySpecificAttribute9__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergySpecificAttribute9__1", ValidationResult.ValidationType.CARDINALITY, "EnergySpecificAttribute9__1", path, "", res.getError());
				}
				return success("EnergySpecificAttribute9__1", ValidationResult.ValidationType.CARDINALITY, "EnergySpecificAttribute9__1", path, "");
			})
			.collect(toList());
	}

}
