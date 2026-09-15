package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import drr.standards.iosco.upi.validation.AnnaDsbNRGYTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbNRGYValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbNRGYOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbNRGY.class)
public class AnnaDsbNRGYMeta implements RosettaMetaData<AnnaDsbNRGY> {

	@Override
	public List<Validator<? super AnnaDsbNRGY>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbNRGY, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbNRGY> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbNRGY>create(AnnaDsbNRGYValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbNRGY> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbNRGY>create(AnnaDsbNRGYTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbNRGY> validator() {
		return new AnnaDsbNRGYValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbNRGY> typeFormatValidator() {
		return new AnnaDsbNRGYTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbNRGY, Set<String>> onlyExistsValidator() {
		return new AnnaDsbNRGYOnlyExistsValidator();
	}
}
