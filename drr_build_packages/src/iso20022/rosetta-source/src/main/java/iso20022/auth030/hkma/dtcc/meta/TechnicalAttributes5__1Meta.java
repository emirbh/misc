package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.TechnicalAttributes5__1;
import iso20022.auth030.hkma.dtcc.validation.TechnicalAttributes5__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.TechnicalAttributes5__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.TechnicalAttributes5__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TechnicalAttributes5__1.class)
public class TechnicalAttributes5__1Meta implements RosettaMetaData<TechnicalAttributes5__1> {

	@Override
	public List<Validator<? super TechnicalAttributes5__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TechnicalAttributes5__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TechnicalAttributes5__1> validator(ValidatorFactory factory) {
		return factory.<TechnicalAttributes5__1>create(TechnicalAttributes5__1Validator.class);
	}

	@Override
	public Validator<? super TechnicalAttributes5__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TechnicalAttributes5__1>create(TechnicalAttributes5__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalAttributes5__1> validator() {
		return new TechnicalAttributes5__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TechnicalAttributes5__1> typeFormatValidator() {
		return new TechnicalAttributes5__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TechnicalAttributes5__1, Set<String>> onlyExistsValidator() {
		return new TechnicalAttributes5__1OnlyExistsValidator();
	}
}
