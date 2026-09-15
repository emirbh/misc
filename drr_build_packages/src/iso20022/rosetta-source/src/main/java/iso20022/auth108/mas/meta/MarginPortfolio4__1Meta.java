package iso20022.auth108.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.mas.MarginPortfolio4__1;
import iso20022.auth108.mas.validation.MarginPortfolio4__1TypeFormatValidator;
import iso20022.auth108.mas.validation.MarginPortfolio4__1Validator;
import iso20022.auth108.mas.validation.exists.MarginPortfolio4__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginPortfolio4__1.class)
public class MarginPortfolio4__1Meta implements RosettaMetaData<MarginPortfolio4__1> {

	@Override
	public List<Validator<? super MarginPortfolio4__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginPortfolio4__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginPortfolio4__1> validator(ValidatorFactory factory) {
		return factory.<MarginPortfolio4__1>create(MarginPortfolio4__1Validator.class);
	}

	@Override
	public Validator<? super MarginPortfolio4__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginPortfolio4__1>create(MarginPortfolio4__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio4__1> validator() {
		return new MarginPortfolio4__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio4__1> typeFormatValidator() {
		return new MarginPortfolio4__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginPortfolio4__1, Set<String>> onlyExistsValidator() {
		return new MarginPortfolio4__1OnlyExistsValidator();
	}
}
