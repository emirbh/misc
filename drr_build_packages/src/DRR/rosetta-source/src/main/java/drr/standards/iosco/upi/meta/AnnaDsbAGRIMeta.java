package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.validation.AnnaDsbAGRITypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbAGRIValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbAGRIOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbAGRI.class)
public class AnnaDsbAGRIMeta implements RosettaMetaData<AnnaDsbAGRI> {

	@Override
	public List<Validator<? super AnnaDsbAGRI>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbAGRI, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbAGRI> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbAGRI>create(AnnaDsbAGRIValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbAGRI> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbAGRI>create(AnnaDsbAGRITypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAGRI> validator() {
		return new AnnaDsbAGRIValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAGRI> typeFormatValidator() {
		return new AnnaDsbAGRITypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbAGRI, Set<String>> onlyExistsValidator() {
		return new AnnaDsbAGRIOnlyExistsValidator();
	}
}
