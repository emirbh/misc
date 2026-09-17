package fpml.consolidated.fpmlstandard.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlstandard.StandardProduct;
import fpml.consolidated.fpmlstandard.validation.StandardProductTypeFormatValidator;
import fpml.consolidated.fpmlstandard.validation.StandardProductValidator;
import fpml.consolidated.fpmlstandard.validation.exists.StandardProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StandardProduct.class)
public class StandardProductMeta implements RosettaMetaData<StandardProduct> {

	@Override
	public List<Validator<? super StandardProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StandardProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StandardProduct> validator(ValidatorFactory factory) {
		return factory.<StandardProduct>create(StandardProductValidator.class);
	}

	@Override
	public Validator<? super StandardProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StandardProduct>create(StandardProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StandardProduct> validator() {
		return new StandardProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StandardProduct> typeFormatValidator() {
		return new StandardProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StandardProduct, Set<String>> onlyExistsValidator() {
		return new StandardProductOnlyExistsValidator();
	}
}
