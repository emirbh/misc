package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.validation.ProductIdTypeFormatValidator;
import fpml.consolidated.shared.validation.ProductIdValidator;
import fpml.consolidated.shared.validation.exists.ProductIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProductId.class)
public class ProductIdMeta implements RosettaMetaData<ProductId> {

	@Override
	public List<Validator<? super ProductId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductId> validator(ValidatorFactory factory) {
		return factory.<ProductId>create(ProductIdValidator.class);
	}

	@Override
	public Validator<? super ProductId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProductId>create(ProductIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProductId> validator() {
		return new ProductIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProductId> typeFormatValidator() {
		return new ProductIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductId, Set<String>> onlyExistsValidator() {
		return new ProductIdOnlyExistsValidator();
	}
}
