package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ShortSale;
import fpml.consolidated.doc.validation.ShortSaleTypeFormatValidator;
import fpml.consolidated.doc.validation.ShortSaleValidator;
import fpml.consolidated.doc.validation.exists.ShortSaleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ShortSale.class)
public class ShortSaleMeta implements RosettaMetaData<ShortSale> {

	@Override
	public List<Validator<? super ShortSale>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ShortSale, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ShortSale> validator(ValidatorFactory factory) {
		return factory.<ShortSale>create(ShortSaleValidator.class);
	}

	@Override
	public Validator<? super ShortSale> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ShortSale>create(ShortSaleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ShortSale> validator() {
		return new ShortSaleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ShortSale> typeFormatValidator() {
		return new ShortSaleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ShortSale, Set<String>> onlyExistsValidator() {
		return new ShortSaleOnlyExistsValidator();
	}
}
