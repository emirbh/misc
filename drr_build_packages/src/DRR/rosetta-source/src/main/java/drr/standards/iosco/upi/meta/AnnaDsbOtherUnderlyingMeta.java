package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import drr.standards.iosco.upi.validation.AnnaDsbOtherUnderlyingTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbOtherUnderlyingValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbOtherUnderlyingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbOtherUnderlying.class)
public class AnnaDsbOtherUnderlyingMeta implements RosettaMetaData<AnnaDsbOtherUnderlying> {

	@Override
	public List<Validator<? super AnnaDsbOtherUnderlying>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbOtherUnderlying, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbOtherUnderlying> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherUnderlying>create(AnnaDsbOtherUnderlyingValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbOtherUnderlying> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherUnderlying>create(AnnaDsbOtherUnderlyingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherUnderlying> validator() {
		return new AnnaDsbOtherUnderlyingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherUnderlying> typeFormatValidator() {
		return new AnnaDsbOtherUnderlyingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbOtherUnderlying, Set<String>> onlyExistsValidator() {
		return new AnnaDsbOtherUnderlyingOnlyExistsValidator();
	}
}
