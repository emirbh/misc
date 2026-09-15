package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.X509Data;
import fpml.consolidated.validation.X509DataTypeFormatValidator;
import fpml.consolidated.validation.X509DataValidator;
import fpml.consolidated.validation.exists.X509DataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=X509Data.class)
public class X509DataMeta implements RosettaMetaData<X509Data> {

	@Override
	public List<Validator<? super X509Data>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super X509Data, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super X509Data> validator(ValidatorFactory factory) {
		return factory.<X509Data>create(X509DataValidator.class);
	}

	@Override
	public Validator<? super X509Data> typeFormatValidator(ValidatorFactory factory) {
		return factory.<X509Data>create(X509DataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super X509Data> validator() {
		return new X509DataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super X509Data> typeFormatValidator() {
		return new X509DataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509Data, Set<String>> onlyExistsValidator() {
		return new X509DataOnlyExistsValidator();
	}
}
