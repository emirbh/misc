package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.MTAFixedAmount;
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

public class MTAFixedAmountValidator implements Validator<MTAFixedAmount> {

	private List<ComparisonResult> getComparisonResults(MTAFixedAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Integer) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MTAFixedAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MTAFixedAmount", ValidationResult.ValidationType.CARDINALITY, "MTAFixedAmount", path, "", res.getError());
				}
				return success("MTAFixedAmount", ValidationResult.ValidationType.CARDINALITY, "MTAFixedAmount", path, "");
			})
			.collect(toList());
	}

}
