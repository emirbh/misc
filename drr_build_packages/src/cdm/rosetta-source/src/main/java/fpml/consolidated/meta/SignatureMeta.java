package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.Signature;
import fpml.consolidated.validation.SignatureTypeFormatValidator;
import fpml.consolidated.validation.SignatureValidator;
import fpml.consolidated.validation.exists.SignatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Signature.class)
public class SignatureMeta implements RosettaMetaData<Signature> {

	@Override
	public List<Validator<? super Signature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Signature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Signature> validator(ValidatorFactory factory) {
		return factory.<Signature>create(SignatureValidator.class);
	}

	@Override
	public Validator<? super Signature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Signature>create(SignatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Signature> validator() {
		return new SignatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Signature> typeFormatValidator() {
		return new SignatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Signature, Set<String>> onlyExistsValidator() {
		return new SignatureOnlyExistsValidator();
	}
}
