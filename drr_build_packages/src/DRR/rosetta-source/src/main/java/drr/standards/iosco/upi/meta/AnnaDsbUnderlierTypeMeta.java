package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlierType;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlierTypeTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlierTypeValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlierTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlierType.class)
public class AnnaDsbUnderlierTypeMeta implements RosettaMetaData<AnnaDsbUnderlierType> {

	@Override
	public List<Validator<? super AnnaDsbUnderlierType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlierType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlierType> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlierType>create(AnnaDsbUnderlierTypeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlierType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlierType>create(AnnaDsbUnderlierTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlierType> validator() {
		return new AnnaDsbUnderlierTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlierType> typeFormatValidator() {
		return new AnnaDsbUnderlierTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlierType, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlierTypeOnlyExistsValidator();
	}
}
