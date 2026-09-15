package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCFIOptionStyleandTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbRateDetail;
import drr.standards.iosco.upi.AnnaDsbSingleorMultiCurrencyEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbRateDetailValidator implements Validator<AnnaDsbRateDetail> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbRateDetail o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("UnderlyingAssetType", (AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("OptionStyleandType", (AnnaDsbCFIOptionStyleandTypeEnum) o.getOptionStyleandType() != null ? 1 : 0, 0, 1), 
				checkCardinality("ValuationMethodorTrigger", (AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("DeliveryType", (AnnaDsbDeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalSchedule", (AnnaDsbNotionalScheduleEnum) o.getNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("SingleorMultiCurrency", (AnnaDsbSingleorMultiCurrencyEnum) o.getSingleorMultiCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbRateDetail o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbRateDetail", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbRateDetail", path, "", res.getError());
				}
				return success("AnnaDsbRateDetail", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbRateDetail", path, "");
			})
			.collect(toList());
	}

}
