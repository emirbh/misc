package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.X509IssuerSerialType;
import fpml.consolidated.validation.X509IssuerSerialTypeTypeFormatValidator;
import fpml.consolidated.validation.X509IssuerSerialTypeValidator;
import fpml.consolidated.validation.exists.X509IssuerSerialTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=X509IssuerSerialType.class)
public class X509IssuerSerialTypeMeta implements RosettaMetaData<X509IssuerSerialType> {

	@Override
	public List<Validator<? super X509IssuerSerialType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super X509IssuerSerialType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super X509IssuerSerialType> validator(ValidatorFactory factory) {
		return factory.<X509IssuerSerialType>create(X509IssuerSerialTypeValidator.class);
	}

	@Override
	public Validator<? super X509IssuerSerialType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<X509IssuerSerialType>create(X509IssuerSerialTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super X509IssuerSerialType> validator() {
		return new X509IssuerSerialTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super X509IssuerSerialType> typeFormatValidator() {
		return new X509IssuerSerialTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509IssuerSerialType, Set<String>> onlyExistsValidator() {
		return new X509IssuerSerialTypeOnlyExistsValidator();
	}
}
