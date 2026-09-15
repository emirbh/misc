package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TechnicalAttributes6;
import iso20022.auth108.iso.validation.TechnicalAttributes6TypeFormatValidator;
import iso20022.auth108.iso.validation.TechnicalAttributes6Validator;
import iso20022.auth108.iso.validation.exists.TechnicalAttributes6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TechnicalAttributes6.class)
public class TechnicalAttributes6Meta implements RosettaMetaData<TechnicalAttributes6> {

	@Override
	public List<Validator<? super TechnicalAttributes6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TechnicalAttributes6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TechnicalAttributes6> validator(ValidatorFactory factory) {
		return factory.<TechnicalAttributes6>create(TechnicalAttributes6Validator.class);
	}

	@Override
	public Validator<? super TechnicalAttributes6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TechnicalAttributes6>create(TechnicalAttributes6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalAttributes6> validator() {
		return new TechnicalAttributes6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalAttributes6> typeFormatValidator() {
		return new TechnicalAttributes6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TechnicalAttributes6, Set<String>> onlyExistsValidator() {
		return new TechnicalAttributes6OnlyExistsValidator();
	}
}
