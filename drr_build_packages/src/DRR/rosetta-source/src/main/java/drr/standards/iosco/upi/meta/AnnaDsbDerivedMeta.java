package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.validation.AnnaDsbDerivedTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbDerivedValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbDerivedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbDerived.class)
public class AnnaDsbDerivedMeta implements RosettaMetaData<AnnaDsbDerived> {

	@Override
	public List<Validator<? super AnnaDsbDerived>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbDerived, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbDerived> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbDerived>create(AnnaDsbDerivedValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbDerived> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbDerived>create(AnnaDsbDerivedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbDerived> validator() {
		return new AnnaDsbDerivedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbDerived> typeFormatValidator() {
		return new AnnaDsbDerivedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbDerived, Set<String>> onlyExistsValidator() {
		return new AnnaDsbDerivedOnlyExistsValidator();
	}
}
