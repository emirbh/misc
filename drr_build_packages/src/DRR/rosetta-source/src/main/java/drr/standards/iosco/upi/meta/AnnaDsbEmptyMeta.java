package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.validation.AnnaDsbEmptyTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbEmptyValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbEmptyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbEmpty.class)
public class AnnaDsbEmptyMeta implements RosettaMetaData<AnnaDsbEmpty> {

	@Override
	public List<Validator<? super AnnaDsbEmpty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbEmpty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbEmpty> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbEmpty>create(AnnaDsbEmptyValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbEmpty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbEmpty>create(AnnaDsbEmptyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbEmpty> validator() {
		return new AnnaDsbEmptyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbEmpty> typeFormatValidator() {
		return new AnnaDsbEmptyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbEmpty, Set<String>> onlyExistsValidator() {
		return new AnnaDsbEmptyOnlyExistsValidator();
	}
}
