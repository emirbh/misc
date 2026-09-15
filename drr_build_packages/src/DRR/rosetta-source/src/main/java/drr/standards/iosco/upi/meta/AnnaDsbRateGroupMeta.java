package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbRateGroup;
import drr.standards.iosco.upi.validation.AnnaDsbRateGroupTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbRateGroupValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbRateGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbRateGroup.class)
public class AnnaDsbRateGroupMeta implements RosettaMetaData<AnnaDsbRateGroup> {

	@Override
	public List<Validator<? super AnnaDsbRateGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbRateGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbRateGroup> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbRateGroup>create(AnnaDsbRateGroupValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbRateGroup> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbRateGroup>create(AnnaDsbRateGroupTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRateGroup> validator() {
		return new AnnaDsbRateGroupValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRateGroup> typeFormatValidator() {
		return new AnnaDsbRateGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbRateGroup, Set<String>> onlyExistsValidator() {
		return new AnnaDsbRateGroupOnlyExistsValidator();
	}
}
