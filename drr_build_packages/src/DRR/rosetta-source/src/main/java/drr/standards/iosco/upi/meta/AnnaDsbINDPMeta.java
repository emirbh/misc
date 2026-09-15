package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbINDP;
import drr.standards.iosco.upi.validation.AnnaDsbINDPTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbINDPValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbINDPOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbINDP.class)
public class AnnaDsbINDPMeta implements RosettaMetaData<AnnaDsbINDP> {

	@Override
	public List<Validator<? super AnnaDsbINDP>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbINDP, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbINDP> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbINDP>create(AnnaDsbINDPValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbINDP> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbINDP>create(AnnaDsbINDPTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbINDP> validator() {
		return new AnnaDsbINDPValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbINDP> typeFormatValidator() {
		return new AnnaDsbINDPTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbINDP, Set<String>> onlyExistsValidator() {
		return new AnnaDsbINDPOnlyExistsValidator();
	}
}
