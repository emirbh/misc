package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.generic.validation.GenericProductTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericProductValidator;
import fpml.consolidated.generic.validation.datarule.GenericProductChoice;
import fpml.consolidated.generic.validation.exists.GenericProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericProduct.class)
public class GenericProductMeta implements RosettaMetaData<GenericProduct> {

	@Override
	public List<Validator<? super GenericProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GenericProduct>create(GenericProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericProduct> validator(ValidatorFactory factory) {
		return factory.<GenericProduct>create(GenericProductValidator.class);
	}

	@Override
	public Validator<? super GenericProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericProduct>create(GenericProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericProduct> validator() {
		return new GenericProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericProduct> typeFormatValidator() {
		return new GenericProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProduct, Set<String>> onlyExistsValidator() {
		return new GenericProductOnlyExistsValidator();
	}
}
