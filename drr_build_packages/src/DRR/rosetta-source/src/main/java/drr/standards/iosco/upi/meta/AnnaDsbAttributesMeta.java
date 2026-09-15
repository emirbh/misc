package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import drr.standards.iosco.upi.validation.AnnaDsbAttributesTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbAttributesValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbAttributesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbAttributes.class)
public class AnnaDsbAttributesMeta implements RosettaMetaData<AnnaDsbAttributes> {

	@Override
	public List<Validator<? super AnnaDsbAttributes>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbAttributes, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbAttributes> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbAttributes>create(AnnaDsbAttributesValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbAttributes> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbAttributes>create(AnnaDsbAttributesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAttributes> validator() {
		return new AnnaDsbAttributesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAttributes> typeFormatValidator() {
		return new AnnaDsbAttributesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbAttributes, Set<String>> onlyExistsValidator() {
		return new AnnaDsbAttributesOnlyExistsValidator();
	}
}
