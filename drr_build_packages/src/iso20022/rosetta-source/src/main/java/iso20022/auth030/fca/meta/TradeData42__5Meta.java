package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeData42__5;
import iso20022.auth030.fca.validation.TradeData42__5TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeData42__5Validator;
import iso20022.auth030.fca.validation.exists.TradeData42__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__5.class)
public class TradeData42__5Meta implements RosettaMetaData<TradeData42__5> {

	@Override
	public List<Validator<? super TradeData42__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__5> validator(ValidatorFactory factory) {
		return factory.<TradeData42__5>create(TradeData42__5Validator.class);
	}

	@Override
	public Validator<? super TradeData42__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__5>create(TradeData42__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__5> validator() {
		return new TradeData42__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__5> typeFormatValidator() {
		return new TradeData42__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__5, Set<String>> onlyExistsValidator() {
		return new TradeData42__5OnlyExistsValidator();
	}
}
