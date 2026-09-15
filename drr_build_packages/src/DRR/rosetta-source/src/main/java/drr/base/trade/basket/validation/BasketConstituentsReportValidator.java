package drr.base.trade.basket.validation;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.basket.BasketConstituentsReport;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BasketConstituentsReportValidator implements Validator<BasketConstituentsReport> {

	private List<ComparisonResult> getComparisonResults(BasketConstituentsReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (String) o.getIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("source", (AssetIdTypeEnum) o.getSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfUnits", (BigDecimal) o.getNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("unitOfMeasure", (String) o.getUnitOfMeasure() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituentsReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketConstituentsReport", ValidationResult.ValidationType.CARDINALITY, "BasketConstituentsReport", path, "", res.getError());
				}
				return success("BasketConstituentsReport", ValidationResult.ValidationType.CARDINALITY, "BasketConstituentsReport", path, "");
			})
			.collect(toList());
	}

}
