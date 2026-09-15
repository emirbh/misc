package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbENVR;
import drr.standards.iosco.upi.validation.AnnaDsbENVRTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbENVRValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbENVROnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbENVR.class)
public class AnnaDsbENVRMeta implements RosettaMetaData<AnnaDsbENVR> {

	@Override
	public List<Validator<? super AnnaDsbENVR>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbENVR, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbENVR> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbENVR>create(AnnaDsbENVRValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbENVR> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbENVR>create(AnnaDsbENVRTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbENVR> validator() {
		return new AnnaDsbENVRValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbENVR> typeFormatValidator() {
		return new AnnaDsbENVRTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbENVR, Set<String>> onlyExistsValidator() {
		return new AnnaDsbENVROnlyExistsValidator();
	}
}
