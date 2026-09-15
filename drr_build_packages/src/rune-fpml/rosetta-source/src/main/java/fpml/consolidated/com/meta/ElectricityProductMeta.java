package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityProduct;
import fpml.consolidated.com.validation.ElectricityProductTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityProductValidator;
import fpml.consolidated.com.validation.exists.ElectricityProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityProduct.class)
public class ElectricityProductMeta implements RosettaMetaData<ElectricityProduct> {

	@Override
	public List<Validator<? super ElectricityProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityProduct> validator(ValidatorFactory factory) {
		return factory.<ElectricityProduct>create(ElectricityProductValidator.class);
	}

	@Override
	public Validator<? super ElectricityProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityProduct>create(ElectricityProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityProduct> validator() {
		return new ElectricityProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityProduct> typeFormatValidator() {
		return new ElectricityProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityProduct, Set<String>> onlyExistsValidator() {
		return new ElectricityProductOnlyExistsValidator();
	}
}
