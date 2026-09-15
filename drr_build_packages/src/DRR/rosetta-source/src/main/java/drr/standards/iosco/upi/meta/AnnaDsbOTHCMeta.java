package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import drr.standards.iosco.upi.validation.AnnaDsbOTHCTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbOTHCValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbOTHCOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbOTHC.class)
public class AnnaDsbOTHCMeta implements RosettaMetaData<AnnaDsbOTHC> {

	@Override
	public List<Validator<? super AnnaDsbOTHC>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbOTHC, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbOTHC> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbOTHC>create(AnnaDsbOTHCValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbOTHC> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbOTHC>create(AnnaDsbOTHCTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOTHC> validator() {
		return new AnnaDsbOTHCValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbOTHC> typeFormatValidator() {
		return new AnnaDsbOTHCTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbOTHC, Set<String>> onlyExistsValidator() {
		return new AnnaDsbOTHCOnlyExistsValidator();
	}
}
