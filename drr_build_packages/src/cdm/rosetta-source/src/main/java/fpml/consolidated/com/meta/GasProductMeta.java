package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.GasProduct;
import fpml.consolidated.com.validation.GasProductTypeFormatValidator;
import fpml.consolidated.com.validation.GasProductValidator;
import fpml.consolidated.com.validation.datarule.GasProductChoice;
import fpml.consolidated.com.validation.exists.GasProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GasProduct.class)
public class GasProductMeta implements RosettaMetaData<GasProduct> {

	@Override
	public List<Validator<? super GasProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GasProduct>create(GasProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GasProduct> validator(ValidatorFactory factory) {
		return factory.<GasProduct>create(GasProductValidator.class);
	}

	@Override
	public Validator<? super GasProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GasProduct>create(GasProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GasProduct> validator() {
		return new GasProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GasProduct> typeFormatValidator() {
		return new GasProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasProduct, Set<String>> onlyExistsValidator() {
		return new GasProductOnlyExistsValidator();
	}
}
