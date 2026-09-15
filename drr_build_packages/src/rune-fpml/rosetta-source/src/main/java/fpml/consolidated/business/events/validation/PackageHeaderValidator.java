package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.PackageHeader;
import fpml.consolidated.doc.OrderIdentifier;
import fpml.consolidated.doc.PackageInformation;
import fpml.consolidated.shared.IssuerTradeId;
import fpml.consolidated.shared.OriginatingEvent;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PackageHeaderValidator implements Validator<PackageHeader> {

	private List<ComparisonResult> getComparisonResults(PackageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("packageIdentifier", (IssuerTradeId) o.getPackageIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("orderIdentifier", (OrderIdentifier) o.getOrderIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("size", (BigDecimal) o.getSize() != null ? 1 : 0, 0, 1), 
				checkCardinality("originatingEvent", (OriginatingEvent) o.getOriginatingEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageInformation", (PackageInformation) o.getPackageInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PackageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PackageHeader", ValidationResult.ValidationType.CARDINALITY, "PackageHeader", path, "", res.getError());
				}
				return success("PackageHeader", ValidationResult.ValidationType.CARDINALITY, "PackageHeader", path, "");
			})
			.collect(toList());
	}

}
