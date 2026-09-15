package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TradeData42__1;
import iso20022.auth030.esma.validation.TradeData42__1TypeFormatValidator;
import iso20022.auth030.esma.validation.TradeData42__1Validator;
import iso20022.auth030.esma.validation.exists.TradeData42__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__1.class)
public class TradeData42__1Meta implements RosettaMetaData<TradeData42__1> {

	@Override
	public List<Validator<? super TradeData42__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__1> validator(ValidatorFactory factory) {
		return factory.<TradeData42__1>create(TradeData42__1Validator.class);
	}

	@Override
	public Validator<? super TradeData42__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__1>create(TradeData42__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__1> validator() {
		return new TradeData42__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__1> typeFormatValidator() {
		return new TradeData42__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__1, Set<String>> onlyExistsValidator() {
		return new TradeData42__1OnlyExistsValidator();
	}
}
