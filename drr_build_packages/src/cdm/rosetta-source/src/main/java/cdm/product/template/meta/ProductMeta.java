package cdm.product.template.meta;

import cdm.product.template.Product;
import cdm.product.template.validation.ProductTypeFormatValidator;
import cdm.product.template.validation.ProductValidator;
import cdm.product.template.validation.datarule.ProductChoice;
import cdm.product.template.validation.exists.ProductOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Product.class)
public class ProductMeta implements RosettaMetaData<Product> {

	@Override
	public List<Validator<? super Product>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Product>create(ProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Product, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Product> validator(ValidatorFactory factory) {
		return factory.<Product>create(ProductValidator.class);
	}

	@Override
	public Validator<? super Product> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Product>create(ProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Product> validator() {
		return new ProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Product> typeFormatValidator() {
		return new ProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Product, Set<String>> onlyExistsValidator() {
		return new ProductOnlyExistsValidator();
	}
}
