package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TradeTransaction49__2;
import iso20022.auth030.esma.validation.TradeTransaction49__2TypeFormatValidator;
import iso20022.auth030.esma.validation.TradeTransaction49__2Validator;
import iso20022.auth030.esma.validation.exists.TradeTransaction49__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction49__2.class)
public class TradeTransaction49__2Meta implements RosettaMetaData<TradeTransaction49__2> {

	@Override
	public List<Validator<? super TradeTransaction49__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction49__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction49__2> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction49__2>create(TradeTransaction49__2Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction49__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction49__2>create(TradeTransaction49__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction49__2> validator() {
		return new TradeTransaction49__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction49__2> typeFormatValidator() {
		return new TradeTransaction49__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction49__2, Set<String>> onlyExistsValidator() {
		return new TradeTransaction49__2OnlyExistsValidator();
	}
}
