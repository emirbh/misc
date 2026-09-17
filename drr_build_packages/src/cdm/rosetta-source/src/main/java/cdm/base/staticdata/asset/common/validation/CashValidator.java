package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.party.LegalEntity;
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

public class CashValidator implements Validator<Cash> {

	private List<ComparisonResult> getComparisonResults(Cash o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends AssetIdentifier>) o.getIdentifier() == null ? 0 : o.getIdentifier().size(), 1, 0), 
				checkCardinality("isExchangeListed", (Boolean) o.getIsExchangeListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchange", (LegalEntity) o.getExchange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cash", ValidationResult.ValidationType.CARDINALITY, "Cash", path, "", res.getError());
				}
				return success("Cash", ValidationResult.ValidationType.CARDINALITY, "Cash", path, "");
			})
			.collect(toList());
	}

}
