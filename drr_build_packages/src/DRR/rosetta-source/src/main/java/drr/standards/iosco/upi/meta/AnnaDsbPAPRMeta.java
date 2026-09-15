package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import drr.standards.iosco.upi.validation.AnnaDsbPAPRTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbPAPRValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbPAPROnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbPAPR.class)
public class AnnaDsbPAPRMeta implements RosettaMetaData<AnnaDsbPAPR> {

	@Override
	public List<Validator<? super AnnaDsbPAPR>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbPAPR, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbPAPR> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbPAPR>create(AnnaDsbPAPRValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbPAPR> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbPAPR>create(AnnaDsbPAPRTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbPAPR> validator() {
		return new AnnaDsbPAPRValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbPAPR> typeFormatValidator() {
		return new AnnaDsbPAPRTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbPAPR, Set<String>> onlyExistsValidator() {
		return new AnnaDsbPAPROnlyExistsValidator();
	}
}
