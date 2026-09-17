package cdm.observable.asset.validation;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
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

public class IndexValidator implements Validator<Index> {

	private List<ComparisonResult> getComparisonResults(Index o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("CreditIndex", (CreditIndex) o.getCreditIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("EquityIndex", (EquityIndex) o.getEquityIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("InterestRateIndex", (FieldWithMetaInterestRateIndex) o.getInterestRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("ForeignExchangeRateIndex", (ForeignExchangeRateIndex) o.getForeignExchangeRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherIndex", (OtherIndex) o.getOtherIndex() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Index o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Index", ValidationResult.ValidationType.CARDINALITY, "Index", path, "", res.getError());
				}
				return success("Index", ValidationResult.ValidationType.CARDINALITY, "Index", path, "");
			})
			.collect(toList());
	}

}
