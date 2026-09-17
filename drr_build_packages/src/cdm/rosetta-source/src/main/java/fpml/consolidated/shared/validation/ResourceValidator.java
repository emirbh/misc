package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Language;
import fpml.consolidated.shared.MimeType;
import fpml.consolidated.shared.Resource;
import fpml.consolidated.shared.ResourceId;
import fpml.consolidated.shared.ResourceLength;
import fpml.consolidated.shared.ResourceType;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResourceValidator implements Validator<Resource> {

	private List<ComparisonResult> getComparisonResults(Resource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resourceId", (ResourceId) o.getResourceId() != null ? 1 : 0, 0, 1), 
				checkCardinality("resourceType", (ResourceType) o.getResourceType() != null ? 1 : 0, 0, 1), 
				checkCardinality("language", (Language) o.getLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("sizeInBytes", (BigDecimal) o.getSizeInBytes() != null ? 1 : 0, 0, 1), 
				checkCardinality("length", (ResourceLength) o.getLength() != null ? 1 : 0, 0, 1), 
				checkCardinality("mimeType", (MimeType) o.getMimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("comments", (String) o.getComments() != null ? 1 : 0, 0, 1), 
				checkCardinality("string", (String) o.getString() != null ? 1 : 0, 0, 1), 
				checkCardinality("hexadecimalBinary", (String) o.getHexadecimalBinary() != null ? 1 : 0, 0, 1), 
				checkCardinality("base64Binary", (String) o.getBase64Binary() != null ? 1 : 0, 0, 1), 
				checkCardinality("url", (String) o.getUrl() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Resource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Resource", ValidationResult.ValidationType.CARDINALITY, "Resource", path, "", res.getError());
				}
				return success("Resource", ValidationResult.ValidationType.CARDINALITY, "Resource", path, "");
			})
			.collect(toList());
	}

}
