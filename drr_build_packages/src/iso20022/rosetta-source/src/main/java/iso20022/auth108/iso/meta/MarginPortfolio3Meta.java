package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginPortfolio3;
import iso20022.auth108.iso.validation.MarginPortfolio3TypeFormatValidator;
import iso20022.auth108.iso.validation.MarginPortfolio3Validator;
import iso20022.auth108.iso.validation.exists.MarginPortfolio3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MarginPortfolio3.class)
public class MarginPortfolio3Meta implements RosettaMetaData<MarginPortfolio3> {

	@Override
	public List<Validator<? super MarginPortfolio3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginPortfolio3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginPortfolio3> validator(ValidatorFactory factory) {
		return factory.<MarginPortfolio3>create(MarginPortfolio3Validator.class);
	}

	@Override
	public Validator<? super MarginPortfolio3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarginPortfolio3>create(MarginPortfolio3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio3> validator() {
		return new MarginPortfolio3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super MarginPortfolio3> typeFormatValidator() {
		return new MarginPortfolio3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginPortfolio3, Set<String>> onlyExistsValidator() {
		return new MarginPortfolio3OnlyExistsValidator();
	}
}
