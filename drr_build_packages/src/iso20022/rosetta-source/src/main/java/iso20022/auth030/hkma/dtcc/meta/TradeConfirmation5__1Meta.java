package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.TradeConfirmation5__1;
import iso20022.auth030.hkma.dtcc.validation.TradeConfirmation5__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.TradeConfirmation5__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.TradeConfirmation5__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeConfirmation5__1.class)
public class TradeConfirmation5__1Meta implements RosettaMetaData<TradeConfirmation5__1> {

	@Override
	public List<Validator<? super TradeConfirmation5__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeConfirmation5__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeConfirmation5__1> validator(ValidatorFactory factory) {
		return factory.<TradeConfirmation5__1>create(TradeConfirmation5__1Validator.class);
	}

	@Override
	public Validator<? super TradeConfirmation5__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeConfirmation5__1>create(TradeConfirmation5__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation5__1> validator() {
		return new TradeConfirmation5__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeConfirmation5__1> typeFormatValidator() {
		return new TradeConfirmation5__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeConfirmation5__1, Set<String>> onlyExistsValidator() {
		return new TradeConfirmation5__1OnlyExistsValidator();
	}
}
