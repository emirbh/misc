package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.InterestRate33Choice__2;
import iso20022.auth030.asic.validation.InterestRate33Choice__2TypeFormatValidator;
import iso20022.auth030.asic.validation.InterestRate33Choice__2Validator;
import iso20022.auth030.asic.validation.datarule.InterestRate33Choice__2Choice;
import iso20022.auth030.asic.validation.exists.InterestRate33Choice__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRate33Choice__2.class)
public class InterestRate33Choice__2Meta implements RosettaMetaData<InterestRate33Choice__2> {

	@Override
	public List<Validator<? super InterestRate33Choice__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestRate33Choice__2>create(InterestRate33Choice__2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestRate33Choice__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRate33Choice__2> validator(ValidatorFactory factory) {
		return factory.<InterestRate33Choice__2>create(InterestRate33Choice__2Validator.class);
	}

	@Override
	public Validator<? super InterestRate33Choice__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRate33Choice__2>create(InterestRate33Choice__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRate33Choice__2> validator() {
		return new InterestRate33Choice__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRate33Choice__2> typeFormatValidator() {
		return new InterestRate33Choice__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRate33Choice__2, Set<String>> onlyExistsValidator() {
		return new InterestRate33Choice__2OnlyExistsValidator();
	}
}
