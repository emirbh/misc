package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbMETL;
import drr.standards.iosco.upi.validation.AnnaDsbMETLTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbMETLValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbMETLOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbMETL.class)
public class AnnaDsbMETLMeta implements RosettaMetaData<AnnaDsbMETL> {

	@Override
	public List<Validator<? super AnnaDsbMETL>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbMETL, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbMETL> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbMETL>create(AnnaDsbMETLValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbMETL> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbMETL>create(AnnaDsbMETLTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbMETL> validator() {
		return new AnnaDsbMETLValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbMETL> typeFormatValidator() {
		return new AnnaDsbMETLTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbMETL, Set<String>> onlyExistsValidator() {
		return new AnnaDsbMETLOnlyExistsValidator();
	}
}
