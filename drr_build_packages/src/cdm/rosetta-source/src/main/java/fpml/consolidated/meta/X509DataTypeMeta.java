package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.X509DataType;
import fpml.consolidated.validation.X509DataTypeTypeFormatValidator;
import fpml.consolidated.validation.X509DataTypeValidator;
import fpml.consolidated.validation.exists.X509DataTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=X509DataType.class)
public class X509DataTypeMeta implements RosettaMetaData<X509DataType> {

	@Override
	public List<Validator<? super X509DataType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super X509DataType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super X509DataType> validator(ValidatorFactory factory) {
		return factory.<X509DataType>create(X509DataTypeValidator.class);
	}

	@Override
	public Validator<? super X509DataType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<X509DataType>create(X509DataTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super X509DataType> validator() {
		return new X509DataTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super X509DataType> typeFormatValidator() {
		return new X509DataTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509DataType, Set<String>> onlyExistsValidator() {
		return new X509DataTypeOnlyExistsValidator();
	}
}
