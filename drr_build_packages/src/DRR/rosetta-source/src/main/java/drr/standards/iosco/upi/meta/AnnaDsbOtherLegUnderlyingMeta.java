package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.validation.AnnaDsbOtherLegUnderlyingTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbOtherLegUnderlyingValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbOtherLegUnderlyingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbOtherLegUnderlying.class)
public class AnnaDsbOtherLegUnderlyingMeta implements RosettaMetaData<AnnaDsbOtherLegUnderlying> {

	@Override
	public List<Validator<? super AnnaDsbOtherLegUnderlying>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbOtherLegUnderlying, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlying> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherLegUnderlying>create(AnnaDsbOtherLegUnderlyingValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbOtherLegUnderlying> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherLegUnderlying>create(AnnaDsbOtherLegUnderlyingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlying> validator() {
		return new AnnaDsbOtherLegUnderlyingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlying> typeFormatValidator() {
		return new AnnaDsbOtherLegUnderlyingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbOtherLegUnderlying, Set<String>> onlyExistsValidator() {
		return new AnnaDsbOtherLegUnderlyingOnlyExistsValidator();
	}
}
