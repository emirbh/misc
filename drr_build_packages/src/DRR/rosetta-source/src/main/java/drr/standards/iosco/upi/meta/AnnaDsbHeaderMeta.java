package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.validation.AnnaDsbHeaderTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbHeaderValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbHeader.class)
public class AnnaDsbHeaderMeta implements RosettaMetaData<AnnaDsbHeader> {

	@Override
	public List<Validator<? super AnnaDsbHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbHeader> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbHeader>create(AnnaDsbHeaderValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbHeader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbHeader>create(AnnaDsbHeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbHeader> validator() {
		return new AnnaDsbHeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbHeader> typeFormatValidator() {
		return new AnnaDsbHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbHeader, Set<String>> onlyExistsValidator() {
		return new AnnaDsbHeaderOnlyExistsValidator();
	}
}
