package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import drr.standards.iosco.upi.AnnaDsbCredit;
import drr.standards.iosco.upi.AnnaDsbEquity;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import drr.standards.iosco.upi.AnnaDsbRates;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingAssetClassValidator implements Validator<AnnaDsbUnderlyingAssetClass> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlyingAssetClass o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Rates", (AnnaDsbRates) o.getRates() != null ? 1 : 0, 0, 1), 
				checkCardinality("Credit", (AnnaDsbCredit) o.getCredit() != null ? 1 : 0, 0, 1), 
				checkCardinality("Commodities", (AnnaDsbCommodities) o.getCommodities() != null ? 1 : 0, 0, 1), 
				checkCardinality("Equity", (AnnaDsbEquity) o.getEquity() != null ? 1 : 0, 0, 1), 
				checkCardinality("Foreign_Exchange", (AnnaDsbForeign_Exchange) o.getForeign_Exchange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlyingAssetClass o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlyingAssetClass", path, "", res.getError());
				}
				return success("AnnaDsbUnderlyingAssetClass", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlyingAssetClass", path, "");
			})
			.collect(toList());
	}

}
