package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EnvironmentalProduct;
import fpml.consolidated.com.validation.EnvironmentalProductTypeFormatValidator;
import fpml.consolidated.com.validation.EnvironmentalProductValidator;
import fpml.consolidated.com.validation.exists.EnvironmentalProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EnvironmentalProduct.class)
public class EnvironmentalProductMeta implements RosettaMetaData<EnvironmentalProduct> {

	@Override
	public List<Validator<? super EnvironmentalProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalProduct> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalProduct>create(EnvironmentalProductValidator.class);
	}

	@Override
	public Validator<? super EnvironmentalProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalProduct>create(EnvironmentalProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProduct> validator() {
		return new EnvironmentalProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProduct> typeFormatValidator() {
		return new EnvironmentalProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProduct, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductOnlyExistsValidator();
	}
}
