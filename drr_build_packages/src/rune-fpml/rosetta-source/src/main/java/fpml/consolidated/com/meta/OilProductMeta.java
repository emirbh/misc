package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.OilProduct;
import fpml.consolidated.com.validation.OilProductTypeFormatValidator;
import fpml.consolidated.com.validation.OilProductValidator;
import fpml.consolidated.com.validation.exists.OilProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OilProduct.class)
public class OilProductMeta implements RosettaMetaData<OilProduct> {

	@Override
	public List<Validator<? super OilProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OilProduct> validator(ValidatorFactory factory) {
		return factory.<OilProduct>create(OilProductValidator.class);
	}

	@Override
	public Validator<? super OilProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OilProduct>create(OilProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OilProduct> validator() {
		return new OilProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OilProduct> typeFormatValidator() {
		return new OilProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilProduct, Set<String>> onlyExistsValidator() {
		return new OilProductOnlyExistsValidator();
	}
}
