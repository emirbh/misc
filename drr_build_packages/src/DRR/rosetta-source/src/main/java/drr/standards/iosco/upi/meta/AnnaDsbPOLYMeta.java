package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbPOLY;
import drr.standards.iosco.upi.validation.AnnaDsbPOLYTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbPOLYValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbPOLYOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbPOLY.class)
public class AnnaDsbPOLYMeta implements RosettaMetaData<AnnaDsbPOLY> {

	@Override
	public List<Validator<? super AnnaDsbPOLY>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbPOLY, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbPOLY> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbPOLY>create(AnnaDsbPOLYValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbPOLY> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbPOLY>create(AnnaDsbPOLYTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbPOLY> validator() {
		return new AnnaDsbPOLYValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbPOLY> typeFormatValidator() {
		return new AnnaDsbPOLYTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbPOLY, Set<String>> onlyExistsValidator() {
		return new AnnaDsbPOLYOnlyExistsValidator();
	}
}
