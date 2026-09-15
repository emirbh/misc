package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AmountAndDirection106__3;
import iso20022.auth030.esma.DatePeriod1;
import iso20022.auth030.esma.DurationType1Code;
import iso20022.auth030.esma.EnergyDeliveryAttribute10__1;
import iso20022.auth030.esma.EnergyQuantityUnit2Choice__1;
import iso20022.auth030.esma.Quantity47Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnergyDeliveryAttribute10__1Validator implements Validator<EnergyDeliveryAttribute10__1> {

	private List<ComparisonResult> getComparisonResults(EnergyDeliveryAttribute10__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dlvryDt", (DatePeriod1) o.getDlvryDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("drtn", (DurationType1Code) o.getDrtn() != null ? 1 : 0, 0, 1), 
				checkCardinality("dlvryCpcty", (Quantity47Choice__1) o.getDlvryCpcty() != null ? 1 : 0, 0, 1), 
				checkCardinality("qtyUnit", (EnergyQuantityUnit2Choice__1) o.getQtyUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricTmIntrvlQty", (AmountAndDirection106__3) o.getPricTmIntrvlQty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnergyDeliveryAttribute10__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnergyDeliveryAttribute10__1", ValidationResult.ValidationType.CARDINALITY, "EnergyDeliveryAttribute10__1", path, "", res.getError());
				}
				return success("EnergyDeliveryAttribute10__1", ValidationResult.ValidationType.CARDINALITY, "EnergyDeliveryAttribute10__1", path, "");
			})
			.collect(toList());
	}

}
