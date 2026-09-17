package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ExcludedProducts;
import cdm.legaldocumentation.csa.validation.ExcludedProductsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ExcludedProductsValidator;
import cdm.legaldocumentation.csa.validation.exists.ExcludedProductsOnlyExistsValidator;
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
@RosettaMeta(model=ExcludedProducts.class)
public class ExcludedProductsMeta implements RosettaMetaData<ExcludedProducts> {

	@Override
	public List<Validator<? super ExcludedProducts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExcludedProducts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExcludedProducts> validator(ValidatorFactory factory) {
		return factory.<ExcludedProducts>create(ExcludedProductsValidator.class);
	}

	@Override
	public Validator<? super ExcludedProducts> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExcludedProducts>create(ExcludedProductsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExcludedProducts> validator() {
		return new ExcludedProductsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExcludedProducts> typeFormatValidator() {
		return new ExcludedProductsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExcludedProducts, Set<String>> onlyExistsValidator() {
		return new ExcludedProductsOnlyExistsValidator();
	}
}
