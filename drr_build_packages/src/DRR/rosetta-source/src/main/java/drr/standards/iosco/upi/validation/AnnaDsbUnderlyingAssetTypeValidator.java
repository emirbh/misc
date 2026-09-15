package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCDSIndex;
import drr.standards.iosco.upi.AnnaDsbCDSSingleName;
import drr.standards.iosco.upi.AnnaDsbIndexTranche;
import drr.standards.iosco.upi.AnnaDsbOther;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import drr.standards.iosco.upi.AnnaDsbSingleStock;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUnderlyingAssetTypeValidator implements Validator<AnnaDsbUnderlyingAssetType> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUnderlyingAssetType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("CDSIndex", (AnnaDsbCDSIndex) o.getCDSIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("SingleName", (AnnaDsbSingleName) o.getSingleName() != null ? 1 : 0, 0, 1), 
				checkCardinality("CDSSingleName", (AnnaDsbCDSSingleName) o.getCDSSingleName() != null ? 1 : 0, 0, 1), 
				checkCardinality("Options", (AnnaDsbSingleStock) o.getOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("Futures", (AnnaDsbSingleStock) o.getFutures() != null ? 1 : 0, 0, 1), 
				checkCardinality("SingleStock", (AnnaDsbSingleStock) o.getSingleStock() != null ? 1 : 0, 0, 1), 
				checkCardinality("Forwards", (AnnaDsbSingleStock) o.getForwards() != null ? 1 : 0, 0, 1), 
				checkCardinality("Swaps", (AnnaDsbCDSSingleName) o.getSwaps() != null ? 1 : 0, 0, 1), 
				checkCardinality("Index", (AnnaDsbCDSIndex) o.getIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("IndexTranche", (AnnaDsbIndexTranche) o.getIndexTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("CDSIndexTranche", (AnnaDsbCDSIndex) o.getCDSIndexTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("Other", (AnnaDsbOther) o.getOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUnderlyingAssetType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlyingAssetType", path, "", res.getError());
				}
				return success("AnnaDsbUnderlyingAssetType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUnderlyingAssetType", path, "");
			})
			.collect(toList());
	}

}
