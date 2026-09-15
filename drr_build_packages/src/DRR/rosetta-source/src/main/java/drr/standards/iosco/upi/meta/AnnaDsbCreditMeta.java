package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCredit;
import drr.standards.iosco.upi.validation.AnnaDsbCreditTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbCreditValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbCreditOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbCredit.class)
public class AnnaDsbCreditMeta implements RosettaMetaData<AnnaDsbCredit> {

	@Override
	public List<Validator<? super AnnaDsbCredit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbCredit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbCredit> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbCredit>create(AnnaDsbCreditValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbCredit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbCredit>create(AnnaDsbCreditTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCredit> validator() {
		return new AnnaDsbCreditValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCredit> typeFormatValidator() {
		return new AnnaDsbCreditTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbCredit, Set<String>> onlyExistsValidator() {
		return new AnnaDsbCreditOnlyExistsValidator();
	}
}
