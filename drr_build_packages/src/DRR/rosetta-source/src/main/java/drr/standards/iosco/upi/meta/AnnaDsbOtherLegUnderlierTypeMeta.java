package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierType;
import drr.standards.iosco.upi.validation.AnnaDsbOtherLegUnderlierTypeTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbOtherLegUnderlierTypeValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbOtherLegUnderlierTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbOtherLegUnderlierType.class)
public class AnnaDsbOtherLegUnderlierTypeMeta implements RosettaMetaData<AnnaDsbOtherLegUnderlierType> {

	@Override
	public List<Validator<? super AnnaDsbOtherLegUnderlierType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbOtherLegUnderlierType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlierType> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherLegUnderlierType>create(AnnaDsbOtherLegUnderlierTypeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbOtherLegUnderlierType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbOtherLegUnderlierType>create(AnnaDsbOtherLegUnderlierTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlierType> validator() {
		return new AnnaDsbOtherLegUnderlierTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOtherLegUnderlierType> typeFormatValidator() {
		return new AnnaDsbOtherLegUnderlierTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbOtherLegUnderlierType, Set<String>> onlyExistsValidator() {
		return new AnnaDsbOtherLegUnderlierTypeOnlyExistsValidator();
	}
}
