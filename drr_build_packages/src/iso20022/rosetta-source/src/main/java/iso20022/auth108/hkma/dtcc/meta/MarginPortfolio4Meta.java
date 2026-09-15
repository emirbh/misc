package iso20022.auth108.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.MarginPortfolio4;
import iso20022.auth108.hkma.dtcc.validation.MarginPortfolio4TypeFormatValidator;
import iso20022.auth108.hkma.dtcc.validation.MarginPortfolio4Validator;
import iso20022.auth108.hkma.dtcc.validation.exists.MarginPortfolio4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginPortfolio4.class)
public class MarginPortfolio4Meta implements RosettaMetaData<MarginPortfolio4> {

	@Override
	public List<Validator<? super MarginPortfolio4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginPortfolio4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginPortfolio4> validator(ValidatorFactory factory) {
		return factory.<MarginPortfolio4>create(MarginPortfolio4Validator.class);
	}

	@Override
	public Validator<? super MarginPortfolio4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginPortfolio4>create(MarginPortfolio4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio4> validator() {
		return new MarginPortfolio4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio4> typeFormatValidator() {
		return new MarginPortfolio4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginPortfolio4, Set<String>> onlyExistsValidator() {
		return new MarginPortfolio4OnlyExistsValidator();
	}
}
