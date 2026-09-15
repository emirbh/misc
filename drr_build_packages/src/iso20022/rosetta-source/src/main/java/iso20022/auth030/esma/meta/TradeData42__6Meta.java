package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TradeData42__6;
import iso20022.auth030.esma.validation.TradeData42__6TypeFormatValidator;
import iso20022.auth030.esma.validation.TradeData42__6Validator;
import iso20022.auth030.esma.validation.exists.TradeData42__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__6.class)
public class TradeData42__6Meta implements RosettaMetaData<TradeData42__6> {

	@Override
	public List<Validator<? super TradeData42__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__6> validator(ValidatorFactory factory) {
		return factory.<TradeData42__6>create(TradeData42__6Validator.class);
	}

	@Override
	public Validator<? super TradeData42__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__6>create(TradeData42__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__6> validator() {
		return new TradeData42__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__6> typeFormatValidator() {
		return new TradeData42__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__6, Set<String>> onlyExistsValidator() {
		return new TradeData42__6OnlyExistsValidator();
	}
}
