package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlyingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlying.class)
public class AnnaDsbUnderlyingMeta implements RosettaMetaData<AnnaDsbUnderlying> {

	@Override
	public List<Validator<? super AnnaDsbUnderlying>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlying, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlying> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlying>create(AnnaDsbUnderlyingValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlying> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlying>create(AnnaDsbUnderlyingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlying> validator() {
		return new AnnaDsbUnderlyingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlying> typeFormatValidator() {
		return new AnnaDsbUnderlyingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlying, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlyingOnlyExistsValidator();
	}
}
