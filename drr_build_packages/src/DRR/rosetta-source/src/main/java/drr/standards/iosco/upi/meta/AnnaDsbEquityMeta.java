package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEquity;
import drr.standards.iosco.upi.validation.AnnaDsbEquityTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbEquityValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbEquityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbEquity.class)
public class AnnaDsbEquityMeta implements RosettaMetaData<AnnaDsbEquity> {

	@Override
	public List<Validator<? super AnnaDsbEquity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbEquity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbEquity> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbEquity>create(AnnaDsbEquityValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbEquity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbEquity>create(AnnaDsbEquityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbEquity> validator() {
		return new AnnaDsbEquityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbEquity> typeFormatValidator() {
		return new AnnaDsbEquityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbEquity, Set<String>> onlyExistsValidator() {
		return new AnnaDsbEquityOnlyExistsValidator();
	}
}
