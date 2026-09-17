package cdm.event.common.validation;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.CollateralBalance;
import cdm.event.common.CollateralStatusEnum;
import cdm.event.common.HaircutIndicatorEnum;
import cdm.observable.asset.Money;
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

public class CollateralBalanceValidator implements Validator<CollateralBalance> {

	private List<ComparisonResult> getComparisonResults(CollateralBalance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralBalanceStatus", (CollateralStatusEnum) o.getCollateralBalanceStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("haircutIndicator", (HaircutIndicatorEnum) o.getHaircutIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountBaseCurrency", (Money) o.getAmountBaseCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerReceiver", (PartyReferencePayerReceiver) o.getPayerReceiver() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralBalance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralBalance", ValidationResult.ValidationType.CARDINALITY, "CollateralBalance", path, "", res.getError());
				}
				return success("CollateralBalance", ValidationResult.ValidationType.CARDINALITY, "CollateralBalance", path, "");
			})
			.collect(toList());
	}

}
