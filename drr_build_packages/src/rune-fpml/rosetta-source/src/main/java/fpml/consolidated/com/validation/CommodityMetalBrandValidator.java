package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMetalBrand;
import fpml.consolidated.com.CommodityMetalBrandManager;
import fpml.consolidated.com.CommodityMetalBrandName;
import fpml.consolidated.com.CommodityMetalProducer;
import fpml.consolidated.shared.CountryCode;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityMetalBrandValidator implements Validator<CommodityMetalBrand> {

	private List<ComparisonResult> getComparisonResults(CommodityMetalBrand o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (CommodityMetalBrandName) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("brandManager", (CommodityMetalBrandManager) o.getBrandManager() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1), 
				checkCardinality("producer", (CommodityMetalProducer) o.getProducer() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityMetalBrand o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityMetalBrand", ValidationResult.ValidationType.CARDINALITY, "CommodityMetalBrand", path, "", res.getError());
				}
				return success("CommodityMetalBrand", ValidationResult.ValidationType.CARDINALITY, "CommodityMetalBrand", path, "");
			})
			.collect(toList());
	}

}
