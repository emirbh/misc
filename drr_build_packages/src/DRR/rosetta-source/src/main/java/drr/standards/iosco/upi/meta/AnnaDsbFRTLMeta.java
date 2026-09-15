package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import drr.standards.iosco.upi.validation.AnnaDsbFRTLTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbFRTLValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbFRTLOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbFRTL.class)
public class AnnaDsbFRTLMeta implements RosettaMetaData<AnnaDsbFRTL> {

	@Override
	public List<Validator<? super AnnaDsbFRTL>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbFRTL, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbFRTL> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbFRTL>create(AnnaDsbFRTLValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbFRTL> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbFRTL>create(AnnaDsbFRTLTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbFRTL> validator() {
		return new AnnaDsbFRTLValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbFRTL> typeFormatValidator() {
		return new AnnaDsbFRTLTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbFRTL, Set<String>> onlyExistsValidator() {
		return new AnnaDsbFRTLOnlyExistsValidator();
	}
}
