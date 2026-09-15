package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.BasketConstituents3__1;
import iso20022.auth030.hkma.dtcc.validation.BasketConstituents3__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.BasketConstituents3__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.BasketConstituents3__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasketConstituents3__1.class)
public class BasketConstituents3__1Meta implements RosettaMetaData<BasketConstituents3__1> {

	@Override
	public List<Validator<? super BasketConstituents3__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketConstituents3__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketConstituents3__1> validator(ValidatorFactory factory) {
		return factory.<BasketConstituents3__1>create(BasketConstituents3__1Validator.class);
	}

	@Override
	public Validator<? super BasketConstituents3__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketConstituents3__1>create(BasketConstituents3__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituents3__1> validator() {
		return new BasketConstituents3__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituents3__1> typeFormatValidator() {
		return new BasketConstituents3__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketConstituents3__1, Set<String>> onlyExistsValidator() {
		return new BasketConstituents3__1OnlyExistsValidator();
	}
}
