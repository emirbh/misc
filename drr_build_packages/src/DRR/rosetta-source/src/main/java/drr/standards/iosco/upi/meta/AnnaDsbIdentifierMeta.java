package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.validation.AnnaDsbIdentifierTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbIdentifierValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbIdentifier.class)
public class AnnaDsbIdentifierMeta implements RosettaMetaData<AnnaDsbIdentifier> {

	@Override
	public List<Validator<? super AnnaDsbIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbIdentifier> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbIdentifier>create(AnnaDsbIdentifierValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbIdentifier>create(AnnaDsbIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbIdentifier> validator() {
		return new AnnaDsbIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbIdentifier> typeFormatValidator() {
		return new AnnaDsbIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbIdentifier, Set<String>> onlyExistsValidator() {
		return new AnnaDsbIdentifierOnlyExistsValidator();
	}
}
