package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbPlaceofSettlementEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbForeign_ExchangeValidator implements Validator<AnnaDsbForeign_Exchange> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbForeign_Exchange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("UnderlierIDSource", (AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("PlaceofSettlement", (AnnaDsbPlaceofSettlementEnum) o.getPlaceofSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierIDSource", (AnnaDsbOtherUnderlierIDSourceEnum) o.getOtherUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierID", (String) o.getOtherUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierID", (String) o.getUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("SettlementCurrency", (String) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalCurrency", (String) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherNotionalCurrency", (String) o.getOtherNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierName", (String) o.getUnderlierName() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbForeign_Exchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbForeign_Exchange", path, "", res.getError());
				}
				return success("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbForeign_Exchange", path, "");
			})
			.collect(toList());
	}

}
