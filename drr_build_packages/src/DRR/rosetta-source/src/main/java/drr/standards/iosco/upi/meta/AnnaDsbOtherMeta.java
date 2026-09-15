package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOther;
import drr.standards.iosco.upi.validation.AnnaDsbOtherTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbOtherValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbOtherOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbOther.class)
public class AnnaDsbOtherMeta implements RosettaMetaData<AnnaDsbOther> {

	@Override
	public List<Validator<? super AnnaDsbOther>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbOther, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbOther> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbOther>create(AnnaDsbOtherValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbOther> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbOther>create(AnnaDsbOtherTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOther> validator() {
		return new AnnaDsbOtherValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOther> typeFormatValidator() {
		return new AnnaDsbOtherTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbOther, Set<String>> onlyExistsValidator() {
		return new AnnaDsbOtherOnlyExistsValidator();
	}
}
