package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ProductReference;
import fpml.consolidated.shared.validation.ProductReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.ProductReferenceValidator;
import fpml.consolidated.shared.validation.exists.ProductReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProductReference.class)
public class ProductReferenceMeta implements RosettaMetaData<ProductReference> {

	@Override
	public List<Validator<? super ProductReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductReference> validator(ValidatorFactory factory) {
		return factory.<ProductReference>create(ProductReferenceValidator.class);
	}

	@Override
	public Validator<? super ProductReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProductReference>create(ProductReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProductReference> validator() {
		return new ProductReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProductReference> typeFormatValidator() {
		return new ProductReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductReference, Set<String>> onlyExistsValidator() {
		return new ProductReferenceOnlyExistsValidator();
	}
}
